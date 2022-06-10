
package com.wk.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.domain.Log;
import com.wk.service.dto.LogSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author wang kang
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends BaseMapper<LogSmallDTO, Log> {

}