package com.tallon.oauth.service;

import java.util.Map;

/**
 * 登录
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:36
 */
public interface ILoginService {

	/**
	 * 登录成功后仅返回 Token
	 * @param username {@code String} 账号
	 * @param password {@code String} 密码
	 * @return {@code Map<String, String>} key: token
	 */
	Map<String, String> getToken(String username, String password);

	/**
	 * 刷新 Token
	 * @param accessToken {@code String} 使用旧 Token 换新 Token
	 * @return {@code Map<String, String>} 新 Token，key: token
	 */
	Map<String, String> refresh(String accessToken);

}
