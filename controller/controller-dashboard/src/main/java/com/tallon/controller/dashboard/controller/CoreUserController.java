package com.tallon.controller.dashboard.controller;

import com.tallon.business.core.service.ICoreUserService;
import com.tallon.common.base.BaseController;
import com.tallon.repository.core.domain.CoreUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Tallon
 * @since 2020-08-07
 */
@RestController
@RequestMapping("core/user")
public class CoreUserController extends BaseController<CoreUser, ICoreUserService> {

}
