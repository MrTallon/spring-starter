package com.tallon.common.excepetion;

import com.tallon.common.response.ResponseCode;

/**
 * 全局业务异常
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-08 10:12
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 4868842805385777275L;

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException() {}

    public BusinessException(String message) {
        super(message);
        this.code = -1;
    }

    public BusinessException(ResponseCode status) {
        super(status.message());
        this.code = status.code();
    }
}