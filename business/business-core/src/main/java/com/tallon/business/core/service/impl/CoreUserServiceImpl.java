package com.tallon.business.core.service.impl;

import com.tallon.business.core.service.ICoreUserService;
import com.tallon.common.base.BaseServiceImpl;
import com.tallon.repository.core.domain.CoreUser;
import com.tallon.repository.core.mapper.CoreUserMapper;
import org.springframework.stereotype.Service;

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

}
