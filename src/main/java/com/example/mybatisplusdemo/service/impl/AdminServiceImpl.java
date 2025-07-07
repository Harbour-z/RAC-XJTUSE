package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.mapper.AdminMapper;
import com.example.mybatisplusdemo.model.domain.Admin;
import com.example.mybatisplusdemo.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    public Admin login(Admin admin) {
        LambdaQueryWrapper<Admin> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername,admin.getUsername()).eq(Admin::getPassword,admin.getPassword());
        //登录用户存进Session
        Admin one = adminMapper.selectOne(wrapper);
        SessionUtils.saveCurrentAdminInfo(one);
        return one;
    }
}
