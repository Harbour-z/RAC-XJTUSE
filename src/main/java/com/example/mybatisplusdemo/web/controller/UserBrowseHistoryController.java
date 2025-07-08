package com.example.mybatisplusdemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IUserBrowseHistoryService;
import com.example.mybatisplusdemo.model.domain.UserBrowseHistory;


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
@RequestMapping("/api/userBrowseHistory")
public class UserBrowseHistoryController {

    private final Logger logger = LoggerFactory.getLogger( UserBrowseHistoryController.class );

    @Autowired
    private IUserBrowseHistoryService userBrowseHistoryService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<UserBrowseHistory> getById(@PathVariable("id") Long id)throws
Exception {
        UserBrowseHistory userBrowseHistory = userBrowseHistoryService.getById(id);
        return Result.success(userBrowseHistory);
    }
}

