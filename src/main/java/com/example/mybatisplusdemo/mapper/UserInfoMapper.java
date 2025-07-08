package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.model.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    UserInfo selectByAccountAndPassword(
            @Param("account") String account,
            @Param("password") String password
    );

}