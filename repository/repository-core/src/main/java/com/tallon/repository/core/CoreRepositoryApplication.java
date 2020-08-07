package com.tallon.repository.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-07 10:26
 */
@SpringBootApplication
@MapperScan(basePackages = "com.tallon.repository.core.mapper")
public class CoreRepositoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreRepositoryApplication.class, args);
    }

}