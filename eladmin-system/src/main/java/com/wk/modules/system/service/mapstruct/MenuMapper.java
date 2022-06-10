
package com.wk.modules.system.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.system.domain.Menu;
import com.wk.modules.system.service.dto.MenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author wang kang
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {
}
