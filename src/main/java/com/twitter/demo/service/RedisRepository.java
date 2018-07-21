package com.twitter.demo.service;/*
 * @program:com.twitter.demo.service
 * @description:redis curd基本操作
 * @author:shiliang
 * @create:2018-06-03 21:01
 * */

import com.twitter.demo.model.Movie;

import java.util.Map;

public interface RedisRepository {
    Map<Object,Object> findAllMovies();
    void add(Movie movie);
    void delete(String id);
    Movie findMovie(String id);
}
