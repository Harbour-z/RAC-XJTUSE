package com.example.mybatisplusdemo;

import com.example.mybatisplusdemo.mapper.OrdersMapper;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusDemoApplicationTests {
    // 注入方法
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private OrdersMapper ordersMapper;

}

