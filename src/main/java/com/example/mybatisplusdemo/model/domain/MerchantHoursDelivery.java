package com.example.mybatisplusdemo.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商家工作时间与配送范围
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("merchant_hours_delivery")
@ApiModel(value="MerchantHoursDelivery对象", description="商家工作时间与配送范围")
public class MerchantHoursDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("merchant_id")
    private Byte merchantId;

        @ApiModelProperty(value = "工作天数")
    @TableField("week_day")
    private Byte weekDay;

        @ApiModelProperty(value = "营业开始时间")
    @TableField("open_time")
    private LocalTime openTime;

        @ApiModelProperty(value = "打烊时间")
    @TableField("close_time")
    private LocalTime closeTime;

        @ApiModelProperty(value = "配送半径")
    @TableField("radius")
    private Long radius;

        @ApiModelProperty(value = "起送金额")
    @TableField("min_amount")
    private Long minAmount;

        @ApiModelProperty(value = "配送费")
    @TableField("delivery_fee")
    private Long deliveryFee;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_deleted")
        @TableLogic
    private Byte isDeleted;


}
