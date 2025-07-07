package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.service.IUserService;
import com.example.mybatisplusdemo.model.domain.User;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author hxy
 * @since 2025-06-17
 * @version v1.0
 */
@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger( UserController.class );

    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;



    //json数据（前后端分离必备的参数请求类型）
    //必须用对象接取参数，前段参数名匹配对象属性名
    @PostMapping("postdemo1")
    public Result s4(@RequestBody User user){
        System.out.println(user);
        return Result.success(user);
    }


    @GetMapping("listByKey")
    public Result listByKey(String key){
        List<User> userList = userService.listByKey(key);
        return Result.success(userList);
    }

    @PostMapping("/login")
    public Result<User> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO);
        return Result.success(user);
    }

    @GetMapping("getInfo")
    public Result getInfo(){
        User user = SessionUtils.getCurrentUserInfo();
        return Result.success(user);
    }

    @PostMapping("deleteUser")
    public Result<Boolean> deleteUser(@RequestBody User user) {
        boolean success = userService.removeById(user.getId());
        return Result.success(success);
    }

    @GetMapping("removeUser")
    public Result removeUser(Long id){
        boolean b = userService.removeById(id);
        return Result.success(b);
    }

    @PostMapping("updateUser")
    public Result updateUser(@RequestBody User user){
        boolean b = userService.updateById(user);
        return Result.success(b);
    }
}










