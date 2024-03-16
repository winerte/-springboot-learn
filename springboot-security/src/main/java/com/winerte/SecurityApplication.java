package com.winerte;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.winerte.dao")
@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(SecurityApplication.class,args);
    }
}
