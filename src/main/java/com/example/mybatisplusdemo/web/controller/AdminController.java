package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IAdminService;
import com.example.mybatisplusdemo.model.domain.Admin;


/**
 *
 *  前端控制器
 *
 *
 * @author hxy
 * @since 2025-07-07
 * @version v1.0
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger( AdminController.class );

    @Autowired
    private IAdminService adminService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Admin> getById(@PathVariable("id") Long id)throws Exception {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    @PostMapping("/login")
    public Result<Admin> login(@RequestBody LoginDTO loginDTO) {
        Admin admin  = adminService.login(loginDTO);
        return Result.success(admin);
    }
}

