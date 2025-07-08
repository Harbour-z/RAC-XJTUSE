package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.model.dto.MerchantRegisterDTO;
import com.example.mybatisplusdemo.model.dto.RegisterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
@Slf4j
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

    // 商家用户注册
    @PostMapping("/register")
    public Result<MerchantInfo> newUser(@RequestBody MerchantRegisterDTO registerDTO){
        if(registerDTO.getUsername()=="" || registerDTO.getPassword()==""){
            return Result.failure("用户名或密码不能为空！");
        }
        if(registerDTO.getUsername()==null || registerDTO.getPassword()==null){
            return Result.failure("缺少用户信息！");
        }

        QueryWrapper<MerchantInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",registerDTO.getUsername());
        if(merchantInfoService.getOne(queryWrapper)!=null){
            Result res = Result.failure("用户名不能重复注册！");
            res.setCode(100);
            return res;
        }

        MerchantInfo merchant = new MerchantInfo();
        BeanUtils.copyProperties(registerDTO,merchant);
        boolean res = merchantInfoService.save(merchant);
        log.info("res:{}",res);
        return res ?Result.success(merchant):Result.failure("注册失败");
    }

    //商家注册店铺
//    @PostMapping("/register")
//    public Result<UserInfo> newMerchant(@RequestBody RegisterDTO registerDTO){
//        if(registerDTO.getUsername()=="" || registerDTO.getPassword()==""){
//            return Result.failure("用户名或密码不能为空！");
//        }
//        if(registerDTO.getUsername()==null || registerDTO.getPassword()==null){
//            return Result.failure("缺少用户信息！");
//        }
//        UserInfo user = new UserInfo();
//        BeanUtils.copyProperties(registerDTO,user);
//        boolean res = userInfoService.save(user);
//        log.info("res:{}",res);
//        return res ?Result.success(user):Result.failure("注册失败");
//    }
}

