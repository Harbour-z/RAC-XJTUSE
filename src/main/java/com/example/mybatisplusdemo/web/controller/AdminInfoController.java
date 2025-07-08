package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.model.domain.Admin;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IAdminInfoService;
import com.example.mybatisplusdemo.model.domain.AdminInfo;


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
@RequestMapping("/api/adminInfo")
public class AdminInfoController {

    private final Logger logger = LoggerFactory.getLogger( AdminInfoController.class );

    @Autowired
    private IAdminInfoService adminInfoService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<AdminInfo> getById(@PathVariable("id") Long id)throws Exception {
        AdminInfo admin = adminInfoService.getById(id);
        return Result.success(admin);
    }

    @PostMapping("/login")
    public Result<AdminInfo> login(@RequestBody LoginDTO loginDTO) {
        AdminInfo admin  = adminInfoService.login(loginDTO);
        return Result.success(admin);
    }
}

