package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.model.domain.AdminInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 管理员信息表 Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {
    AdminInfo selectByAccountAndPassword(
            @Param("account") String account,
            @Param("password") String password
    );
}
