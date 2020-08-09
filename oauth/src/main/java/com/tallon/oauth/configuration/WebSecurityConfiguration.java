package com.tallon.oauth.configuration;

import com.tallon.oauth.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 认证服务器配置
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:35
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean());
	}

	@Override
	public void configure(WebSecurity web) {
		// 忽略的访问路径
		web.ignoring().antMatchers("/login/**").antMatchers("/registry/user").antMatchers("/logout/**");
	}

}