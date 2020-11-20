package com.tallon.repository.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tallon.repository.core.domain.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author Tallon
 * @since 2020-11-19
 */
public interface TbPermissionMapper extends BaseMapper<TbPermission> {
    /**
     * 查询管理员权限名称
     * @param id 管理员id
     * @return 权限名称列表
     */
    List<String> tbAdminPermissions(@Param("id") Long id);

    /**
     * 查询用户权限名称
     * @param id 用户id
     * @return 权限名称列表
     */
    List<String> tbUserPermissions(@Param("id") Long id);
}
