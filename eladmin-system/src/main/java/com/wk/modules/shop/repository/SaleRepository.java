package com.wk.modules.shop.repository;
/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:51
 * @Description: 
 */

import com.wk.modules.shop.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author wangkang
 * @date 2022/06/11 18:51
 **/
public interface SaleRepository extends JpaRepository<Sale, Long>, JpaSpecificationExecutor<Sale> {
    Sale findByNameAndDelFlag(String name, boolean b);

    @Query(value = "SELECT id,sale_id,box_id FROM shop_sale_box WHERE sale_id = ?1",nativeQuery = true)
    List<Map<String, Long>> getBoxBySaleId(Long saleId);

    @Query(value = "SELECT id,sale_id,loop_type,loop_value FROM shop_sale_loop WHERE sale_id = ?1",nativeQuery = true)
    List<Map<String, Object>> getLoopValueBySaleId(Long saleId);

    @Query(value = "SELECT id,sale_id,sale_content FROM shop_sale_content WHERE sale_id = ?1",nativeQuery = true)
    List<Map<String, Object>> getSaleContentBySaleId(Long saleId);
}
