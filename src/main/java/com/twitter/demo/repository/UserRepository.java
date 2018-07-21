package com.twitter.demo.repository;/*
 * @program:com.twitter.demo.repository
 * @description:用户功能
 * @author:shiliang
 * @create:2018-07-13 21:46
 * */

import com.twitter.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findById(long id);

    void deleteById(long id);

}
