package com.example.mybatisplusdemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IMerchantContentService;
import com.example.mybatisplusdemo.model.domain.MerchantContent;


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
@RequestMapping("/api/merchantContent")
public class MerchantContentController {

    private final Logger logger = LoggerFactory.getLogger( MerchantContentController.class );

    @Autowired
    private IMerchantContentService merchantContentService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<MerchantContent> getById(@PathVariable("id") Long id)throws
Exception {
        MerchantContent merchantContent = merchantContentService.getById(id);
        return Result.success(merchantContent);
    }
}

