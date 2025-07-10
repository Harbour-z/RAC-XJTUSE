package com.example.mybatisplusdemo.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商家资质审核表
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("merchant_qulification")
@ApiModel(value="MerchantQulification对象", description="商家资质审核表")
public class MerchantQulification implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("merchant_id")
    private Long merchantId;

        @ApiModelProperty(value = "营业许可证编号")
    @TableField("license_number")
    private String licenseNumber;

        @ApiModelProperty(value = "许可证图片url")
    @TableField("license")
    private String license;

        @ApiModelProperty(value = "其余资质许可图片(JSON)")
    @TableField("other_permit")
    private String otherPermit;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

        @ApiModelProperty(value = "卫生许可证图片")
    @TableField("health")
    private String health;

        @ApiModelProperty(value = "审核进度((0-待审核,1-审核中,2-审核通过,3-审核不通过,4-已冻结))")
    @TableField("status")
    private Byte status;

        @ApiModelProperty(value = "拒绝原因")
    @TableField("reject_reason")
    private String rejectReason;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;


}
