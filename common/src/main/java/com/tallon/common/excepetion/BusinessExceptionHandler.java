package com.tallon.common.excepetion;

import com.tallon.common.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局业务异常处理
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-08 10:12
 */
@Slf4j
@ControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler({BusinessException.class, Exception.class})
    public ResponseEntity<?> handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> error = new HashMap<>(2);

        // 业务异常
        if (ex instanceof BusinessException) {
            error.put("code", ((BusinessException) ex).getCode());
            error.put("message", ex.getMessage());
            log.warn("[全局业务异常]\r\n业务编码：{}\r\n异常记录：{}", error.get("code"), error.get("message"));
        }

        // 未知错误
        else {
            error.put("code", ResponseCode.UNKNOWN.code());
            error.put("message", ResponseCode.UNKNOWN.message());
            log.error(ex.getMessage());
        }

        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}