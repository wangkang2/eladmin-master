package com.wk.modules.shop.repository;


import com.wk.modules.shop.domain.SaleBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SaleBoxRepository extends JpaRepository<SaleBox, Long>, JpaSpecificationExecutor<SaleBox> {

    void deleteBySaleId(Long saleId);
}
