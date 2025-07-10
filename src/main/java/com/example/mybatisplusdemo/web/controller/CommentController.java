package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.model.domain.Shop;
import com.example.mybatisplusdemo.model.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.naming.factory.ResourceLinkFactory;
import com.example.mybatisplusdemo.model.dto.SearchShopDTO;
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

    //根据DTO中的信息来分页查询所有对应的评论
    @GetMapping("listComments")
    public Result listPage(CommentDTO commentDTO)throws Exception{
        Page<Comment> page = commentService.listPage(commentDTO);
        return Result.success(page);
    }

    //接受前端的json数据来更新评论内容
    @PostMapping("updateComment")
    public Result updateComment(@RequestBody Comment comment){

        boolean bool = commentService.updateById(comment);
        return Result.success(bool);
    }

    //删除当前评论
    @GetMapping("deleteComment")
    public Result deleteComments(Long id)throws Exception{
        boolean bool = commentService.removeById(id);
        return Result.success(bool);
    }
}

