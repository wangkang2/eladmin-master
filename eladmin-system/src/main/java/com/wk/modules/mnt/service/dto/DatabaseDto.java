
package com.wk.modules.mnt.service.dto;

import com.wk.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Getter
@Setter
public class DatabaseDto extends BaseDTO implements Serializable {

	/**
	 * id
	 */
    private String id;

	/**
	 * 数据库名称
	 */
    private String name;

	/**
	 * 数据库连接地址
	 */
    private String jdbcUrl;

	/**
	 * 数据库密码
	 */
    private String pwd;

	/**
	 * 用户名
	 */
    private String userName;
}
