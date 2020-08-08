package com.tallon.repository.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tallon.repository.core.domain.CorePost;
import com.tallon.repository.core.dto.CorePostDTO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author Tallon
 * @since 2020-08-08
 */
public interface CorePostMapper extends BaseMapper<CorePost> {
    /**
     * 查询文章
     * @param page {@link IPage}
     * @param queryWrapper {@link Wrapper}
     * @return {@link IPage}
     */
    IPage<CorePostDTO> listByQuery(IPage<CorePostDTO> page, @Param(Constants.WRAPPER) Wrapper<CorePostDTO> queryWrapper);
}
