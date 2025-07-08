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
 * 商家内容
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("merchant_content")
@ApiModel(value="MerchantContent对象", description="商家内容")
public class MerchantContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @ApiModelProperty(value = "商家id")
    @TableField("merchant_id")
    private Long merchantId;

        @ApiModelProperty(value = "发布内容的标题")
    @TableField("titile")
    private String titile;

        @ApiModelProperty(value = "商家发布的内容")
    @TableField("content")
    private String content;

        @ApiModelProperty(value = "类型(1-新品预告,2-优惠活动,3-店铺故事,4-厨师风采)")
    @TableField("content_type")
    private Byte contentType;

        @ApiModelProperty(value = "阅读量")
    @TableField("view_count")
    private Long viewCount;

        @ApiModelProperty(value = "点赞数")
    @TableField("like_count")
    private Long likeCount;

        @ApiModelProperty(value = "评论数")
    @TableField("comment_count")
    private Long commentCount;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

        @ApiModelProperty(value = "图片url")
    @TableField("picture")
    private String picture;

        @ApiModelProperty(value = "视频url")
    @TableField("video")
    private String video;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;


}
