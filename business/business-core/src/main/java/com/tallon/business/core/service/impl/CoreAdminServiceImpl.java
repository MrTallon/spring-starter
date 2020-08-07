package com.tallon.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tallon.business.core.service.ICoreAdminService;
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

	@Override
	public boolean create(CoreAdmin coreAdmin) {
		return super.save(coreAdmin);
	}

	@Override
	public boolean remove(Long id) {
		return super.removeById(id);
	}

	@Override
	public boolean update(CoreAdmin coreAdmin) {
		return super.updateById(coreAdmin);
	}

	@Override
	public CoreAdmin get(Long id) {
		return super.getById(id);
	}

	@Override
	public IPage<CoreAdmin> page(int current, int size, CoreAdmin coreAdmin) {
		Page<CoreAdmin> page = new Page<>(current, size);
		LambdaQueryWrapper<CoreAdmin> wrapper = new LambdaQueryWrapper<>();

		// TODO 查询
		// TODO 排序

		return super.page(page, wrapper);
	}

}
