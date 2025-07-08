package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.model.domain.Comment;
import com.example.mybatisplusdemo.mapper.CommentMapper;
import com.example.mybatisplusdemo.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
