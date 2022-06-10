
package com.wk.modules.security.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

/**
 * @author wang kang
 * @date 2018-11-30
 */
@Data
public class AuthUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";
}
