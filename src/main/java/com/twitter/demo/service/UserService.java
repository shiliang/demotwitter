package com.twitter.demo.service;/*
 * @program:com.twitter.demo.service
 * @description:用户服务
 * @author:shiliang
 * @create:2018-07-13 16:40
 * */

import com.twitter.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

}
