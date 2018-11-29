package com.bxm.game;

import com.bxm.newidea.component.enums.FileTypeEnum;
import com.bxm.newidea.component.redis.KeyGenerator;
import com.bxm.newidea.component.redis.RedisStringAdapter;
import com.bxm.newidea.component.redis.impl.DefaultKeyGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameApplicationTests {

    @Autowired
    private RedisStringAdapter redisStringAdapter;

    @Test
    public void contextLoads() {
        System.out.println(FileTypeEnum.getContentType("jpg"));
    }

}
