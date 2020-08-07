package com.tallon.business.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tallon.repository.core.domain.CoreAdmin;

/**
* <p>
    * 管理员表 服务类
    * </p>
*
* @author Tallon
* @since 2020-08-07
*/
    public interface ICoreAdminService extends IService<CoreAdmin> {
    /**
    * 新增
    * @param coreAdmin {@link CoreAdmin}
    * @return {@code boolean}
    */
    boolean create(CoreAdmin coreAdmin);

    /**
    * 删除
    * @param id {@code Long}
    * @return {@code boolean}
    */
    boolean remove(Long id);

    /**
    * 编辑
    * @param coreAdmin {@link CoreAdmin}
    * @return {@code boolean}
    */
    boolean update(CoreAdmin coreAdmin);

    /**
    * 获取
    * @param id {@code Long}
    * @return {@link CoreAdmin}
    */
    CoreAdmin get(Long id);

    /**
    * 分页
    * @param current {@code int} 页码
    * @param size {@code int} 笔数
    * @param coreAdmin {@link CoreAdmin}
    * @return {@code IPage<CoreAdmin>}
    */
    IPage<CoreAdmin> page(int current, int size, CoreAdmin coreAdmin);
    }
