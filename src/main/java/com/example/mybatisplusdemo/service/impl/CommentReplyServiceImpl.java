package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.model.domain.CommentReply;
import com.example.mybatisplusdemo.mapper.CommentReplyMapper;
import com.example.mybatisplusdemo.service.ICommentReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论回复表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class CommentReplyServiceImpl extends ServiceImpl<CommentReplyMapper, CommentReply> implements ICommentReplyService {

}
