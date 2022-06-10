
package com.wk.modules.system.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.system.domain.Role;
import com.wk.modules.system.service.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author wang kang
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {

}
