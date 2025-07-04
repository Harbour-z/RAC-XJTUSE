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
 * 
 * </p>
 *
 * @author hxy
 * @since 2025-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value="User对象", description="")
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        @ApiModelProperty(value = "用户名")
    @TableField("login_name")
    private String loginName;

    @TableField("password")
    private String password;

    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @TableField("remark")
    private String remark;

        @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
        @TableLogic
    private Boolean deleted;

        @ApiModelProperty(value = "创建时间")
    @TableField("gmt_created")
    private LocalDateTime gmtCreated;

        @ApiModelProperty(value = "更新时间")
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

        private String avater;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", remark='" + remark + '\'' +
                ", deleted=" + deleted +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
