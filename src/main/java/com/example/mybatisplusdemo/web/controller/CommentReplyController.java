package com.example.mybatisplusdemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.ICommentReplyService;
import com.example.mybatisplusdemo.model.domain.CommentReply;


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
@RequestMapping("/api/commentReply")
public class CommentReplyController {

    private final Logger logger = LoggerFactory.getLogger( CommentReplyController.class );

    @Autowired
    private ICommentReplyService commentReplyService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<CommentReply> getById(@PathVariable("id") Long id)throws
Exception {
        CommentReply commentReply = commentReplyService.getById(id);
        return Result.success(commentReply);
    }
}

