package com.twitter.demo.application;/*
 * @program:com.twitter.demo.application
 * @description:redis配置文件 jedisConnectionFactory连接配置文件的环境
 * @author:shiliang
 * @create:2018-06-07 14:56
 * */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
public class RedisConfig {

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;



    /*@Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
                .master("mymaster")
                .sentinel("127.0.0.1", 26379)
                .sentinel("127.0.0.1", 26380);
        return new JedisConnectionFactory(sentinelConfig);
    }*/



    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        JedisPoolConfig config = new JedisPoolConfig();
        JedisConnectionFactory redisConnectionFactory =new JedisConnectionFactory();
        redisConnectionFactory.setDatabase(database);
        redisConnectionFactory.setHostName(host);
        redisConnectionFactory.setPort(port);
        redisConnectionFactory.setPoolConfig(config);
        return redisConnectionFactory;

    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        Jackson2JsonRedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(redisSerializer);
        return template;
    }


    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("messageQueue");
    }

}
