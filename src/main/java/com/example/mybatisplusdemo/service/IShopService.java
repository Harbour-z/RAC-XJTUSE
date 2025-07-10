package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.dto.PageDTO;
import com.example.mybatisplusdemo.model.dto.SearchShopDTO;

/**
 * <p>
 * 店铺信息表 服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface IShopService extends IService<Shop> {

    Page<Shop> listPage(SearchShopDTO  searchShopDTO)throws Exception;
}
