package com.wk.modules.shop.service.impl;

import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.repository.BoxRepository;
import com.wk.modules.shop.service.BoxService;
import com.wk.modules.shop.service.dto.BoxQueryCriteria;
import com.wk.modules.shop.service.mapstruct.BoxMapper;
import com.wk.modules.system.domain.Job;
import com.wk.modules.system.repository.JobRepository;
import com.wk.modules.system.service.dto.JobQueryCriteria;
import com.wk.utils.PageUtil;
import com.wk.utils.QueryHelp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class BoxServiceImpl implements BoxService {

    private final BoxRepository boxRepository;
    private final BoxMapper boxMapper;

    @Override
    public Object queryAll(BoxQueryCriteria criteria, Pageable pageable) {
        Page<Box> page = boxRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(boxMapper::toDto).getContent(),page.getTotalElements());
    }
}
