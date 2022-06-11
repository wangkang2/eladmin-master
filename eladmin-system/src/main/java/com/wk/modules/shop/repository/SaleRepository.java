package com.wk.modules.shop.repository;
/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:51
 * @Description: 
 */

import com.wk.modules.shop.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 
 * @author wangkang
 * @date 2022/06/11 18:51
 **/
public interface SaleRepository extends JpaRepository<Sale, Long>, JpaSpecificationExecutor<Sale> {
}
