package com.twitter.demo.service.impl;/*
 * @program:com.twitter.demo.service.impl
 * @description:推送实现类
 * @author:shiliang
 * @create:2018-06-03 15:41
 * */

import com.twitter.demo.service.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service("messagePublisher")
public class MessagePublisherImpl implements MessagePublisher {

    private RedisTemplate<String, Object> redisTemplate;


    private ChannelTopic topic;

    public MessagePublisherImpl() {

    }

    @Autowired
    public MessagePublisherImpl(final RedisTemplate<String, Object> redisTemplate, final ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    @Override
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(),message);
    }
}
