package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.model.dto.MerchantRegisterDTO;
import com.example.mybatisplusdemo.model.dto.PageDTO;
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

import java.time.LocalDateTime;


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

    //商家页面显示自己账户
    @GetMapping("getInfoMy")
    public Result getInfo(){
        MerchantInfo merchantInfo = SessionUtils.getCurrentMerchantInfo();
        MerchantInfo one = merchantInfoService.getOne(new QueryWrapper<MerchantInfo>().eq("username",merchantInfo.getUsername()));
        return Result.success(one);
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
        merchant.setCreateTime(LocalDateTime.now());
        merchant.setUpdateTime(LocalDateTime.now());
        boolean res = merchantInfoService.save(merchant);
        log.info("res:{}",res);
        return res ?Result.success(merchant):Result.failure("注册失败");
    }

    // 注销商家用户账户
    @DeleteMapping("/deleteSelf/{username}")
    public Result deleteMe(@PathVariable String username){
        MerchantInfo user = merchantInfoService.getOne(new QueryWrapper<MerchantInfo>().eq("username",username));
        if(user==null){
            Result.failure("用户不存在");
        }else {
            boolean b = merchantInfoService.removeById(user.getId());
            return b ? Result.successMessage("Delete merchant-user successfully!"):Result.failure("Delete merchant-user failed!");
        }
        return Result.failure("Delete merchant-user failed!");
    }

    @GetMapping("removeMerchant")
    public Result removeMerchant(Long id){
        boolean b = merchantInfoService.removeById(id);
        return Result.success(b);
    }

    @PatchMapping("/updateMerchant")
    public Result updateMerchant(@RequestBody MerchantInfo merchant) {
        MerchantInfo existingMerchant = merchantInfoService.getById(merchant.getId());
        if (existingMerchant == null) {
            return Result.failure("商户不存在");
        }
        if (merchant.getUsername() != null && !merchant.getUsername().equals(existingMerchant.getUsername())) {
            boolean isUsernameTaken = merchantInfoService.lambdaQuery()
                    .eq(MerchantInfo::getUsername, merchant.getUsername())
                    .ne(MerchantInfo::getId, merchant.getId()) // 排除当前用户
                    .count() > 0;
            if (isUsernameTaken) {
                return Result.failure("用户名已被占用");
            }
        }
        boolean success = merchantInfoService.updateById(merchant);
        return success ? Result.success(success) : Result.failure("更新失败");
    }

    //对商户分页查询
    @GetMapping("listPage")
    public Result listPage(PageDTO pageDTO, MerchantInfo merchant){
        Page<MerchantInfo> page = merchantInfoService.listPage(pageDTO,merchant);
        return Result.success(page);
    }

    @GetMapping("getById")
    public Result<MerchantInfo> getMerchantById(@RequestBody Long id) {
        MerchantInfo merchant = merchantInfoService.getById(id);
        if (merchant == null) {
            return Result.failure("商户不存在");
        }
        return Result.success(merchant);
    }}

