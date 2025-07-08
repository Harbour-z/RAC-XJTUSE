package com.example.mybatisplusdemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IAdminAuditLogService;
import com.example.mybatisplusdemo.model.domain.AdminAuditLog;


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
@RequestMapping("/api/adminAuditLog")
public class AdminAuditLogController {

    private final Logger logger = LoggerFactory.getLogger( AdminAuditLogController.class );

    @Autowired
    private IAdminAuditLogService adminAuditLogService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<AdminAuditLog> getById(@PathVariable("id") Long id)throws
Exception {
        AdminAuditLog adminAuditLog = adminAuditLogService.getById(id);
        return Result.success(adminAuditLog);
    }
}

