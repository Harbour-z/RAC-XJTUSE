package com.example.mybatisplusdemo.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评分维度表
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rating_dimension")
@ApiModel(value="RatingDimension对象", description="评分维度表")
public class RatingDimension implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @ApiModelProperty(value = "评论id")
    @TableField("comment_id")
    private Long commentId;

        @ApiModelProperty(value = "环境评分")
    @TableField("rating_env")
    private Long ratingEnv;

        @ApiModelProperty(value = "服务评分")
    @TableField("rating_service")
    private Long ratingService;

        @ApiModelProperty(value = "口味评分")
    @TableField("rating_flavor")
    private Long ratingFlavor;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;


}
