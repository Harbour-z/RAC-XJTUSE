package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.mapper.ShopMapper;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.example.mybatisplusdemo.model.dto.PageDTO;
import com.example.mybatisplusdemo.model.dto.SearchShopDTO;
import com.example.mybatisplusdemo.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Page<Shop> listPage(SearchShopDTO  searchShopDTO)throws Exception {
        Page<Shop> page = new Page<>(searchShopDTO.getPageNum(), searchShopDTO.getPageSize());
        page = shopMapper.listPage(page,searchShopDTO);
        return page;
    }
}
