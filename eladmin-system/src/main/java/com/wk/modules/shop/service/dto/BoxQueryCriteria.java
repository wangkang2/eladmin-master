package com.wk.modules.shop.service.dto;

import com.wk.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class BoxQueryCriteria {

    @Query(blurry = "name")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query
    private Boolean delFlag = true;
}
