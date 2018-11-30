package com.bxm.game.service.impl;

import com.bxm.game.service.DataAcceptService;
import com.bxm.newidea.component.redis.RedisZSetAdapter;
import com.bxm.newidea.component.vo.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyadong 2018/11/29 21:43
 * @desc
 */
@Service
public class DataAcceptServiceImpl implements DataAcceptService {

    @Autowired
    RedisZSetAdapter redisZSetAdapter;

    private RedisTemplate<String, Object> redisTemplate;

    public DataAcceptServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
    }

    @Override
    public Message acceptData(String id, Long value) {
        String strTime = String.valueOf(System.currentTimeMillis() / 1000);

        redisTemplate.opsForZSet().add(strTime, id, value.doubleValue());

//        KeyGenerator key = DefaultKeyGenerator.build(null, null);
//        key.copy().appendKey(strTime);
//        redisZSetAdapter.add(key, id, value);
        return Message.build(Boolean.TRUE);
    }
}
