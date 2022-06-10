
package com.wk.service.dto;

import lombok.Data;
import com.wk.annotation.Query;
import java.sql.Timestamp;
import java.util.List;

/**
 * sm.ms图床
 *
 * @author wang kang
 * @date 2019-6-4 09:52:09
 */
@Data
public class PictureQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String filename;
    
    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
