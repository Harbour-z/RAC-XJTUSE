package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.model.domain.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-06-17
 */
public interface UserMapper extends BaseMapper<User> {
    //传递参数取别名
}
