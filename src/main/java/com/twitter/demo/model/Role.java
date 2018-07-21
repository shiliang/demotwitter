package com.twitter.demo.model;/*
 * @program:com.twitter.demo.model
 * @description:角色实体
 * @author:shiliang
 * @create:2018-05-16 18:05
 * */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public Role() {

    }

}
