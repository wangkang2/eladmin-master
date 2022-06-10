package com.wk.modules.shop.service.impl;

import com.wk.exception.EntityExistException;
import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.repository.BoxRepository;
import com.wk.modules.shop.service.BoxService;
import com.wk.modules.shop.service.dto.BoxQueryCriteria;
import com.wk.modules.shop.service.mapstruct.BoxMapper;
import com.wk.utils.PageUtil;
import com.wk.utils.QueryHelp;
import com.wk.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Box resources) {
        Box box = boxRepository.findByName(resources.getName());
        if(box != null){
            throw new EntityExistException(Box.class,"name",resources.getName());
        }
        boxRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Box resources) {
        Box box = boxRepository.findById(resources.getId()).orElseGet(Box::new);
        Box old = boxRepository.findByName(resources.getName());
        if(old != null && !old.getId().equals(resources.getId())){
            throw new EntityExistException(Box.class,"name",resources.getName());
        }
        ValidationUtil.isNull( box.getId(),"Box","id",resources.getId());
        resources.setId(box.getId());
        boxRepository.save(resources);
    }
}
