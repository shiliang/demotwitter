package com.twitter.demo.service.impl;/*
 * @program:com.twitter.demo.service.impl
 * @description:用户服务实现类
 * @author:shiliang
 * @create:2018-07-13 16:43
 * */

import com.twitter.demo.model.User;
import com.twitter.demo.repository.UserRepository;
import com.twitter.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

}
