package com.tallon.repository.core.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tallon.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Tallon
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_permission")
public class TbPermission extends BaseDomain {

	private static final long serialVersionUID = 1889589835446748446L;

	/**
	 * 父权限
	 */
	private Long parentId;

	/**
	 * 权限名称
	 */
	private String name;

	/**
	 * 权限英文名称
	 */
	private String enname;

	/**
	 * 授权路径
	 */
	private String url;

	/**
	 * 备注
	 */
	private String description;

}