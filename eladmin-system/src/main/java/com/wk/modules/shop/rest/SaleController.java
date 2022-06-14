package com.wk.modules.shop.rest;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 16:40
 * @Description: 
 */


import com.wk.annotation.Log;
import com.wk.base.BaseEntity;
import com.wk.exception.BadRequestException;
import com.wk.modules.shop.service.SaleService;
import com.wk.modules.shop.service.dto.SaleDto;
import com.wk.modules.shop.service.dto.SaleQueryCriteria;
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
import java.util.List;
import java.util.Set;

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

    @ApiOperation("导出活动数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('sale:list')")
    public void exportSale(HttpServletResponse response, SaleQueryCriteria criteria) throws IOException {
        saleService.download(saleService.queryAll(criteria), response);
    }

    @ApiOperation("查询活动")
    @GetMapping
    @PreAuthorize("@el.check('sale:list')")
    public ResponseEntity<Object> querySale(SaleQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(saleService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @GetMapping("getBoxBySaleId")
    public ResponseEntity<List<Long>> getBoxBySaleId(Long saleId){
        return new ResponseEntity<>(saleService.getBoxBySaleId(saleId), HttpStatus.OK);
    }

    @GetMapping("getLoopValueBySaleId")
    public ResponseEntity<List<String>> getLoopValueBySaleId(Long saleId){
        return new ResponseEntity<>(saleService.getLoopValueBySaleId(saleId), HttpStatus.OK);
    }

    @GetMapping("getSaleContentBySaleId")
    public ResponseEntity<String> getSaleContentBySaleId(Long saleId){
        return new ResponseEntity<>(saleService.getSaleContentBySaleId(saleId), HttpStatus.OK);
    }

    @Log("新增活动")
    @ApiOperation("新增活动")
    @PostMapping
    @PreAuthorize("@el.check('sale:add')")
    public ResponseEntity<Object> createSale(@Validated @RequestBody SaleDto resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        saleService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改活动")
    @ApiOperation("修改活动")
    @PutMapping
    @PreAuthorize("@el.check('sale:edit')")
    public ResponseEntity<Object> updateSale(@Validated(BaseEntity.Update.class) @RequestBody SaleDto resources){
        saleService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除活动")
    @ApiOperation("删除活动")
    @DeleteMapping
    @PreAuthorize("@el.check('sale:del')")
    public ResponseEntity<Object> deleteCoupon(@RequestBody Set<Long> ids){
        saleService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
