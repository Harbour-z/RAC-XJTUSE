package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.domain.Merchant;
import com.example.mybatisplusdemo.mapper.MerchantMapper;
import com.example.mybatisplusdemo.service.IMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-07
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantService {

    private final MerchantMapper merchantMapper;

    public MerchantServiceImpl(MerchantMapper merchantMapper) {
        this.merchantMapper = merchantMapper;
    }


    @Override
    public Merchant login(Merchant  merchant) {
        LambdaQueryWrapper<Merchant> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Merchant::getUsername,merchant.getUsername()).eq(Merchant::getPassword,merchant.getPassword());
        //登录用户存进Session
        Merchant one = merchantMapper.selectOne(wrapper);
        SessionUtils.saveCurrentMerchantInfo(one);
        return one;
    }
}
