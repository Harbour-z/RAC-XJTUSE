package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IUserInfoService;
import com.example.mybatisplusdemo.model.domain.UserInfo;

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
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger( UserInfoController.class );

    @Autowired
    private IUserInfoService userInfoService;

    //json数据（前后端分离必备的参数请求类型）
    //必须用对象接取参数，前段参数名匹配对象属性名
    @PostMapping("postdemo1")
    public Result s4(@RequestBody UserInfo user){
        System.out.println(user);
        return Result.success(user);
    }


    @GetMapping("listByKey")
    public Result listByKey(String key){
        List<UserInfo> userList = userInfoService.listByKey(key);
        return Result.success(userList);
    }

    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody LoginDTO loginDTO) {
        UserInfo user = userInfoService.login(loginDTO);
        return Result.success(user);
    }

    @GetMapping("getInfo")
    public Result getInfo(){
        UserInfo user = SessionUtils.getCurrentUserInfo();
        return Result.success(user);
    }

    @PostMapping("deleteUser")
    public Result<Boolean> deleteUser(@RequestBody UserInfo user) {
        boolean success = userInfoService.removeById(user.getId());
        return Result.success(success);
    }

    @GetMapping("removeUser")
    public Result removeUser(Long id){
        boolean b = userInfoService.removeById(id);
        return Result.success(b);
    }

    @PostMapping("updateUser")
    public Result updateUser(@RequestBody UserInfo user){
        boolean b = userInfoService.updateById(user);
        return Result.success(b);
    }
}

