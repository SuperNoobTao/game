package com.bxm.game.controller;

import com.bxm.newidea.component.redis.KeyGenerator;
import com.bxm.newidea.component.redis.RedisZSetAdapter;
import com.bxm.newidea.component.redis.impl.DefaultKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataAcceptController {

    @Autowired
    RedisZSetAdapter redisZSetAdapter;

    @PostMapping("counter/incr/{id}")
    public void accpectData(@PathVariable String id , @RequestParam Long value){
        KeyGenerator key = DefaultKeyGenerator.build("user", "sync", "id");
        key.setKey(id);
        redisZSetAdapter.add(key,System.currentTimeMillis(),value);
    }

}
