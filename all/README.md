适用于产品的初期运营阶段，利用单体应用的便利性先上线。该项目的依赖传递机制如下

单体应用打包器 -> 请求处理层 -> 业务逻辑层 -> 数据持久层
```
all -> controller-dashboard -> business-core -> repository-core
```