package com.wk.modules.shop.rest;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 16:40
 * @Description: 
 */


import com.wk.modules.shop.service.SaleService;
import com.wk.modules.shop.service.dto.SaleQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 活动controller
 * @author wangkang
 * @date 2022/06/11 16:40
 **/

@RestController
@RequiredArgsConstructor
@Api(tags = "活动：活动管理")
@RequestMapping("/api/sale")
public class SaleController {

    private final SaleService saleService;
    private static final String ENTITY_NAME = "sale";

    @ApiOperation("导出优惠券数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('sale:list')")
    public void exportSale(HttpServletResponse response, SaleQueryCriteria criteria) throws IOException {
        saleService.download(saleService.queryAll(criteria), response);
    }

    @ApiOperation("查询优惠券")
    @GetMapping
    @PreAuthorize("@el.check('sale:list')")
    public ResponseEntity<Object> querySale(SaleQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(saleService.queryAll(criteria, pageable), HttpStatus.OK);
    }

}
