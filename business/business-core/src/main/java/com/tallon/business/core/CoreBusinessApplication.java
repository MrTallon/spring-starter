package com.tallon.business.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 启动类
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-07 11:46
 */
@SpringBootApplication
@MapperScan(basePackages = "com.tallon.repository.core.mapper")
public class CoreBusinessApplication {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(CoreBusinessApplication.class, args);
	}

}
