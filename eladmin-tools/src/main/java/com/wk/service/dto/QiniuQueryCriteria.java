
package com.wk.service.dto;

import lombok.Data;
import com.wk.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author wang kang
 * @date 2019-6-4 09:54:37
 */
@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
