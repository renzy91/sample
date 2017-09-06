package com.example.sample.controller;

import com.example.sample.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/6 17:48
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/insert")
    public void insert() {
        User user = new User();
        user.setId(123);
        user.setName("redis");
        user.setAge(12321);

        //设置value序列化方式
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        //设置key序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(user.getId(),user);

    }
}
