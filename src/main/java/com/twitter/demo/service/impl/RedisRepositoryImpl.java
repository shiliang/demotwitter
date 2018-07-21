package com.twitter.demo.service.impl;/*
 * @program:com.twitter.demo.service.impl
 * @description:Redis操作实现类
 * @author:shiliang
 * @create:2018-06-03 21:10
 * */

import com.twitter.demo.model.Movie;
import com.twitter.demo.service.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Movie";


    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String,String,Movie> hashOperations;


    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<Object, Object> findAllMovies() {
        return null;
    }

    @Override
    public void add(Movie movie) {
        hashOperations.put(KEY, movie.getId(), movie);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public Movie findMovie(String id) {
        return hashOperations.get(KEY, id);
    }
}
