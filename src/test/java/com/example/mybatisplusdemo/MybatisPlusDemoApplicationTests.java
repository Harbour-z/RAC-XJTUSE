package com.example.mybatisplusdemo;

import com.example.mybatisplusdemo.mapper.MerchantInfoMapper;
import com.example.mybatisplusdemo.mapper.UserInfoMapper;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;
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
    @Autowired
    private MerchantInfoMapper merchantInfoMapper;

    @Test
    public void hh() {
        for (int i = 1; i < 100; i++) {
        UserInfo user = new UserInfo().setPassword("333").setUsername("Testuser" + i);
        userInfoMapper.insert(user);
        }
    }

    @Test
    public void hh1() {
        for (int i = 1; i < 100; i++) {
            MerchantInfo merchantInfo = new MerchantInfo().setPassword("333").setUsername("Testmerchant" + i);
            merchantInfoMapper.insert(merchantInfo);
        }
    }
}

