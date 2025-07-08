package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.model.domain.UserFavorite;
import com.example.mybatisplusdemo.mapper.UserFavoriteMapper;
import com.example.mybatisplusdemo.service.IUserFavoriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户收藏表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class UserFavoriteServiceImpl extends ServiceImpl<UserFavoriteMapper, UserFavorite> implements IUserFavoriteService {

}
