package com.example.mybatisplusdemo;

import com.example.mybatisplusdemo.mapper.UserInfoMapper;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusDemoApplicationTests {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void hh() {
        for (int i = 1; i < 100; i++) {
        UserInfo user = new UserInfo().setPassword("333").setUsername("Testuser" + i);
        userInfoMapper.insert(user);
    }
    }
}

