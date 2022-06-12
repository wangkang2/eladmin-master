package com.wk.modules.shop.domain;/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:19
 * @Description: 
 */


import com.wk.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 活动实体类
 * @author wangkang
 * @date 2022/06/11 18:19
 **/

@Entity
@Getter
@Setter
@Table(name="shop_sale")
public class Sale extends BaseEntity implements Serializable {
    @Id
    @Column(name = "sale_id")
    @NotNull(groups = Update.class)
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "活动名称")
    private String name;

    @Column(name = "wechat_pic_name")
    @ApiModelProperty(value = "微信引导图名称")
    private String wechatPicName;

    @Column(name = "wechat_pic_path")
    @ApiModelProperty(value = "微信引导图真实路径")
    private String wechatPicPath;

    @Column(name = "miniapp_pic_name")
    @ApiModelProperty(value = "小程序活动弹窗图名称")
    private String miniappPicName;

    @Column(name = "miniapp_pic_path")
    @ApiModelProperty(value = "小程序活动弹窗图真实路径")
    private String miniappPicPath;

    @Column(name = "background_pic_name")
    @ApiModelProperty(value = "活动背景图名称")
    private String backgroundPicName;

    @Column(name = "background_pic_path")
    @ApiModelProperty(value = "活动背景图真实路径")
    private String backgroundPicPath;

    @Column(name = "prize_pool_pic_name1")
    @ApiModelProperty(value = "奖池1图片名称")
    private String prizePoolPicName1;

    @Column(name = "prize_pool_pic_path1")
    @ApiModelProperty(value = "奖池1图片真实路径")
    private String prizePoolPicPath1;

    @Column(name = "prize_pool_pic_name2")
    @ApiModelProperty(value = "奖池2图片名称")
    private String prizePoolPicName2;

    @Column(name = "prize_pool_pic_path2")
    @ApiModelProperty(value = "奖池2图片真实路径")
    private String prizePoolPicPath2;

    @Column(name = "red_envelope_pic_name1")
    @ApiModelProperty(value = "红包1图片名称")
    private String redEnvelopePicName1;

    @Column(name = "red_envelope_pic_path1")
    @ApiModelProperty(value = "红包1图片真实路径")
    private String redEnvelopePicPath1;

    @Column(name = "coupon_id1")
    @ApiModelProperty(value = "优惠券ID1")
    private Integer couponId1;

    @Column(name = "coupon_name1")
    @ApiModelProperty(value = "优惠券名称1")
    private String couponName1;

    @Column(name = "red_envelope_pic_name2")
    @ApiModelProperty(value = "红包2图片名称")
    private String redEnvelopePicName2;

    @Column(name = "red_envelope_pic_path2")
    @ApiModelProperty(value = "红包2图片真实路径")
    private String redEnvelopePicPath2;

    @Column(name = "coupon_id2")
    @ApiModelProperty(value = "优惠券ID2")
    private Integer couponId2;

    @Column(name = "coupon_name2")
    @ApiModelProperty(value = "优惠券名称2")
    private String couponName2;

    @Column(name = "red_envelope_pic_name3")
    @ApiModelProperty(value = "红包3图片名称")
    private String redEnvelopePicName3;

    @Column(name = "red_envelope_pic_path3")
    @ApiModelProperty(value = "红包3图片真实路径")
    private String redEnvelopePicPath3;

//    @Column(name = "box_id3")
//    @ApiModelProperty(value = "盲盒ID3")
//    private Integer boxId3;
//
//    @Column(name = "box_name3")
//    @ApiModelProperty(value = "盲盒名称3")
//    private String boxName3;

    @Column(name = "is_loop")
    @ApiModelProperty(value = "是否循环 0否 1是")
    private String isLoop;

    @Column(name = "loop_type")
    @ApiModelProperty(value = "循环类型 1按周 2按月")
    private String loopType;

//    @Column(name = "loop_value")
//    @ApiModelProperty(value = "循环值")
//    private String loopValue;

    @Column(name = "loop_partake_num")
    @ApiModelProperty(value = "循环参与次数")
    private Integer loopPartakeNum;

    @Column(name = "fixed_from")
    @ApiModelProperty(value = "固定开始时间")
    private Timestamp fixedFrom;

    @Column(name = "fixed_to")
    @ApiModelProperty(value = "固定结束时间")
    private Timestamp fixedTo;

    @Column(name = "partake_condition")
    @ApiModelProperty(value = "参与条件 1每月限制 2每周限制 3不限制")
    private String partakeCondition;

    @Column(name = "partake_num")
    @ApiModelProperty(value = "参与次数")
    private Integer partakeNum;

    @Column(name = "share_text")
    @ApiModelProperty(value = "分享文字")
    private String shareText;

    @Column(name = "share_pic_name")
    @ApiModelProperty(value = "分享图片名称")
    private String sharePicName;

    @Column(name = "share_pic_path")
    @ApiModelProperty(value = "分享图片真实地址")
    private String sharePicPath;

    @Column(name = "del_flag",columnDefinition = "bit(1) default 1")
    @ApiModelProperty(value = "是否隐藏")
    private Boolean delFlag = true;

    @ApiModelProperty(value = "排序")
    private Integer saleSort;

    @Column(name = "enabled",columnDefinition = "bit(1) default 1")
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

}
