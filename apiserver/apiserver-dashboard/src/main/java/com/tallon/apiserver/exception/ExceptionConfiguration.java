package com.tallon.apiserver.exception;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

/**
 * 全局系统异常配置
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-08 10:06
 */
@Configuration
public class ExceptionConfiguration {

	@Primary
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ErrorWebExceptionHandler errorWebExceptionHandler(ObjectProvider<List<ViewResolver>> viewResolversProvider,
			ServerCodecConfigurer serverCodecConfigurer) {
		JsonExceptionHandler jsonExceptionHandler = new JsonExceptionHandler();
		jsonExceptionHandler.setViewResolvers(viewResolversProvider.getIfAvailable(Collections::emptyList));
		jsonExceptionHandler.setMessageWriters(serverCodecConfigurer.getWriters());
		jsonExceptionHandler.setMessageReaders(serverCodecConfigurer.getReaders());
		return jsonExceptionHandler;
	}

}