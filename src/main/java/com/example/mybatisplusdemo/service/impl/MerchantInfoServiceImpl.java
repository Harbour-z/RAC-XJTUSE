package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;
import com.example.mybatisplusdemo.mapper.MerchantInfoMapper;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.model.dto.PageDTO;
import com.example.mybatisplusdemo.service.IMerchantInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusdemo.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

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

    @Autowired
    private IShopService shopService;

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

    @Override
    public Page<MerchantInfo> listPage(PageDTO pageDTO, MerchantInfo merchant) {
        Page<MerchantInfo> page = new Page<>(pageDTO.getPageNum(), pageDTO.getPageSize());
        page = merchantInfoMapper.listPage(page,merchant);
        return page;
    }

    @Override
    public boolean removeShops(String username) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return shopService.remove(queryWrapper);
    }
}
