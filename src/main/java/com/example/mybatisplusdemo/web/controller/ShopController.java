package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.domain.MerchantQulification;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.example.mybatisplusdemo.model.dto.PageDTO;
import com.example.mybatisplusdemo.model.dto.SearchShopDTO;
import com.example.mybatisplusdemo.model.dto.ShopDTO;
import com.example.mybatisplusdemo.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private IUserInfoService userInfoService;


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
    @Transactional
    public Result<Shop> registerShop(@RequestBody ShopDTO shopDTO){
        // ShopDTO中必须要有店铺名称和店铺经营者username
        log.info("shopDTO:{}",shopDTO);
        if (shopDTO.getUsername() == null || shopDTO.getMerchantName()==null){
            return Result.failure("缺少必要信息！");
        }
        if (shopDTO.getMerchantName().isEmpty()){
            return Result.failure("店铺名称不能为空！");
        }
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("username", SessionUtils.getCurrentUserInfo().getUsername());
        if(userInfoService.getOne(wrapper)==null){
            return Result.failure("此用户昵称不存在");
        }
        // 存储店铺信息
        Shop shop = new Shop();
        BeanUtils.copyProperties(shopDTO,shop);
        shop.setCreateTime(LocalDateTime.now());
        shop.setUpdateTime(LocalDateTime.now());
        shop.setUsername(shopDTO.getUsername());
        boolean res = shopService.save(shop);
        //存储许可证信息
        MerchantQulification qulification = new MerchantQulification();
        BeanUtils.copyProperties(shopDTO,qulification);
        return res?Result.success(shop):Result.failure("店铺创建失败");
    }

    // 注销店铺
    @DeleteMapping("/deleteShop/{merchantName}")
    public Result deleteMe(@PathVariable String merchantName){
        Shop shop = shopService.getOne(new QueryWrapper<Shop>().eq("merchant_name",merchantName));
        if(shop==null){
            Result.failure("店铺不存在");
        }else {
            boolean b = shopService.removeById(shop.getId());
            return b ? Result.successMessage("Delete shop successfully!"):Result.failure("Delete shop failed!");
        }
        return Result.failure("Delete merchant-user failed!");
    }


    //搜索显示shop
    @GetMapping("listPage")
    public Result listPage(SearchShopDTO searchShopDTO)throws Exception{
        Page<Shop> page = shopService.listPage(searchShopDTO);
        return Result.success(page);
    }

    //店铺搜索分页器（目前功能针对用户主页的查询，接受前端的MerchantName（店铺名字），从后端获取对应的的店铺信息
    @GetMapping("/search")
    public Result<IPage<Shop>> searchShops(
            @RequestParam(required = false) String merchantName,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        System.out.println(merchantName);
        // 创建分页对象
        Page<Shop> page = new Page<>(pageNum, pageSize);

        // 构建查询条件
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        if (merchantName != null && !merchantName.isEmpty()) {
            queryWrapper.like("merchant_name", merchantName); // 模糊查询店铺名称
        }

        // 执行分页查询
        IPage<Shop> result = shopService.page(page, queryWrapper);
        return Result.success(result);
    }
}

