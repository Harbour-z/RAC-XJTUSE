package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.model.domain.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.dto.LoginDTO;

import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface IUserInfoService extends IService<UserInfo> {
    List<UserInfo> listByKey(String key);

    UserInfo login(LoginDTO loginDTO);
}
