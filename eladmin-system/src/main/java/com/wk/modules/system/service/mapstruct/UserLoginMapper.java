
package com.wk.modules.system.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.system.domain.User;
import com.wk.modules.system.service.dto.UserLoginDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author wang kang
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserLoginMapper extends BaseMapper<UserLoginDto, User> {
}
