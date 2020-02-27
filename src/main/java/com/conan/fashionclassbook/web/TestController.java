package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/redis")
    public ServerResponse redis() {
        redisTemplate.opsForValue().set("test", 123, 60 , TimeUnit.SECONDS);
        return ServerResponse.createBySuccess();
    }
}
