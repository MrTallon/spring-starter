package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
* <p>
    * ${table.comment!} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
    @RestController
<#else>
    @Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
        public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
        public class ${table.controllerName} {
        @Resource
        private I${entity}Service ${entity?uncap_first}Service;

        /**
        * 新增
        *
        * @param ${entity?uncap_first} {@link ${entity}}
        * @return {@link ResponseResult}
        */
        @PostMapping("create")
        public ResponseResult create(@Valid @RequestBody ${entity} ${entity?uncap_first}, BindingResult bindingResult) {
        // 表单验证
        if (bindingResult.hasErrors()) {
        return ResponseResult.failure(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        // 业务逻辑
        boolean created = ${entity?uncap_first}Service.create(${entity?uncap_first});
        if (created) {
        return ResponseResult.success("创建成功");
        }

        return null;
        }

        /**
        * 删除
        *
        * @param ${entity?uncap_first}Id {@code Long}
        * @return {@link ResponseResult}
        */
        @DeleteMapping("remove/{${entity?uncap_first}Id}")
        public ResponseResult remove(@PathVariable Long ${entity?uncap_first}Id) {
        // 业务逻辑
        boolean deleted = ${entity?uncap_first}Service.remove(${entity?uncap_first}Id);
        if (deleted) {
        return ResponseResult.success("删除成功");
        }

        return null;
        }

        /**
        * 修改
        *
        * @param ${entity?uncap_first} {@link ${entity}}
        * @return {@link ResponseResult}
        */
        @PutMapping("update")
        public ResponseResult update(@Valid @RequestBody ${entity} ${entity?uncap_first}, BindingResult bindingResult) {
        // 表单验证
        if (bindingResult.hasErrors()) {
        return ResponseResult.failure(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        // 业务逻辑
        boolean updated = ${entity?uncap_first}Service.update(${entity?uncap_first});
        if (updated) {
        return ResponseResult.success("编辑成功");
        }

        return null;
        }

        /**
        * 获取
        *
        * @param ${entity?uncap_first}Id {@code Long}
        * @return {@link ResponseResult}
        */
        @GetMapping("get/{${entity?uncap_first}Id}")
        public ResponseResult get(@PathVariable Long ${entity?uncap_first}Id) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}Service.get(${entity?uncap_first}Id);
        return ResponseResult.success(${entity?uncap_first});
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
        @RequestParam int current, @RequestParam int size, @ModelAttribute ${entity} ${entity?uncap_first}) {
        IPage<${entity}> page = ${entity?uncap_first}Service.page(current, size, ${entity?uncap_first});
        return ResponseResult.success(page);
        }
    </#if>

    }
</#if>