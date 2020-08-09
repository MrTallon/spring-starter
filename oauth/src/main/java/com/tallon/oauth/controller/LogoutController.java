package com.tallon.oauth.controller;

import com.tallon.common.response.ResponseCode;
import com.tallon.common.response.ResponseResult;
import com.tallon.common.web.Header;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 注销
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:40
 */
@RestController
@RequestMapping(value = "logout")
public class LogoutController {

	@Resource
	public TokenStore tokenStore;

	@Resource
	public HttpServletRequest request;

	/**
	 * 注销管理员
	 * @return {@link ResponseResult}
	 */
	@PostMapping("admin")
	public ResponseResult admin() {
		return logout();
	}

	/**
	 * 注销用户
	 * @return {@link ResponseResult}
	 */
	@PostMapping("user")
	public ResponseResult users() {
		return logout();
	}

	// 私有方法 ------------------------------------------- Begin

	private ResponseResult logout() {
		String token = Header.getAuthorization(request.getHeader("Authorization"));

		// 删除 token 以注销
		OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
		if (null != oAuth2AccessToken) {
			tokenStore.removeAccessToken(oAuth2AccessToken);
			return ResponseResult.success();
		}

		return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
	}

}
