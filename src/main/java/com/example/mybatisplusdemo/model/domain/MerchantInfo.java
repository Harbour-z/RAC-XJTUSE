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
@TableName("merchant_info")
@ApiModel(value="MerchantInfo对象", description="商家信息表")
public class MerchantInfo implements Serializable {

    private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "商家个人ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

        @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "商户状态;0-正常 1-冻结")
    @TableField("status")
    private Byte status;

    @TableField("email")
    private String email;

        @ApiModelProperty(value = "联系方式")
    @TableField("phone")
    private String phone;

        @ApiModelProperty(value = "用户头像")
    @TableField("avatar")
    private String avatar;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

}
