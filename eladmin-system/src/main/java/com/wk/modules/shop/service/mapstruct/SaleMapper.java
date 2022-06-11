package com.wk.modules.shop.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.shop.domain.Sale;
import com.wk.modules.shop.service.dto.SaleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:52
 * @Description:
 */

@Mapper(componentModel = "spring",uses = {SaleMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaleMapper extends BaseMapper<SaleDto, Sale> {
}
