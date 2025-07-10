package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.Comment;
import com.example.mybatisplusdemo.mapper.CommentMapper;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.model.dto.CommentDTO;
import com.example.mybatisplusdemo.model.dto.ContentDTO;
import com.example.mybatisplusdemo.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    @Autowired
    CommentMapper commentMapper;

    @Override
    public Page<Comment> listPage(CommentDTO commentDTO) {
        Page<Comment> page = new Page<>(commentDTO.getPageNum(), commentDTO.getPageSize());
        page = commentMapper.listPage(page,commentDTO);
        return page;
    }
}
