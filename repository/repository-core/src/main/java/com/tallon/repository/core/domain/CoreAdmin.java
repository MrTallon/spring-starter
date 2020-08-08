package com.tallon.repository.core.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tallon.common.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author Tallon
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("core_admin")
public class CoreAdmin extends BaseDomain {

	private static final long serialVersionUID = 6599380667773827830L;

	/**
	 * 登录名
	 */
	@NotBlank(message = "账号为必填项")
	private String username;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码为必填项")
	@Length(min = 6, max = 20, message = "密码长度在 6 - 20 位字符之间")
	private String password;

	/**
	 * 昵称
	 */
	@NotBlank(message = "昵称为必填项")
	private String nickname;

	/**
	 * 邮箱
	 */
	@NotBlank(message = "邮箱地址为必填项")
	@Email(message = "请输入正确的邮箱地址")
	private String email;

	/**
	 * 网址
	 */
	private String url;

	/**
	 * 用户状态：1(已启用) 0(已禁用)
	 */
	private Integer status;

	/**
	 * 逻辑删除：1(已删除) 0(未删除)
	 */
	@TableField(fill = FieldFill.INSERT)
	private Integer isDeleted;


}