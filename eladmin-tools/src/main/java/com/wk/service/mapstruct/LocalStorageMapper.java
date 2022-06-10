
package com.wk.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.service.dto.LocalStorageDto;
import com.wk.domain.LocalStorage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author wang kang
* @date 2019-09-05
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends BaseMapper<LocalStorageDto, LocalStorage> {

}