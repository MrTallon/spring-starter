package com.tallon.controller.dashboard.controller;

import com.tallon.business.core.service.ICorePostService;
import com.tallon.common.base.BaseController;
import com.tallon.repository.core.domain.CorePost;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author Tallon
 * @since 2020-08-08
 */
@RestController
@RequestMapping("core/post")
public class CorePostController extends BaseController<CorePost, ICorePostService> {

}
