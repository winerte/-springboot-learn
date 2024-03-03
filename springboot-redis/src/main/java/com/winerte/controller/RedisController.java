package com.winerte.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/get/{key}")
    public String getRedisKey(@PathVariable("key")String key){
        String s = (String) redisTemplate.opsForValue().get(key);

        return s;
    }
    @GetMapping("/add")
    public String addRedis(){
        for (int i= 0; i<10 ; i++){
            redisTemplate.opsForValue().set(String.valueOf(i),"value"+i);
        }
        return "执行完成";
    }
}
