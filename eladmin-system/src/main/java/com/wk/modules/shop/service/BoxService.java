package com.wk.modules.shop.service;

import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.service.dto.BoxQueryCriteria;
import org.springframework.data.domain.Pageable;

public interface BoxService {
    Object queryAll(BoxQueryCriteria criteria, Pageable pageable);

    void create(Box resources);

    void update(Box resources);
}
