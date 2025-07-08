package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.model.domain.UserBrowseHistory;
import com.example.mybatisplusdemo.mapper.UserBrowseHistoryMapper;
import com.example.mybatisplusdemo.service.IUserBrowseHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户浏览历史表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class UserBrowseHistoryServiceImpl extends ServiceImpl<UserBrowseHistoryMapper, UserBrowseHistory> implements IUserBrowseHistoryService {

}
