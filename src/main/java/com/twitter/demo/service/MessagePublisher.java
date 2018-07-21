package com.twitter.demo.service;/*
 * @program:com.twitter.demo.service
 * @description:消息推送
 * @author:shiliang
 * @create:2018-06-03 15:36
 * */

public interface MessagePublisher {
    void publish(final String message);
}
