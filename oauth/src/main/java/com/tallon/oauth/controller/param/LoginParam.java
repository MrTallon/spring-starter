package com.tallon.oauth.controller.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 登录参数
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginParam implements Serializable {

	private static final long serialVersionUID = 6227804428105653962L;

	/**
	 * 账号
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

}