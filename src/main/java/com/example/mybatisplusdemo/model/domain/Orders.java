package com.example.mybatisplusdemo.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hxy
 * @since 2025-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("orders")
@ApiModel(value="Orders对象", description="")
@Accessors(chain = true)
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("user_id")
    private Long userId;

    @Override
    public String toString() {
    return "Orders{" +
            "id=" + id +
            ", name=" + name +
            ", userId=" + userId +
    "}";
    }


}
