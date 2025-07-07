package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.model.domain.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-07
 */
public interface IMerchantService extends IService<Merchant> {

    Merchant login(Merchant merchant);
}
