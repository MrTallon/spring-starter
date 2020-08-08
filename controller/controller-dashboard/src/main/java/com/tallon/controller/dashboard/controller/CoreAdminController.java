package com.tallon.controller.dashboard.controller;

import com.tallon.business.core.service.ICoreAdminService;
import com.tallon.common.base.BaseController;
import com.tallon.repository.core.domain.CoreAdmin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author Tallon
 * @since 2020-08-07
 */
@RestController
@RequestMapping("core/admin")
public class CoreAdminController extends BaseController<CoreAdmin, ICoreAdminService> {

}
