package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.model.domain.Merchant;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-07-07
 */
public interface MerchantMapper extends BaseMapper<Merchant> {

    Merchant selectByAccountAndPassword(
            @Param("account") String account,
            @Param("password") String password
    );
}
