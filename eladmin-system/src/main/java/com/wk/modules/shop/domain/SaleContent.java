package com.wk.modules.shop.domain;

import com.wk.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="shop_sale_content")
public class SaleContent extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sale_id")
    @ApiModelProperty(value = "活动ID")
    private Long saleId;

    @Column(name = "sale_content")
    @ApiModelProperty(value = "活动内容")
    private String saleContent;
}
