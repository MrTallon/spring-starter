package com.tallon.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 通用领域模型接口
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-08 11:29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class BaseDomain implements Serializable {

	private static final long serialVersionUID = 8906592736940941841L;

}
