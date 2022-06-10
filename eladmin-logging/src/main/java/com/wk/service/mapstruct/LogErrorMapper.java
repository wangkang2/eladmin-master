
package com.wk.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.domain.Log;
import com.wk.service.dto.LogErrorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author wang kang
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogErrorMapper extends BaseMapper<LogErrorDTO, Log> {

}