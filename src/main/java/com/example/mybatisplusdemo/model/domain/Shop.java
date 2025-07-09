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
 * 商家信息表
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop")
@ApiModel(value="Shop对象", description="店铺信息表")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "商户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @ApiModelProperty(value = "店铺分类")
    @TableField("category_id")
    private Integer categoryId;

        @ApiModelProperty(value = "店铺地址")
    @TableField("address")
    private String address;

        @ApiModelProperty(value = "店铺名称")
    @TableField("merchant_name")
    private String merchantName;

        @ApiModelProperty(value = "经度")
    @TableField("logitude")
    private Long logitude;

        @ApiModelProperty(value = "纬度")
    @TableField("latitude")
    private Long latitude;

        @ApiModelProperty(value = "平均评分")
    @TableField("avg_rating")
    private Long avgRating;

        @ApiModelProperty(value = "店铺经营者username")
    @TableField("username")
    private String username;

        @ApiModelProperty(value = "店铺简介")
    @TableField("description")
    private String description;

        @ApiModelProperty(value = "封面URL")
    @TableField("cover")
    private String cover;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

        @ApiModelProperty(value = "价格区间")
    @TableField("price_range")
    private String priceRange;

        @ApiModelProperty(value = "商家标签")
    @TableField("tag")
    private String tag;


}
