package com.wk.modules.shop.repository;


import com.wk.modules.shop.domain.SaleLoop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SaleLoopRepository extends JpaRepository<SaleLoop, Long>, JpaSpecificationExecutor<SaleLoop> {

    void deleteBySaleId(Long saleId);
}
