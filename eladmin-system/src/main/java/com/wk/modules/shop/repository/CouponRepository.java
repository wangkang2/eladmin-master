package com.wk.modules.shop.repository;

import com.wk.modules.shop.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CouponRepository extends JpaRepository<Coupon, Long>, JpaSpecificationExecutor<Coupon> {

    Coupon findByNameAndDelFlag(String name, Boolean delFlag);
}
