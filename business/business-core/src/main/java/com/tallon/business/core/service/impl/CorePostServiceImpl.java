package com.tallon.business.core.service.impl;

import com.tallon.business.core.service.ICorePostService;
import com.tallon.common.base.BaseServiceImpl;
import com.tallon.repository.core.domain.CorePost;
import com.tallon.repository.core.mapper.CorePostMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author Tallon
 * @since 2020-08-08
 */
@Service
public class CorePostServiceImpl extends BaseServiceImpl<CorePostMapper, CorePost> implements ICorePostService {

}
