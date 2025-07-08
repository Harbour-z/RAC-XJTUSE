package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.mapper.ShopMapper;
import com.example.mybatisplusdemo.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 店铺信息表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

}
