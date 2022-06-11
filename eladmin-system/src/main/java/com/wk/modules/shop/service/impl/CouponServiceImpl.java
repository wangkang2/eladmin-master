package com.wk.modules.shop.service.impl;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 11:22
 * @Description: 
 */


import com.wk.exception.EntityExistException;
import com.wk.modules.shop.domain.Coupon;
import com.wk.modules.shop.repository.CouponRepository;
import com.wk.modules.shop.service.CouponService;
import com.wk.modules.shop.service.dto.CouponDto;
import com.wk.modules.shop.service.dto.CouponQueryCriteria;
import com.wk.modules.shop.service.mapstruct.CouponMapper;
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

/**
 * 优惠券实现类
 * @author wangkang
 * @date 2022/06/11 11:22
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;

    @Override
    public List<CouponDto> queryAll(CouponQueryCriteria criteria) {
        List<Coupon> list = couponRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return couponMapper.toDto(list);
    }

    @Override
    public Object queryAll(CouponQueryCriteria criteria, Pageable pageable) {
        Page<Coupon> page = couponRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(couponMapper::toDto).getContent(),page.getTotalElements());
    }

    @Override
    public void download(List<CouponDto> couponDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (CouponDto couponDto : couponDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("优惠券名称", couponDto.getName());
            if(couponDto.getCouponType()==1){
                map.put("优惠", "满" + couponDto.getFullReducedAmount() + "减" + couponDto.getPrice());
            }else{
                map.put("优惠", couponDto.getDiscount().divide(new BigDecimal(10)) + "折");
            }
            if(couponDto.getReceiveCondition()==1){
                map.put("领取次数", "每月可领取" + couponDto.getReceiveNum() + "次");
            }else if(couponDto.getReceiveCondition()==2){
                map.put("领取次数", "每周可领取" + couponDto.getReceiveNum() + "次");
            }else{
                map.put("领取次数", couponDto.getReceiveNum() + "次");
            }
            map.put("有效期", couponDto.getValidity().get(0) + "—" + couponDto.getValidity().get(1));
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(CouponDto resources) {
        Coupon coupon = couponRepository.findByNameAndDelFlag(resources.getName(), true);
        if(coupon != null){
            throw new EntityExistException(Coupon.class,"name",resources.getName());
        }
        Coupon couponNew = new Coupon();
        BeanUtils.copyProperties(resources,couponNew);
        couponNew.setValidityFrom(resources.getValidity().get(0));
        couponNew.setValidityTo(resources.getValidity().get(1));
        couponRepository.save(couponNew);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CouponDto resources) {
        Coupon coupon = couponRepository.findById(resources.getId()).orElseGet(Coupon::new);
        Coupon old = couponRepository.findByNameAndDelFlag(resources.getName(), true);
        if(old != null && !old.getId().equals(resources.getId())){
            throw new EntityExistException(Coupon.class,"name",resources.getName());
        }
        ValidationUtil.isNull( coupon.getId(),"Coupon","id",resources.getId());
        resources.setId(coupon.getId());
        Coupon couponNew = new Coupon();
        BeanUtils.copyProperties(resources,couponNew);
        couponNew.setValidityFrom(resources.getValidity().get(0));
        couponNew.setValidityTo(resources.getValidity().get(1));
        couponRepository.save(couponNew);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for(Long id:ids){
            Coupon coupon = couponRepository.findById(id).orElseGet(Coupon::new);
            coupon.setDelFlag(false);
            couponRepository.save(coupon);
        }
    }
}
