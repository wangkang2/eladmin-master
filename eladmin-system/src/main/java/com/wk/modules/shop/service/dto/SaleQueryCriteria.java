package com.wk.modules.shop.service.dto;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:47
 * @Description: 
 */


import com.wk.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * 活动查询类
 * @author wangkang
 * @date 2022/06/11 18:47
 **/
public class SaleQueryCriteria {

    @Query(blurry = "name")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query
    private Boolean delFlag = true;

}
