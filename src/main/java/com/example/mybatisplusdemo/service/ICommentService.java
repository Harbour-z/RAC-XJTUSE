package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.model.dto.CommentDTO;
import com.example.mybatisplusdemo.model.dto.ContentDTO;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface ICommentService extends IService<Comment> {

    Page<Comment> listPage(CommentDTO commentDTO);
}
