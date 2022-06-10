
package com.wk.modules.system.service.dto;

import com.wk.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
* @author wang kang
* @date 2019-04-10
*/
@Getter
@Setter
public class DictDetailDto extends BaseDTO implements Serializable {

    private Long id;

    private DictSmallDto dict;

    private String label;

    private String value;

    private Integer dictSort;
}