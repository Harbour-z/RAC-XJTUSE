package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.model.domain.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-07-07
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin selectByAccountAndPassword(
            @Param("account") String account,
            @Param("password") String password
    );
}
