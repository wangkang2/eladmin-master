
package com.wk.modules.mnt.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.mnt.domain.Deploy;
import com.wk.modules.mnt.service.dto.DeployDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Mapper(componentModel = "spring",uses = {AppMapper.class, ServerDeployMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeployMapper extends BaseMapper<DeployDto, Deploy> {

}
