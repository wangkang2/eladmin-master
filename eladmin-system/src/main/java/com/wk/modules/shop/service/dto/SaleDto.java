package com.wk.modules.shop.service.dto;
/**
 * @Author: WANGKANG
 * @Date: 2022/6/11 18:53
 * @Description: 
 */

import com.wk.base.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * @author wangkang
 * @date 2022/06/11 18:53
 **/

@Getter
@Setter
@NoArgsConstructor
public class SaleDto extends BaseDTO implements Serializable {

    private Long id;

    private String name;

    private String wechatPicName;

    private String wechatPicPath;

    private String miniappPicName;

    private String miniappPicPath;

    private String backgroundPicName;

    private String backgroundPicPath;

    private String prizePoolPicName1;

    private String prizePoolPicPath1;

    private String prizePoolPicName2;

    private String prizePoolPicPath2;

    private String redEnvelopePicName1;

    private String redEnvelopePicPath1;

    private Integer couponId1;

    private String couponName1;

    private String redEnvelopePicName2;

    private String redEnvelopePicPath2;

    private Integer couponId2;

    private String couponName2;

    private String redEnvelopePicName3;

    private String redEnvelopePicPath3;

    private Integer boxId3;

    private String boxName3;

    private String isLoop;

    private String loopType;

    private String loopValue;

    private Integer loopPartakeNum;

    private List<Timestamp> fixed;

    private Timestamp fixedFrom;

    private Timestamp fixedTo;

    private String partakeCondition;

    private Integer partakeNum;

    private String shareText;

    private String sharePicName;

    private String sharePicPath;

    private Boolean delFlag = true;

    private Integer saleSort;

    private Boolean enabled;

}
