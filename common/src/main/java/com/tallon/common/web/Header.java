package com.tallon.common.web;

import cn.hutool.core.util.StrUtil;
import com.tallon.common.excepetion.BusinessException;
import com.tallon.common.response.ResponseCode;

/**
 * 请求头处理
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:38
 */
public class Header {

    private static final String AUTHORIZATION_BEARER_TOKEN = "Basic ";

    /**
     * 获取 Token
     * @param header {@code String} request.getHeader("Authorization")
     * @return {@code String} token
     */
    public static String getAuthorization(String header) {
        if (StrUtil.isBlank(header) || header.startsWith(AUTHORIZATION_BEARER_TOKEN)) {
            throw new BusinessException(ResponseCode.USER_NOT_LOGGED_IN);
        }
        return header.substring(AUTHORIZATION_BEARER_TOKEN.length() + 1);
    }
}
