package com.twitter.demo.service;/*
 * @program:com.twitter.demo.service
 * @description:消息订阅
 * @author:shiliang
 * @create:2018-06-03 19:13
 * */

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.ArrayList;
import java.util.List;

public class MessageSubscriber implements MessageListener {
    public static List<String> messageList = new ArrayList<>();
    @Override
    public void onMessage(Message message, byte[] bytes) {
        messageList.add(message.toString());
        System.out.println("Message received: " + new String(message.getBody()));
    }
}
