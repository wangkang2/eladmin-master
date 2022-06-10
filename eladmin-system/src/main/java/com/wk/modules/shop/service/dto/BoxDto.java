package com.wk.modules.shop.service.dto;

import com.wk.base.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BoxDto extends BaseDTO implements Serializable {

    private Long id;

    private String name;

    private String picName;

    private String picPath;

    private BigDecimal price;

    private String shipRule;

    private String boxDescribe;

    private Integer boxSort;

    private Boolean delFlag;
}
