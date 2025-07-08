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
 * 审核日志表
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("admin_audit_log")
@ApiModel(value="AdminAuditLog对象", description="审核日志表")
public class AdminAuditLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("admin_id")
    private Long adminId;

        @ApiModelProperty(value = "审核类型(1-商家注册,2-商家信息修改,3-评论内容,4-商家动态)")
    @TableField("audit_type")
    private Byte auditType;

        @ApiModelProperty(value = "审核对象ID(商家ID/评论ID/动态ID)")
    @TableField("target_id")
    private Long targetId;

        @ApiModelProperty(value = "审核前状态")
    @TableField("old_status")
    private Byte oldStatus;

        @ApiModelProperty(value = "审核后状态")
    @TableField("new_status")
    private Byte newStatus;

        @ApiModelProperty(value = "审核备注(拒绝原因等)")
    @TableField("audit_remark")
    private String auditRemark;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;


}
