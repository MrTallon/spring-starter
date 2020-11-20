package com.tallon.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tallon.business.core.service.ICoreAdminService;
import com.tallon.common.base.BaseServiceImpl;
import com.tallon.common.excepetion.BusinessException;
import com.tallon.common.response.ResponseCode;
import com.tallon.repository.core.constant.UserStatus;
import com.tallon.repository.core.domain.CoreAdmin;
import com.tallon.repository.core.mapper.CoreAdminMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Tallon
 * @since 2020-08-07
 */
@Service
public class CoreAdminServiceImpl extends BaseServiceImpl<CoreAdminMapper, CoreAdmin> implements ICoreAdminService {

	@Resource
	private BCryptPasswordEncoder encoder;

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

	@Override
	public boolean create(CoreAdmin coreAdmin) {
		if (!checkUsername(coreAdmin.getUsername()) && !checkNickname(coreAdmin.getNickname())
				&& !checkEmail(coreAdmin.getEmail())) {
			coreAdmin.setStatus(UserStatus.CLOSED);
			// 密码加密
			coreAdmin.setPassword(encoder.encode(coreAdmin.getPassword()));
			return super.save(coreAdmin);
		}
		return false;
	}

	@Override
	public IPage<CoreAdmin> page(int current, int size, CoreAdmin coreAdmin) {
		Page<CoreAdmin> page = new Page<>(current, size);

		// 查询条件
		if (null != coreAdmin) {
			LambdaQueryWrapper<CoreAdmin> wrapper = new LambdaQueryWrapper<>();
			wrapper.eq(StringUtils.isNotBlank(String.valueOf(coreAdmin.getId())), CoreAdmin::getId, coreAdmin).or()
					.like(StringUtils.isNotBlank(String.valueOf(coreAdmin.getUsername())), CoreAdmin::getUsername,
							coreAdmin)
					.or()
					.like(StringUtils.isNotBlank(String.valueOf(coreAdmin.getNickname())), CoreAdmin::getNickname,
							coreAdmin)
					.or()
					.like(StringUtils.isNotBlank(String.valueOf(coreAdmin.getEmail())), CoreAdmin::getEmail, coreAdmin);
			return super.page(page, wrapper);
		}

		return super.page(page, null);
	}
	// 私有方法 ------------------------------------------- Begin

	/**
	 * 检查账号是否存在
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
