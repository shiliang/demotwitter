package com.twitter.demo.service;/*
 * @program:com.twitter.demo.service
 * @description:用户服务
 * @author:shiliang
 * @create:2018-07-13 16:40
 * */

import com.twitter.demo.model.User;

import java.util.Map;


public interface UserService {



    public Map<String, Object> register(String username, String password);

    public Map<String, Object> login(String username, String password);

    public User getUser(int id);

    public void logout(String ticket);

}
