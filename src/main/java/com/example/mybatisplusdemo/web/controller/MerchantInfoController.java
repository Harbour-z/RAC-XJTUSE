package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IMerchantInfoService;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;


/**
 *
 *  前端控制器
 *
 *
 * @author hxy
 * @since 2025-07-08
 * @version v1.0
 */
@RestController
@RequestMapping("/api/merchantInfo")
public class MerchantInfoController {

    private final Logger logger = LoggerFactory.getLogger( MerchantInfoController.class );

    @Autowired
    private IMerchantInfoService merchantInfoService;
    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/getInfo")
    public Result<MerchantInfo> getById(int id) throws Exception {
        MerchantInfo merchant = merchantInfoService.getById(id);
        return Result.success(merchant);
    }
    //登录商家
    @PostMapping("/login")
    public Result<MerchantInfo> login(@RequestBody LoginDTO loginDTO) {
        MerchantInfo merchant = merchantInfoService.login(loginDTO);
        return Result.success(merchant);
    }
}

