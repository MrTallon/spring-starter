package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
* <p>
    * ${table.comment!} 服务实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
<#if kotlin>
    open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

    }
<#else>
    public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Override
    public boolean create(${entity} ${entity?uncap_first}) {
    return super.save(${entity?uncap_first});
    }

    @Override
    public boolean remove(Long id) {
    return super.removeById(id);
    }

    @Override
    public boolean update(${entity} ${entity?uncap_first}) {
    return super.updateById(${entity?uncap_first});
    }

    @Override
    public ${entity} get(Long id) {
    return super.getById(id);
    }

    @Override
    public IPage<${entity}> page(int current, int size, ${entity} ${entity?uncap_first}) {
    Page<${entity}> page = new Page<>(current, size);
    LambdaQueryWrapper<${entity}> wrapper = new LambdaQueryWrapper<>();

    // TODO 查询
    // TODO 排序

    return super.page(page, wrapper);
    }
    }
</#if>