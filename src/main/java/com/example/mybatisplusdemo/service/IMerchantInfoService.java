package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.model.dto.PageDTO;

/**
 * <p>
 * 商家信息表 服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface IMerchantInfoService extends IService<MerchantInfo> {
    MerchantInfo login(LoginDTO loginDTO);

    Page<MerchantInfo> listPage(PageDTO pageDTO, MerchantInfo merchant);
}
