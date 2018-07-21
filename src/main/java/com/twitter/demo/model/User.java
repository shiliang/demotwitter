package com.twitter.demo.model;/*
 * @program:com.twitter.demo.model
 * @description:用户实体类
 * @author:shiliang
 * @create:2018-05-15 23:13
 * */


import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String salt;
    private String headUrl;

    public User() {

    }
    public User(String name) {
        this.username = name;
        this.password = "";
        this.salt = "";
        this.headUrl = "";
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }






}
