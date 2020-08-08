package com.tallon.repository.core.dto;

import com.tallon.repository.core.domain.CorePost;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文章数据传输对象
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-08 17:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CorePostDTO extends CorePost implements Serializable {
    private static final long serialVersionUID = 34667449769585688L;
    private String username;
}