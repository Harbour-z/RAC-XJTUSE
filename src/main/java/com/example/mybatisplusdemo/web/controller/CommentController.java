package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.model.dto.CommentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.ICommentService;
import com.example.mybatisplusdemo.model.domain.Comment;

import java.time.LocalDateTime;


/**
 *
 *  前端控制器
 *
 *
 * @author hxy
 * @since 2025-07-08
 * @version v1.0
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger( CommentController.class );

    @Autowired
    private ICommentService commentService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Comment> getById(@PathVariable("id") Long id)throws
Exception {
        Comment comment = commentService.getById(id);
        return Result.success(comment);
    }

    @PostMapping("/pubComment")
    public Result<Comment> pubComment(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        boolean result = commentService.save(comment);
        return result? Result.success(comment,"评论成功！"):Result.failure("评论失败");
    }
}

