package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商家信息表 Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface MerchantInfoMapper extends BaseMapper<MerchantInfo> {
    MerchantInfo selectByAccountAndPassword(
            @Param("account") String account,
            @Param("password") String password
    );
}
