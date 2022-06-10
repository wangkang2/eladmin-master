
package com.wk.modules.system.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.system.domain.Job;
import com.wk.modules.system.service.dto.JobDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author wang kang
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<JobDto, Job> {
}