package com.wk.modules.shop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wk.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name="shop_coupon")
public class Coupon extends BaseEntity implements Serializable {
    @Id
    @Column(name = "coupon_id")
    @NotNull(groups = Update.class)
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "优惠券名称")
    private String name;

    @Column(name = "coupon_type")
    @ApiModelProperty(value = "优惠券类型")
    private Integer couponType;

    @Column(name = "full_reduced_amount")
    @ApiModelProperty(value = "满减条件（金额）")
    private BigDecimal fullReducedAmount;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal price;

    @ApiModelProperty(value = "折扣（小于1的两位小数）")
    private BigDecimal discount;

    @Column(name = "receive_condition")
    @ApiModelProperty(value = "领取条件")
    private Integer receiveCondition;

    @Column(name = "receive_num")
    @ApiModelProperty(value = "领取次数")
    private Integer receiveNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "validity_from")
    @ApiModelProperty(value = "有效期起")
    private Timestamp validityFrom;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "有效期止")
    @Column(name = "validity_to")
    private Timestamp validityTo;

    @ApiModelProperty(value = "排序")
    private Integer couponSort;

    @Column(name = "del_flag",columnDefinition = "bit(1) default 1")
    @ApiModelProperty(value = "是否隐藏")
    private Boolean delFlag = true;

}
