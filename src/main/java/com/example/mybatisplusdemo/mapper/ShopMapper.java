package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.model.dto.SearchShopDTO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 店铺信息表 Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface ShopMapper extends BaseMapper<Shop> {

    Page<Shop> listPage(@Param("page") Page<Shop> page,@Param("shop") SearchShopDTO searchShopDTO)throws Exception;
}
