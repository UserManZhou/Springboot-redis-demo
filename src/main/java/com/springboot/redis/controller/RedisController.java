package com.springboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundKeyOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisTest")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BoundSetOperations boundSetOperations;

    @GetMapping("/getdata")
    public String getdata(){
        // 具体文档请看https://docs.spring.io/spring-data/redis/docs/current/api/
        redisTemplate.opsForValue().set("name", "xiaozhang");

        String name = (String) redisTemplate.opsForValue().get("name");
        boundSetOperations.add("name");

        return name;
    }
}
