package com.wk.modules.shop.service.mapstruct;

import com.wk.base.BaseMapper;
import com.wk.modules.shop.domain.Coupon;
import com.wk.modules.shop.service.dto.CouponDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {CouponMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CouponMapper extends BaseMapper<CouponDto, Coupon> {
}
