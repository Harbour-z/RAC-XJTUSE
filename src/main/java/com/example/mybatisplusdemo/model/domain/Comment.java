package com.example.mybatisplusdemo.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comment")
@ApiModel(value="Comment对象", description="评论表")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "评论id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("username")
    private String username;

    @TableField("content_id")
    private Long contentId;

        @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

        @ApiModelProperty(value = "总体评分")
    @TableField("overall_rating")
    private Double overallRating;

        @ApiModelProperty(value = "状态(0-待审核,1-审核通过,2-审核不通过)")
    @TableField("status")
    private Byte status;

        @ApiModelProperty(value = "审核被拒绝原因")
    @TableField("reject_reason")
    private String rejectReason;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

        @ApiModelProperty(value = "图片url JSON")
    @TableField("picture")
    private String picture;

        @ApiModelProperty(value = "视频url JSON")
    @TableField("video")
    private String video;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;


}
