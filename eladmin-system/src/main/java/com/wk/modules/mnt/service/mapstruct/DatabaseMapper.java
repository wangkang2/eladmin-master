
package com.wk.modules.mnt.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.mnt.domain.Database;
import com.wk.modules.mnt.service.dto.DatabaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseMapper extends BaseMapper<DatabaseDto, Database> {

}
