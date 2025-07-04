package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.dto.PageDTO;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.JsonResponse;
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

//    @GetMapping("getdemo1")
//    public String s(Long id,String name) {
//        System.out.println(id);
//        System.out.println(name);
//        return name;
//    }
//
//    //建立DTO扩展属性
//    @GetMapping("getdemo2")
//    public String s2(UserDTO userDTO) {
//        System.out.println(userDTO.getId());
//        System.out.println(userDTO.getName());
//        return "hello";
//    }
//
//    @GetMapping("getdemo3/{id}/{name}")
//    public String s3(@PathVariable("id") long id) {
//        User user = userService.getById(id);
//        System.out.println(user.getLoginName());
//        return user.getLoginName();
//    }

    //json数据（前后端分离必备的参数请求类型）
    //必须用对象接取参数，前段参数名匹配对象属性名
    @PostMapping("postdemo1")
    public JsonResponse s4(@RequestBody User user){
        System.out.println(user);
        return JsonResponse.success(user);
    }

    //对比老师的
    @GetMapping("listPage")
    public JsonResponse listPage(PageDTO pageDTO,User user) {
        Page<User> page = userService.listPage(pageDTO,user);
        return JsonResponse.success(page);
    }

    @GetMapping("listByKey")
    public JsonResponse listByKey(String key){
        List<User> userList = userService.listByKey(key);
        return JsonResponse.success(userList);
    }

    @PostMapping("login")
    public JsonResponse login(@RequestBody User user){
        User login = userService.login(user);
        return JsonResponse.success(login);
    }

    @GetMapping("getInfo")
    public JsonResponse getInfo(){
        User user = SessionUtils.getCurrentUserInfo();
        return JsonResponse.success(user);
    }

    @PostMapping("deleteUser")
    public JsonResponse<Boolean> deleteUser(@RequestBody User user) {
        boolean success = userService.removeById(user.getId());
        return JsonResponse.success(success);
    }

    @GetMapping("removeUser")
    public JsonResponse removeUser(Long id){
        boolean b = userService.removeById(id);
        return JsonResponse.success(b);
    }

    @PostMapping("updateUser")
    public JsonResponse updateUser(@RequestBody User user){
        boolean b = userService.updateById(user);
        return JsonResponse.success(b);
    }
}










