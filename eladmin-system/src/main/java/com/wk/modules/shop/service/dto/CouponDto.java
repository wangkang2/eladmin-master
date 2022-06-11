package com.wk.modules.shop.service.dto;
/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 11:25
 * @Description: 
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wk.base.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 优惠券查询返回
 * @author wangkang
 * @date 2022/06/11 11:25
 **/

@Getter
@Setter
@NoArgsConstructor
public class CouponDto extends BaseDTO implements Serializable {

    private Long id;

    private String name;

    private Integer couponType;

    private BigDecimal fullReducedAmount;

    private BigDecimal price;

    private BigDecimal discount;

    private Integer receiveCondition;

    private Integer receiveNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private List<Timestamp> validity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp validityFrom;

    private Timestamp validityTo;

    private Integer couponSort;

    private Boolean delFlag = true;

}
