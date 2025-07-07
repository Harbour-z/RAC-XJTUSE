package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.mapper.AdminMapper;
import com.example.mybatisplusdemo.model.domain.Admin;
import com.example.mybatisplusdemo.model.domain.Merchant;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-07
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin login(LoginDTO loginDTO) {
        Admin admin = adminMapper.selectByAccountAndPassword(
                loginDTO.getAccount(),
                loginDTO.getPassword()
        );
        if (admin == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        //登录用户存进Session
        SessionUtils.saveCurrentAdminInfo(admin);
        return admin;
    }
}
