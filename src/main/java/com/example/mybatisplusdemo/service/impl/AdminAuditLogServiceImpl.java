package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.model.domain.AdminAuditLog;
import com.example.mybatisplusdemo.mapper.AdminAuditLogMapper;
import com.example.mybatisplusdemo.service.IAdminAuditLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审核日志表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class AdminAuditLogServiceImpl extends ServiceImpl<AdminAuditLogMapper, AdminAuditLog> implements IAdminAuditLogService {

}
