package com.tallon.oauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tallon.repository.core.domain.CoreAdmin;
import com.tallon.repository.core.domain.CoreUser;
import com.tallon.repository.core.mapper.CoreAdminMapper;
import com.tallon.repository.core.mapper.CoreUserMapper;
import com.tallon.repository.core.mapper.TbPermissionMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义认证与授权
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-09 11:33
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private CoreAdminMapper coreAdminMapper;

    @Resource
    private CoreUserMapper coreUserMapper;

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 管理后台
        LambdaQueryWrapper<CoreAdmin> adminWrapper = new LambdaQueryWrapper<>();
        adminWrapper.eq(CoreAdmin::getUsername, username);
        CoreAdmin coreAdmin = coreAdminMapper.selectOne(adminWrapper);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (null != coreAdmin) {
            // 从数据库取出该用户所有权限
            List<String> permissions = tbPermissionMapper.tbAdminPermissions(coreAdmin.getId());
            permissions.forEach(t->grantedAuthorities.add(new SimpleGrantedAuthority(t)));
            // 由框架完成认证工作
            return new User(coreAdmin.getUsername(), coreAdmin.getPassword(), grantedAuthorities);
        }

        // 门户网站
        LambdaQueryWrapper<CoreUser> userWrapper = new LambdaQueryWrapper<>();
        userWrapper.eq(CoreUser::getUsername, username);
        CoreUser coreUser = coreUserMapper.selectOne(userWrapper);
        if (null != coreUser) {
            List<String> permissions = tbPermissionMapper.tbUserPermissions(coreUser.getId());
            permissions.forEach(t->grantedAuthorities.add(new SimpleGrantedAuthority(t)));            return new User(coreUser.getUsername(), coreUser.getPassword(), grantedAuthorities);
        }
        return null;
    }
}