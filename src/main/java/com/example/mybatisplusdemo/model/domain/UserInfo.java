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
 * 用户信息
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_info")
@ApiModel(value="UserInfo对象", description="用户信息")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @ApiModelProperty(value = "登录名称")
    @TableField("username")
    private String username;

        @ApiModelProperty(value = "登录密码")
    @TableField("password")
    private String password;

        @ApiModelProperty(value = "用户手机号")
    @TableField("phone")
    private String phone;

        @ApiModelProperty(value = "用户性别;1为男 2为女 0-未知")
    @TableField("user_gender")
    private Byte userGender;

        @ApiModelProperty(value = "用户头像;头像资源地址")
    @TableField("user_avatar")
    private String userAvatar;

        @ApiModelProperty(value = "用户状态;0-正常 1-删除")
    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;

        @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

        @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

        @ApiModelProperty(value = "用户生日")
    @TableField("birthday")
    private LocalDateTime birthday;

        @ApiModelProperty(value = "个性签名")
    @TableField("signature")
    private String signature;

        @ApiModelProperty(value = "用户邮箱")
    @TableField("email")
    private String email;

        @ApiModelProperty(value = "用户资料可见性")
    @TableField("profile_visible")
    private Byte profileVisible;

        @ApiModelProperty(value = "收藏是否可见")
    @TableField("favorite_visible")
    private Byte favoriteVisible;


}
