package com.tallon.all.configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器配置
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:41
 */
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    // 由于这是单体打包器，将所有权限进行整合。分布式部署时每个项目单独管理权限
    private static final String CusPermission = "CusPermission";

    private static final String ClientPermission = "ClientPermission";

    private static final String PostPermission = "PostPermission";

    private static final String UserPermission = "UserPermission";

    private static final String AdminPermission = "AdminPermission";

    private static final String System = "System";

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // SessionCreationPolicy.STATELESS session 不放任何东西,适用于接口型无状态应用，节省资源
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http
                .exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                // index登录即可访问
                .antMatchers("/index").authenticated()
                .antMatchers("/core/cus/**").hasAnyAuthority(CusPermission)
                .antMatchers("/core/client/**").hasAnyAuthority(ClientPermission)
                .antMatchers("/core/post/**").hasAnyAuthority(PostPermission)
                .antMatchers("/core/user/**").hasAnyAuthority(UserPermission)
                .antMatchers("/core/admin/**").hasAnyAuthority(AdminPermission)
                .antMatchers("/").hasAnyAuthority(System);
    }

}