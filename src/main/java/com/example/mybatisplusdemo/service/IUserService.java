package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.dto.LoginDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2025-06-17
 */
public interface IUserService extends IService<User> {

    List<User> listByKey(String key);

    User login(LoginDTO loginDTO);

//    Page<User> listPage(PageDTO pageDTO, User user);等基础框架清楚了再具体定义
}
