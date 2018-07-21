package com.twitter.demo;/*
 * @program:com.twitter.demo
 * @description:redis测试
 * @author:shiliang
 * @create:2018-05-16 22:43
 * */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setup() {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        String a = stringRedisTemplate.opsForValue().get("aaa");
        System.out.println(a);
    }
}
