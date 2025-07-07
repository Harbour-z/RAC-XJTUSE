package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.User;
import com.example.mybatisplusdemo.model.dto.PageDTO;
import dev.langchain4j.agent.tool.P;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-06-17
 */
public interface UserMapper extends BaseMapper<User> {
    User selectCurUser(@Param("user") User user);

    User selectByAccountAndPassword(
            @Param("account") String account,
            @Param("password") String password
    );
    //传递参数取别名
}
