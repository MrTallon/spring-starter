package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
* <p>
    * ${table.comment!} 服务类
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if kotlin>
    interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
    public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    /**
    * 新增
    * @param ${entity?uncap_first} {@link ${entity}}
    * @return {@code boolean}
    */
    boolean create(${entity} ${entity?uncap_first});

    /**
    * 删除
    * @param id {@code Long}
    * @return {@code boolean}
    */
    boolean remove(Long id);

    /**
    * 编辑
    * @param ${entity?uncap_first} {@link ${entity}}
    * @return {@code boolean}
    */
    boolean update(${entity} ${entity?uncap_first});

    /**
    * 获取
    * @param id {@code Long}
    * @return {@link ${entity}}
    */
    ${entity} get(Long id);

    /**
    * 分页
    * @param current {@code int} 页码
    * @param size {@code int} 笔数
    * @param ${entity?uncap_first} {@link ${entity}}
    * @return {@code IPage<${entity}>}
    */
    IPage<${entity}> page(int current, int size, ${entity} ${entity?uncap_first});
    }
</#if>