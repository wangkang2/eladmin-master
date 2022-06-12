package com.wk.modules.shop.service;

import com.wk.modules.shop.domain.Sale;
import com.wk.modules.shop.service.dto.SaleDto;
import com.wk.modules.shop.service.dto.SaleQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:45
 * @Description:
 */
public interface SaleService {

    List<SaleDto> queryAll(SaleQueryCriteria criteria);

    Object queryAll(SaleQueryCriteria criteria, Pageable pageable);

    void download(List<SaleDto> queryAll, HttpServletResponse response) throws IOException;

    void create(SaleDto resources);

    List<Long> getBoxBySaleId(Long saleId);

    List<String> getLoopValueBySaleId(Long saleId);

    void update(SaleDto resources);

    void delete(Set<Long> ids);
}
