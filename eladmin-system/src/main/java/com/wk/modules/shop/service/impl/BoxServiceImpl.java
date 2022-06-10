package com.wk.modules.shop.service.impl;

import com.wk.exception.EntityExistException;
import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.repository.BoxRepository;
import com.wk.modules.shop.service.BoxService;
import com.wk.modules.shop.service.dto.BoxDto;
import com.wk.modules.shop.service.dto.BoxQueryCriteria;
import com.wk.modules.shop.service.mapstruct.BoxMapper;
import com.wk.modules.system.service.dto.JobDto;
import com.wk.modules.system.service.dto.JobQueryCriteria;
import com.wk.utils.FileUtil;
import com.wk.utils.PageUtil;
import com.wk.utils.QueryHelp;
import com.wk.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class BoxServiceImpl implements BoxService {

    private final BoxRepository boxRepository;
    private final BoxMapper boxMapper;

    @Override
    public List<BoxDto> queryAll(JobQueryCriteria criteria) {
        List<Box> list = boxRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return boxMapper.toDto(list);
    }

    @Override
    public void download(List<BoxDto> boxDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (BoxDto boxDto : boxDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("盲盒名称", boxDto.getName());
            map.put("盲盒单价", boxDto.getPrice());
            map.put("运货规则", boxDto.getShipRule());
            map.put("盲盒描述", boxDto.getBoxDescribe());
            map.put("创建日期", boxDto.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

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

    @Override
    public void delete(Set<Long> ids) {
        for(Long id:ids){
            Box box = boxRepository.findById(id).orElseGet(Box::new);
            box.setDelFlag(false);
            boxRepository.save(box);
        }
    }


}
