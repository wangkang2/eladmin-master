package com.wk.modules.shop.service.dto;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 11:23
 * @Description: 
 */


import com.wk.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * 优惠券查询
 * @author wangkang
 * @date 2022/06/11 11:23
 **/

@Data
public class CouponQueryCriteria {

    @Query(blurry = "name")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query
    private Boolean delFlag = true;
}
