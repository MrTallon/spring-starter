package com.tallon.business.core.service.impl;

import com.tallon.business.core.service.ICoreUserService;
import com.tallon.common.base.BaseServiceImpl;
import com.tallon.common.excepetion.BusinessException;
import com.tallon.common.response.ResponseCode;
import com.tallon.repository.core.constant.UserStatus;
import com.tallon.repository.core.domain.CoreUser;
import com.tallon.repository.core.mapper.CoreUserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Tallon
 * @since 2020-08-07
 */
@Service
public class CoreUserServiceImpl extends BaseServiceImpl<CoreUserMapper, CoreUser> implements ICoreUserService {

    /**
     * 检查字段：用户名
     */
    private static final String USERNAME = "username";

    /**
     * 检查字段：昵称
     */
    private static final String NICKNAME = "nickname";

    /**
     * 检查字段：邮箱
     */
    private static final String EMAIL = "email";

    @Resource
    private BCryptPasswordEncoder encoder;

    @Override
    public boolean create(CoreUser coreUser) {
        if (!checkUsername(coreUser.getUsername()) && !checkNickname(coreUser.getNickname())
                && !checkEmail(coreUser.getEmail())) {
            coreUser.setStatus(UserStatus.CLOSED);
            // 密码加密
            coreUser.setPassword(encoder.encode(coreUser.getPassword()));
            return super.save(coreUser);
        }
        return false;
    }

    /**
     * 检查账号是否存在
     *
     * @param username {@code String} 账号
     * @return {@code boolean} 账号已存在则抛出异常
     */
    private boolean checkUsername(String username) {
        if (checkUniqueness(USERNAME, username)) {
            throw new BusinessException(ResponseCode.USER_HAS_EXISTED);
        }
        return false;
    }

    /**
     * 检查昵称是否存在
     *
     * @param nickname {@code String} 昵称
     * @return {@code boolean} 昵称已存在则抛出异常
     */
    private boolean checkNickname(String nickname) {
        if (checkUniqueness(NICKNAME, nickname)) {
            throw new BusinessException(ResponseCode.USER_NICK_HAS_EXISTED);
        }
        return false;
    }

    /**
     * 检查邮箱是否存在
     *
     * @param email {@code String} 邮箱
     * @return {@code boolean} 邮箱已存在则抛出异常
     */
    private boolean checkEmail(String email) {
        if (checkUniqueness(EMAIL, email)) {
            throw new BusinessException(ResponseCode.USER_EMAIL_HAS_EXISTED);
        }
        return false;
    }
}
