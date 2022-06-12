package com.wk.modules.shop.service.impl;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:45
 * @Description: 
 */


import com.wk.exception.EntityExistException;
import com.wk.modules.shop.domain.Coupon;
import com.wk.modules.shop.domain.Sale;
import com.wk.modules.shop.domain.SaleBox;
import com.wk.modules.shop.domain.SaleLoop;
import com.wk.modules.shop.repository.SaleBoxRepository;
import com.wk.modules.shop.repository.SaleLoopRepository;
import com.wk.modules.shop.repository.SaleRepository;
import com.wk.modules.shop.service.SaleService;
import com.wk.modules.shop.service.dto.SaleDto;
import com.wk.modules.shop.service.dto.SaleQueryCriteria;
import com.wk.modules.shop.service.mapstruct.SaleMapper;
import com.wk.utils.FileUtil;
import com.wk.utils.PageUtil;
import com.wk.utils.QueryHelp;
import com.wk.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 活动业务类
 * @author wangkang
 * @date 2022/06/11 18:45
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleBoxRepository saleBoxRepository;
    private final SaleLoopRepository saleLoopRepository;
    private final SaleMapper saleMapper;

    @Override
    public List<SaleDto> queryAll(SaleQueryCriteria criteria) {
        List<Sale> list = saleRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return saleMapper.toDto(list);
    }

    @Override
    public Object queryAll(SaleQueryCriteria criteria, Pageable pageable) {
        Page<Sale> page = saleRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(saleMapper::toDto).getContent(),page.getTotalElements());
    }

    @Override
    public void download(List<SaleDto> saleDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SaleDto saleDto : saleDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("活动名称", saleDto.getName());
            if("0".equals(saleDto.getIsLoop())){
                map.put("循环", "否");
                if("1".equals(saleDto.getLoopType())){
                    map.put("活动日期", "每周" + saleDto.getLoopValue());
                }else if("2".equals(saleDto.getLoopType())){
                    map.put("活动日期", "每月" + saleDto.getLoopValue());
                }
                map.put("参与次数",saleDto.getLoopPartakeNum());
            }else{
                map.put("循环", "是");
                map.put("活动日期", saleDto.getFixedFrom() + "—" + saleDto.getFixedTo());

                if("1".equals(saleDto.getPartakeCondition())){
                    map.put("领取次数", "每月可领取" + saleDto.getPartakeNum() + "次");
                }else if("2".equals(saleDto.getPartakeCondition())){
                    map.put("领取次数", "每周可领取" + saleDto.getPartakeNum() + "次");
                }else{
                    map.put("领取次数", saleDto.getPartakeNum() + "次");
                }
            }
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(SaleDto resources) {
        Sale sale = saleRepository.findByNameAndDelFlag(resources.getName(), true);
        if(sale != null){
            throw new EntityExistException(Coupon.class,"name",resources.getName());
        }
        Sale saleNew = new Sale();
        BeanUtils.copyProperties(resources,saleNew);
        if(resources.getFixed()!=null && resources.getFixed().size() == 2){
            saleNew.setFixedFrom(resources.getFixed().get(0));
            saleNew.setFixedTo(resources.getFixed().get(1));
        }
        saleRepository.save(saleNew);

        List<Long> boxIds = resources.getBoxs();
        for(Long boxId:boxIds){
            SaleBox saleBox = new SaleBox();
            saleBox.setSaleId(saleNew.getId());
            saleBox.setBoxId(boxId);
            saleBoxRepository.save(saleBox);
        }

        List<String> loopValues = resources.getLoopValue();
        for(String loopValue:loopValues){
            SaleLoop saleLoop = new SaleLoop();
            saleLoop.setSaleId(saleNew.getId());
            saleLoop.setLoopType(saleNew.getLoopType());
            saleLoop.setLoopValue(loopValue);
            saleLoopRepository.save(saleLoop);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SaleDto resources) {
        Sale sale = saleRepository.findById(resources.getId()).orElseGet(Sale::new);
        Sale old = saleRepository.findByNameAndDelFlag(resources.getName(), true);
        if(old != null && !old.getId().equals(resources.getId())){
            throw new EntityExistException(Coupon.class,"name",resources.getName());
        }
        ValidationUtil.isNull( sale.getId(),"Sale","id",resources.getId());
        resources.setId(sale.getId());
        Sale saleNew = new Sale();
        BeanUtils.copyProperties(resources,saleNew);
        if(resources.getFixed()!=null && resources.getFixed().size() == 2){
            saleNew.setFixedFrom(resources.getFixed().get(0));
            saleNew.setFixedTo(resources.getFixed().get(1));
        }
        saleRepository.save(saleNew);

        if(resources.getBoxs()!=null){
            saleBoxRepository.deleteBySaleId(old.getId());
            List<Long> boxIds = resources.getBoxs();
            for(Long boxId:boxIds){
                SaleBox saleBox = new SaleBox();
                saleBox.setSaleId(saleNew.getId());
                saleBox.setBoxId(boxId);
                saleBoxRepository.save(saleBox);
            }
        }

        if(resources.getLoopValue()!=null){
            saleLoopRepository.deleteBySaleId(old.getId());
            List<String> loopValues = resources.getLoopValue();
            for(String loopValue:loopValues){
                SaleLoop saleLoop = new SaleLoop();
                saleLoop.setSaleId(saleNew.getId());
                saleLoop.setLoopType(saleNew.getLoopType());
                saleLoop.setLoopValue(loopValue);
                saleLoopRepository.save(saleLoop);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for(Long id:ids){
            Sale sale = saleRepository.findById(id).orElseGet(Sale::new);
            sale.setDelFlag(false);
            saleRepository.save(sale);
        }
    }

    @Override
    public List<Long> getBoxBySaleId(Long saleId) {
        List<Map<String,Long>> list = saleRepository.getBoxBySaleId(saleId);
        List<Long> boxIds = new ArrayList<>();
        for(Map<String,Long> map:list){
            boxIds.add(map.get("box_id"));
        }
        return boxIds;
    }

    @Override
    public List<String> getLoopValueBySaleId(Long saleId) {
        List<Map<String,Object>> list = saleRepository.getLoopValueBySaleId(saleId);
        List<String> loopValues = new ArrayList<>();
        for(Map<String,Object> map:list){
            loopValues.add(map.get("loop_value").toString());
        }
        return loopValues;
    }
}
