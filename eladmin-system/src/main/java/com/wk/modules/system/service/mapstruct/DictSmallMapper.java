
package com.wk.modules.system.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.system.domain.Dict;
import com.wk.modules.system.service.dto.DictSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author wang kang
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictSmallMapper extends BaseMapper<DictSmallDto, Dict> {

}