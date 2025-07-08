package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.model.domain.Admin;
import com.example.mybatisplusdemo.model.domain.AdminInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.dto.LoginDTO;

/**
 * <p>
 * 管理员信息表 服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface IAdminInfoService extends IService<AdminInfo> {
    AdminInfo login(LoginDTO loginDTO);
}
