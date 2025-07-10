package com.example.mybatisplusdemo.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @TableField("user_id")
    private Long userId;

    @TableField("merchant_id")
    private Long merchantId;

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

    // 使用 JsonFormat 确保 JSON 数组正确序列化/反序列化
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    // 使用 TypeHandler 处理 JSON 字段
    @TableField(typeHandler = com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler.class)
    private List<String> images;

        @ApiModelProperty(value = "视频url JSON")
    @TableField("video")
    private String video;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;

    @ApiModelProperty(value = "环境评分")
    @TableField("environment_rating")
    private Double environmentRating;

    @ApiModelProperty(value = "服务评分")
    @TableField("service_rating")
    private Double serviceRating;

    @ApiModelProperty(value = "口味评分")
    @TableField("taste_rating")
    private Double tasteRating;

}
