package com.tallon.all;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 单体应用打包
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-07 11:19
 */
@SpringBootApplication(scanBasePackages = { "com.tallon" })
@MapperScan(basePackages = "com.tallon.repository.**.mapper")
public class AllApplication {

	/**
	 * MyBatis Plus 分页插件
	 * @return {@link PaginationInterceptor}
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	public static void main(String[] args) {
		SpringApplication.run(AllApplication.class, args);
	}

}