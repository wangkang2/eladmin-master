
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
public class RoleQueryCriteria {

    @Query(blurry = "name,description")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
