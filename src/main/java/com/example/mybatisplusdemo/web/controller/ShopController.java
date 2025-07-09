package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplusdemo.model.dto.ShopDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IShopService;
import com.example.mybatisplusdemo.model.domain.Shop;

import java.security.Principal;
import java.sql.Wrapper;
import java.time.LocalDateTime;


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
@Slf4j
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

    @PostMapping("/register")
    public Result<Shop> registerShop(@RequestBody ShopDTO shopDTO){
        // ShopDTO中必须要有店铺名称和店铺经营者username
        log.info("shopDTO:{}",shopDTO);
        if (shopDTO.getUsername() == null || shopDTO.getMerchantName()==null){
            return Result.failure("缺少必要信息！");
        }
        if (shopDTO.getMerchantName().isEmpty()){
            return Result.failure("店铺名称！");
        }
        QueryWrapper<Shop> wrapper = new QueryWrapper<>();
        wrapper.eq("username",shopDTO.getUsername());
        if(shopService.getOne(wrapper)==null){
            return Result.failure("此用户昵称不存在");
        }
        Shop shop = new Shop();
        BeanUtils.copyProperties(shopDTO,shop);
        shop.setCreateTime(LocalDateTime.now());
        shop.setUpdateTime(LocalDateTime.now());
        boolean res = shopService.save(shop);
        return res?Result.success(shop):Result.failure("店铺创建失败");
    }
}

