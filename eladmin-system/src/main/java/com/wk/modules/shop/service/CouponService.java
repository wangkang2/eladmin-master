package com.wk.modules.shop.service;

import com.wk.modules.shop.service.dto.CouponDto;
import com.wk.modules.shop.service.dto.CouponQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 11:21
 * @Description:
 */
public interface CouponService {
    List<CouponDto> queryAll(CouponQueryCriteria criteria);

    Object queryAll(CouponQueryCriteria criteria, Pageable pageable);

    void download(List<CouponDto> queryAll, HttpServletResponse response) throws IOException;

    void create(CouponDto resources);

    void update(CouponDto resources);

    void delete(Set<Long> ids);
}
