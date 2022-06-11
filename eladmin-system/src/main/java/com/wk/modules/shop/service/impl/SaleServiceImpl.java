package com.wk.modules.shop.service.impl;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:45
 * @Description: 
 */


import com.wk.modules.shop.domain.Sale;
import com.wk.modules.shop.repository.SaleRepository;
import com.wk.modules.shop.service.SaleService;
import com.wk.modules.shop.service.dto.SaleDto;
import com.wk.modules.shop.service.dto.SaleQueryCriteria;
import com.wk.modules.shop.service.mapstruct.SaleMapper;
import com.wk.utils.FileUtil;
import com.wk.utils.PageUtil;
import com.wk.utils.QueryHelp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
}
