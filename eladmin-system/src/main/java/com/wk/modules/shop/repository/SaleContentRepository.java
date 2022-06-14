package com.wk.modules.shop.repository;


import com.wk.modules.shop.domain.SaleContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SaleContentRepository extends JpaRepository<SaleContent, Long>, JpaSpecificationExecutor<SaleContent> {

    void deleteBySaleId(Long saleId);
}
