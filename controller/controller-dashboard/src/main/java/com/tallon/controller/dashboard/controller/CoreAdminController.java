package com.tallon.controller.dashboard.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tallon.business.core.service.ICoreAdminService;
import com.tallon.common.response.ResponseResult;
import com.tallon.repository.core.domain.CoreAdmin;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

/**
* <p>
    * 管理员表 前端控制器
    * </p>
*
* @author Tallon
* @since 2020-08-07
*/
    @RestController
@RequestMapping("//core-admin")
        public class CoreAdminController {
        @Resource
        private ICoreAdminService coreAdminService;

        /**
        * 新增
        *
        * @param coreAdmin {@link CoreAdmin}
        * @return {@link ResponseResult}
        */
        @PostMapping("create")
        public ResponseResult create(@Valid @RequestBody CoreAdmin coreAdmin, BindingResult bindingResult) {
        // 表单验证
        if (bindingResult.hasErrors()) {
        return ResponseResult.failure(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        // 业务逻辑
        boolean created = coreAdminService.create(coreAdmin);
        if (created) {
        return ResponseResult.success("创建成功");
        }

        return null;
        }

        /**
        * 删除
        *
        * @param coreAdminId {@code Long}
        * @return {@link ResponseResult}
        */
        @DeleteMapping("remove/{coreAdminId}")
        public ResponseResult remove(@PathVariable Long coreAdminId) {
        // 业务逻辑
        boolean deleted = coreAdminService.remove(coreAdminId);
        if (deleted) {
        return ResponseResult.success("删除成功");
        }

        return null;
        }

        /**
        * 修改
        *
        * @param coreAdmin {@link CoreAdmin}
        * @return {@link ResponseResult}
        */
        @PutMapping("update")
        public ResponseResult update(@Valid @RequestBody CoreAdmin coreAdmin, BindingResult bindingResult) {
        // 表单验证
        if (bindingResult.hasErrors()) {
        return ResponseResult.failure(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        // 业务逻辑
        boolean updated = coreAdminService.update(coreAdmin);
        if (updated) {
        return ResponseResult.success("编辑成功");
        }

        return null;
        }

        /**
        * 获取
        *
        * @param coreAdminId {@code Long}
        * @return {@link ResponseResult}
        */
        @GetMapping("get/{coreAdminId}")
        public ResponseResult get(@PathVariable Long coreAdminId) {
        CoreAdmin coreAdmin = coreAdminService.get(coreAdminId);
        return ResponseResult.success(coreAdmin);
        }

        /**
        * 分页
        *
        * @param current {@code int} 页码
        * @param size    {@code int} 笔数
        * @return {@link ResponseResult}
        */
        @GetMapping("page")
        public ResponseResult page(
                @RequestParam int current, @RequestParam int size, @ModelAttribute CoreAdmin coreAdmin) {
        IPage<CoreAdmin> page = coreAdminService.page(current, size, coreAdmin);
        return ResponseResult.success(page);
        }

    }
