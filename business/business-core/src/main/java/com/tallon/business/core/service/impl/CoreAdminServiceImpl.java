package com.tallon.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tallon.business.core.service.ICoreAdminService;
import com.tallon.common.excepetion.BusinessException;
import com.tallon.common.response.ResponseCode;
import com.tallon.repository.core.domain.CoreAdmin;
import com.tallon.repository.core.mapper.CoreAdminMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Tallon
 * @since 2020-08-07
 */
@Service
public class CoreAdminServiceImpl extends ServiceImpl<CoreAdminMapper, CoreAdmin> implements ICoreAdminService {

    /**
     * 检查字段：ID
     */
    private static final String ID = "id";

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
        if (!checkUsername(coreAdmin.getUsername())
                && !checkNickname(coreAdmin.getNickname())
                && !checkEmail(coreAdmin.getEmail())) {
            return super.save(coreAdmin);
        }

        return false;
    }

    @Override
    public boolean remove(Long id) {
        if (checkId(id)) {
            return super.removeById(id);
        }
        return false;
    }

    @Override
    public boolean update(CoreAdmin coreAdmin) {
        if (checkId(coreAdmin.getId())) {
            return super.updateById(coreAdmin);
        }
        return false;
    }

    @Override
    public CoreAdmin get(Long id) {
        CoreAdmin coreAdmin = super.getById(id);
        if (null == coreAdmin) {
            throw new BusinessException(ResponseCode.USER_NOT_EXIST);
        }
        return coreAdmin;
    }

    @Override
    public IPage<CoreAdmin> page(int current, int size, CoreAdmin coreAdmin) {
        Page<CoreAdmin> page = new Page<>(current, size);

        // 查询条件
        if (null != coreAdmin) {
            LambdaQueryWrapper<CoreAdmin> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(CoreAdmin::getId, coreAdmin)
                    .or().like(CoreAdmin::getUsername, coreAdmin)
                    .or().like(CoreAdmin::getNickname, coreAdmin)
                    .or().like(CoreAdmin::getEmail, coreAdmin);
            return super.page(page, wrapper);
        }

        return super.page(page, null);
    }
    // 私有方法 ------------------------------------------- Begin

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

    /**
     * 检查 ID 是否存在
     *
     * @param id {@code Long} ID
     * @return {@code boolean} ID 不存在则抛出异常
     */
    private boolean checkId(Long id) {
        if (!checkUniqueness(ID, id)) {
            throw new BusinessException(ResponseCode.USER_NOT_EXIST);
        }
        return true;
    }

    private boolean checkUniqueness(String column, Object value) {
        QueryWrapper<CoreAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq(column, value);
        return super.count(wrapper) > 0;
    }
}
