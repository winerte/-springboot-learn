package com.winerte.controller;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
@RequestMapping("/minioController")
@RestController
public class MinIOController {
    private static final String bucketName = "test";

    @RequestMapping(value = "/upload",method= RequestMethod.POST)

    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws Exception {
        try {
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("http://192.168.67.132:9000")
                            .credentials("minioadmin", "minioadmin")
                            .build();
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());

            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            } else {

                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object( file.getOriginalFilename())
                                .stream(file.getInputStream(),file.getInputStream().available(),-1)
                                .build());
            }
        } catch (MinioException e) {

            return ("MinIO 上传文件出错");
        }
        return ("上传成功");
    }
}
