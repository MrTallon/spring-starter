package com.tallon.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:18
 */
@SpringBootApplication(scanBasePackages = "com.tallon")
@MapperScan(basePackages = "com.tallon.repository.core.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}