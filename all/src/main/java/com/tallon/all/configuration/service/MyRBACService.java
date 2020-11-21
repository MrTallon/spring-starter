package com.tallon.all.configuration.service;

import com.tallon.repository.core.mapper.TbPermissionMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 动态加载权限
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-21 11:07
 */
@Service("rbacService")
public class MyRBACService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 鉴权
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 用户主体
        Object principal = authentication.getPrincipal();

        // 该用户是合法用户
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            List<String> urls = tbPermissionMapper.tbAdminPermissionUrls(username);
            return urls.stream().anyMatch(url -> antPathMatcher.match(url, request.getRequestURI()));
        }
        return false;
    }
}
