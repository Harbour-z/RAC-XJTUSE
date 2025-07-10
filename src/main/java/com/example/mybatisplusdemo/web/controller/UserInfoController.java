package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.model.dto.PageDTO;
import com.example.mybatisplusdemo.model.dto.RegisterDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IUserInfoService;
import com.example.mybatisplusdemo.model.domain.UserInfo;

import java.time.LocalDateTime;
import java.util.List;


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
@RequestMapping("/api/userInfo")
@Slf4j
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger( UserInfoController.class );

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("listByKey")
    public Result listByKey(String key){
        List<UserInfo> userList = userInfoService.listByKey(key);
        return Result.success(userList);
    }

    @PostMapping("/register")
    public Result<UserInfo> newUser(@RequestBody RegisterDTO registerDTO){
        if(registerDTO.getUsername()=="" || registerDTO.getPassword()==""){
            return Result.failure("用户名或密码不能为空！");
        }
        if(registerDTO.getUsername()==null || registerDTO.getPassword()==null){
            return Result.failure("缺少用户信息！");
        }

        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",registerDTO.getUsername());
        if(userInfoService.getOne(queryWrapper)!=null){
            Result res = Result.failure("用户名不能重复注册！");
            res.setCode(100);
            return res;
        }

        UserInfo user = new UserInfo();
        BeanUtils.copyProperties(registerDTO,user);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        boolean res = userInfoService.save(user);
        log.info("res:{}",res);
        return res ?Result.success(user):Result.failure("注册失败");
    }

    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody LoginDTO loginDTO) {
        UserInfo user = userInfoService.login(loginDTO);
        return Result.success(user);
    }

    @GetMapping("getInfo")
    public Result getInfo(){
        UserInfo user = SessionUtils.getCurrentUserInfo();
        UserInfo one = userInfoService.getOne(new QueryWrapper<UserInfo>().eq("username",user.getUsername()));
        return Result.success(one);
    }

    @GetMapping("removeUser")
    public Result removeUser(Long id){
        boolean b = userInfoService.removeById(id);
        return Result.success(b);
    }

    @PatchMapping("/updateUser")
    public Result updateUser(@RequestBody UserInfo userInfo) {
        UserInfo existingUser = userInfoService.getById(userInfo.getId());
        if (existingUser == null) {
            return Result.failure("用户不存在");
        }
        if (userInfo.getUsername() != null && !userInfo.getUsername().equals(existingUser.getUsername())) {
            boolean isUsernameTaken = userInfoService.lambdaQuery()
                    .eq(UserInfo::getUsername, userInfo.getUsername())
                    .ne(UserInfo::getId, userInfo.getId()) // 排除当前用户
                    .count() > 0;
            if (isUsernameTaken) {
                return Result.failure("用户名已被占用");
            }
        }
        boolean success = userInfoService.updateById(userInfo);
        return success ? Result.success(success) : Result.failure("更新失败");
    }

    @GetMapping("listPage")
    public Result listPage(PageDTO pageDTO, UserInfo user){
        Page<UserInfo> page = userInfoService.listPage(pageDTO,user);
        return Result.success(page);
    }

    // 注销账户
    @DeleteMapping("/me/{username}")
    public Result deleteMe(@PathVariable String username){
        UserInfo user = userInfoService.getOne(new QueryWrapper<UserInfo>().eq("username",username));
        if(user==null){
            Result.failure("用户不存在");
        }else {
            boolean b = userInfoService.removeById(user.getId());
            return b ? Result.successMessage("Delete user successfully!"):Result.failure("Delete user failed!");
        }
        return Result.failure("Delete user failed!");
    }
}

