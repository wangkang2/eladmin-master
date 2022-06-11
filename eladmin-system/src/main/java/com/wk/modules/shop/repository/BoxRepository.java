package com.wk.modules.shop.repository;

import com.wk.modules.shop.domain.Box;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BoxRepository extends JpaRepository<Box, Long>, JpaSpecificationExecutor<Box> {

    Box findByNameAndDelFlag(String name, Boolean delFlag);
}
