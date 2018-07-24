package com.twitter.demo.service.impl;/*
 * @program:com.twitter.demo.service.impl
 * @description:用户服务实现类
 * @author:shiliang
 * @create:2018-07-13 16:43
 * */

import com.twitter.demo.model.User;
import com.twitter.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


    /**
     * @Description: 用户注册
     * @Param: 用户名，密码
     * @Return: 注册信息，如果注册成功map为空
     * @Author: shiliang
     * @Date: 2018/7/23
     */
    @Override
    public Map<String, Object> register(String username, String password) {
        return null;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void logout(String ticket) {

    }
}
