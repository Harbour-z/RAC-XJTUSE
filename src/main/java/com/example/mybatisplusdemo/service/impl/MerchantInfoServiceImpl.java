package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;
import com.example.mybatisplusdemo.mapper.MerchantInfoMapper;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.service.IMerchantInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商家信息表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class MerchantInfoServiceImpl extends ServiceImpl<MerchantInfoMapper, MerchantInfo> implements IMerchantInfoService {
    private final MerchantInfoMapper merchantInfoMapper;

    public MerchantInfoServiceImpl(MerchantInfoMapper merchantInfoMapper) {
        this.merchantInfoMapper = merchantInfoMapper;
    }


    @Override
    public MerchantInfo login(LoginDTO loginDTO) {
        MerchantInfo merchant = merchantInfoMapper.selectByAccountAndPassword(
                loginDTO.getAccount(),
                loginDTO.getPassword()
        );
        if (merchant == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        //登录用户存进Session
        SessionUtils.saveCurrentMerchantInfo(merchant);
        return merchant;
    }
}
