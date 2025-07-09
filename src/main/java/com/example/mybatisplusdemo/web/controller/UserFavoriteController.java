package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.service.IMerchantInfoService;
import com.example.mybatisplusdemo.service.IShopService;
import com.example.mybatisplusdemo.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IUserFavoriteService;
import com.example.mybatisplusdemo.model.domain.UserFavorite;

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
@RequestMapping("/api/userInfo")
@Slf4j
public class UserFavoriteController {

    private final Logger logger = LoggerFactory.getLogger( UserFavoriteController.class );

    @Autowired
    private IUserFavoriteService userFavoriteService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IMerchantInfoService merchantInfoService;
    @Autowired
    private IShopService shopService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<UserFavorite> getById(@PathVariable("id") Long id)throws
Exception {
        UserFavorite userFavorite = userFavoriteService.getById(id);
        return Result.success(userFavorite);
    }

    // 收藏商家(店铺)
    @PostMapping("/favor/{shopName}")
    public Result<UserFavorite> addFavorite(@PathVariable String shopName){
        Shop shop = shopService.getOne(new QueryWrapper<Shop>().eq("merchant_name",shopName));
        if(shop==null){
            return Result.failure("您收藏的店铺不存在");
        }
        UserFavorite userFavorite = userFavoriteService.getOne(new  QueryWrapper<UserFavorite>().eq("merchant_id",shop.getId()));
        if(userFavorite!=null && userFavorite.getIsDeleted()==1){
            userFavorite.setIsDeleted((byte) 0);
            return Result.success(userFavorite,"收藏成功");
        } else if (userFavorite!=null && userFavorite.getIsDeleted()==0) {
            return Result.failure("您已收藏过该商家");
        }else {
            UserFavorite favor = new UserFavorite();
            favor.setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setMerchantId(shop.getId())
                .setUserId(SessionUtils.getCurrentUserInfo().getId());
            boolean res = userFavoriteService.save(favor);
            return res ? Result.success(favor, "收藏成功！") : Result.failure("收藏失败");
        }
    }

    // 取消收藏商家(店铺)
    @DeleteMapping("/unfavor/{shopName}")
    public Result<UserFavorite> undoFavorite(@PathVariable String shopName){
        Shop shop =  shopService.getOne(new QueryWrapper<Shop>().eq("merchant_name",shopName));
        if(shop==null){
            return Result.failure("您取消收藏的店铺不存在");
        }
        UserFavorite favor = userFavoriteService.getOne(new QueryWrapper<UserFavorite>().eq("merchant_id",shop.getId()));

        if(favor==null){
            return Result.failure("您没有收藏此店铺");
        }
        boolean res = userFavoriteService.removeById(favor.getId());
        return res?Result.success(favor,"取消收藏成功！"):Result.failure("取消收藏失败");
    }
}

