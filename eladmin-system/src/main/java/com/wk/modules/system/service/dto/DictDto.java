
package com.wk.modules.system.service.dto;

import com.wk.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
* @author wang kang
* @date 2019-04-10
*/
@Getter
@Setter
public class DictDto extends BaseDTO implements Serializable {

    private Long id;

    private List<DictDetailDto> dictDetails;

    private String name;

    private String description;
}
