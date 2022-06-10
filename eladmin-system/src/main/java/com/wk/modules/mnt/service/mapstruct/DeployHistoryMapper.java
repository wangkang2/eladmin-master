
package com.wk.modules.mnt.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.mnt.domain.DeployHistory;
import com.wk.modules.mnt.service.dto.DeployHistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeployHistoryMapper extends BaseMapper<DeployHistoryDto, DeployHistory> {

}
