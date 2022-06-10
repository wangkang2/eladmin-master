package com.wk.modules.shop.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.service.dto.BoxDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {BoxMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoxMapper extends BaseMapper<BoxDto, Box> {
}
