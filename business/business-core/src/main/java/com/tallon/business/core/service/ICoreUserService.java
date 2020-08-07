package com.tallon.business.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tallon.repository.core.domain.CoreUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Tallon
 * @since 2020-08-07
 */
public interface ICoreUserService extends IService<CoreUser> {

	/**
	 * 新增
	 * @param coreUser {@link CoreUser}
	 * @return {@code boolean}
	 */
	boolean create(CoreUser coreUser);

	/**
	 * 删除
	 * @param id {@code Long}
	 * @return {@code boolean}
	 */
	boolean remove(Long id);

	/**
	 * 编辑
	 * @param coreUser {@link CoreUser}
	 * @return {@code boolean}
	 */
	boolean update(CoreUser coreUser);

	/**
	 * 获取
	 * @param id {@code Long}
	 * @return {@link CoreUser}
	 */
	CoreUser get(Long id);

	/**
	 * 分页
	 * @param current {@code int} 页码
	 * @param size {@code int} 笔数
	 * @param coreUser {@link CoreUser}
	 * @return {@code IPage<CoreUser>}
	 */
	IPage<CoreUser> page(int current, int size, CoreUser coreUser);

}
