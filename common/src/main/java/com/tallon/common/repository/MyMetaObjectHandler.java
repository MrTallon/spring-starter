package com.tallon.common.repository;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyBatis Plus 自动填充
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-08 10:47
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	/**
	 * 通用字段：创建时间
	 */
	private static final String CREATE_TIME = "createTime";

	/**
	 * 通用字段：更新时间
	 */
	private static final String UPDATE_TIME = "updateTime";

	/**
	 * 通用字段：已删除
	 */
	private static final String DELETED = "isDeleted";

	@Override
	public void insertFill(MetaObject metaObject) {
		// 判断是否有相关字段
		boolean hasCreateTime = metaObject.hasSetter(CREATE_TIME);
		boolean hasUpdateTime = metaObject.hasSetter(UPDATE_TIME);
		boolean hasDeleted = metaObject.hasSetter(DELETED);

		// 有字段则自动填充
		if (hasCreateTime) {
			strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
		}
		if (hasUpdateTime) {
			strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
		}
		if (hasDeleted) {
			strictInsertFill(metaObject, DELETED, Integer.class, 0);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		Object val = getFieldValByName(UPDATE_TIME, metaObject);
		// 没有自定义值时才更新字段
		if (val == null) {
			strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
		}
	}

}
