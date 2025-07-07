package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.model.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.dto.LoginDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-07
 */
public interface IAdminService extends IService<Admin> {

    Admin login(LoginDTO loginDTO);
}
