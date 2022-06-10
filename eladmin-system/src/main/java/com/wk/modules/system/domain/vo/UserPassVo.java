
package com.wk.modules.system.domain.vo;

import lombok.Data;

/**
 * 修改密码的 Vo 类
 * @author wang kang
 * @date 2019年7月11日13:59:49
 */
@Data
public class UserPassVo {

    private String oldPass;

    private String newPass;
}
