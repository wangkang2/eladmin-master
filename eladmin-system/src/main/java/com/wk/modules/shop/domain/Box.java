package com.wk.modules.shop.domain;

import com.wk.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name="shop_box")
public class Box extends BaseEntity implements Serializable {
    @Id
    @Column(name = "box_id")
    @NotNull(groups = BaseEntity.Update.class)
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "盲盒名称")
    private String name;

    @Column(name = "pic_name")
    @ApiModelProperty(value = "盲盒图片名称")
    private String picName;

    @Column(name = "pic_path")
    @ApiModelProperty(value = "盲盒图片真实地址")
    private String picPath;

    @ApiModelProperty(value = "盲盒单价")
    private BigDecimal price;

    @Column(name = "ship_rule")
    @ApiModelProperty(value = "运货规则")
    private String shipRule;

    @ApiModelProperty(value = "盲盒描述")
    private String describe;

    @ApiModelProperty(value = "排序")
    private Integer boxSort;

    @Column(name = "del_flag",columnDefinition = "bit(1) default 1")
    @ApiModelProperty(value = "是否隐藏")
    private Boolean delFlag;

}
