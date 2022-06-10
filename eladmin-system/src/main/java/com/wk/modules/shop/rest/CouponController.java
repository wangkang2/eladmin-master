package com.wk.modules.shop.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "优惠券：优惠券管理")
@RequestMapping("/api/coupon")
public class CouponController {
}
