
package com.wk.modules.system.service.dto;

import com.wk.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author wang kang
 * 公共查询类
 */
@Data
public class MenuQueryCriteria {

    @Query(blurry = "title,component,permission")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query(type = Query.Type.IS_NULL, propName = "pid")
    private Boolean pidIsNull;

    @Query
    private Long pid;
}
