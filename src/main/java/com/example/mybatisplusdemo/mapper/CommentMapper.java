package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.Comment;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.model.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface CommentMapper extends BaseMapper<Comment> {

    Page<Comment> listPage(@Param("page") Page<Comment> page,@Param("comment") CommentDTO commentDTO);
}
