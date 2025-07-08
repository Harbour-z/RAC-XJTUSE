package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.mapper.AdminMapper;
import com.example.mybatisplusdemo.model.domain.Admin;
import com.example.mybatisplusdemo.model.domain.AdminInfo;
import com.example.mybatisplusdemo.mapper.AdminInfoMapper;
import com.example.mybatisplusdemo.model.dto.LoginDTO;
import com.example.mybatisplusdemo.service.IAdminInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员信息表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements IAdminInfoService {
    private final AdminInfoMapper adminInfoMapper;

    public AdminInfoServiceImpl(AdminInfoMapper adminInfoMapper) {
        this.adminInfoMapper = adminInfoMapper;
    }

    @Override
    public AdminInfo login(LoginDTO loginDTO) {
        AdminInfo admin = adminInfoMapper.selectByAccountAndPassword(
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
