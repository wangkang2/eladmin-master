package com.wk.modules.shop.rest;

import com.wk.annotation.Log;
import com.wk.base.BaseEntity;
import com.wk.exception.BadRequestException;
import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.domain.Coupon;
import com.wk.modules.shop.service.CouponService;
import com.wk.modules.shop.service.dto.CouponDto;
import com.wk.modules.shop.service.dto.CouponQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@Api(tags = "优惠券：优惠券管理")
@RequestMapping("/api/coupon")
public class CouponController {

    private final CouponService couponService;
    private static final String ENTITY_NAME = "coupon";

    @ApiOperation("导出优惠券数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('coupon:list')")
    public void exportCoupon(HttpServletResponse response, CouponQueryCriteria criteria) throws IOException {
        couponService.download(couponService.queryAll(criteria), response);
    }

    @ApiOperation("查询优惠券")
    @GetMapping
    @PreAuthorize("@el.check('coupon:list')")
    public ResponseEntity<Object> queryCoupon(CouponQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(couponService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("新增优惠券")
    @ApiOperation("新增优惠券")
    @PostMapping
    @PreAuthorize("@el.check('coupon:add')")
    public ResponseEntity<Object> createCoupon(@Validated @RequestBody CouponDto resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        couponService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改优惠券")
    @ApiOperation("修改优惠券")
    @PutMapping
    @PreAuthorize("@el.check('coupon:edit')")
    public ResponseEntity<Object> updateCoupon(@Validated(BaseEntity.Update.class) @RequestBody CouponDto resources){
        couponService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除优惠券")
    @ApiOperation("删除优惠券")
    @DeleteMapping
    @PreAuthorize("@el.check('coupon:del')")
    public ResponseEntity<Object> deleteCoupon(@RequestBody Set<Long> ids){
        couponService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
