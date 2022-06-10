package com.wk.modules.shop.service;

import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.service.dto.BoxDto;
import com.wk.modules.shop.service.dto.BoxQueryCriteria;
import com.wk.modules.system.service.dto.JobQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BoxService {
    Object queryAll(BoxQueryCriteria criteria, Pageable pageable);

    void create(Box resources);

    void update(Box resources);

    List<BoxDto> queryAll(JobQueryCriteria criteria);

    void download(List<BoxDto> queryAll, HttpServletResponse response) throws IOException;

    void delete(Set<Long> ids);
}
