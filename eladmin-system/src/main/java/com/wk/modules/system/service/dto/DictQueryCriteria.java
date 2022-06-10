
package com.wk.modules.system.service.dto;

import lombok.Data;
import com.wk.annotation.Query;

/**
 * @author wang kang
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,description")
    private String blurry;
}
