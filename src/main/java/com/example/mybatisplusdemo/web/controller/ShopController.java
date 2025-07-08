package com.example.mybatisplusdemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IShopService;
import com.example.mybatisplusdemo.model.domain.Shop;


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
@RequestMapping("/api/shop")
public class ShopController {

    private final Logger logger = LoggerFactory.getLogger( ShopController.class );

    @Autowired
    private IShopService shopService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Shop> getById(@PathVariable("id") Long id)throws
Exception {
        Shop shop = shopService.getById(id);
        return Result.success(shop);
    }
}

