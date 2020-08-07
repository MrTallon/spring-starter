# Spring Cloud Alibaba Dubbo

> 基于 Spring Cloud Alibaba Dubbo,实现对内 RPC、对外 REST 接口的脚手架

## 概述
微服务架构是一种架构思想（架构就是为了解耦），实际的开发方式是分布式系统开发。分布式系统其实就是将原来的单体应用程序（SSM）解耦成一个个独立的服务（利用微服务架构编程思想进行拆分）分别进行部署，这对于用户来说其实是不可见的

## 部署策略
部署单体应用程序意味着运行一个或多个相同副本的单个较大的应用程序。通常会在每台服务器上配置 N 个服务器（物理或虚拟）并运行 M 个应用程序实例。

微服务应用程序由数十甚至上百个服务组成。服务以不同的语言和框架编写。每个都是一个迷你的应用程序，具有自己特定的部署、资源、扩展和监视要求。
![部署](https://mrtallon.gitee.io/img/bushu.jpg)

## 应用分层
![分层](https://mrtallon.gitee.io/img/ceng.jpg)
- 开放接口层： 可直接封装 Service 方法暴露成 RPC 接口；通过 Web 封装成 HTTP 接口； 进行网关安全控制、 流量控制等。
- 终端显示层： 各个端的模板渲染并执行显示的层。 当前主要是模板引擎渲染， JS 渲染，移动端展示等。
- 请求处理层： 主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
- 业务逻辑层： 相对具体的业务逻辑服务层。
- 通用处理层： 通用业务处理层，它有如下特征：
    - 对第三方平台封装的层，预处理返回结果及转化异常信息。
    - 对 业务逻辑层 通用能力的下沉，如缓存方案、 中间件通用处理。
    - 与 数据访问层 交互，对多个 数据访问层 的组合复用。
- 数据访问层： 与底层 MySQL、 Oracle、 Hbase 等进行数据交互。
- 外部接口或第三方平台： 包括其它部门 RPC 开放接口，基础平台，其它公司的 HTTP 接口。

## 分层异常处理
在 DAO 层，产生的异常类型有很多，无法用细粒度的异常进行 catch，使用 catch(Exception e)方式，并 throw new DAOException(e)，不需要打印日志，因为日志在 Manager/Service 层一定需要捕获并打印到日志文件中去，如果同台服务器再打日志，浪费性能和存储。在 Service 层出现异常时，必须记录出错日志到磁盘，尽可能带上参数信息，相当于保护案发现场。如果 Manager 层与 Service 同机部署，日志方式与 DAO 层处理一致，如果是单独部署，则采用与 Service 一致的处理方式。 Web 层绝不应该继续往上抛异常，因为已经处于顶层，如果意识到这个异常将导致页面无法正常渲染，那么就应该直接跳转到友好错误页面， 加上用户容易理解的错误提示信息。开放接口层要将异常处理成错误码和错误信息方式返回。

## 分层领域模型
- DO（ Data Object）： 此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
- DTO（ Data Transfer Object）： 数据传输对象， Service 或 Manager 向外传输的对象。
- BO（ Business Object）： 业务对象， 由 Service 层输出的封装业务逻辑的对象。
- AO（ Application Object）： 应用对象， 在 Web 层与 Service 层之间抽象的复用对象模型，极为贴近展示层，复用度不高。
- VO（ View Object）： 显示层对象，通常是 Web 向模板渲染引擎层传输的对象。
- Query： 数据查询对象，各层接收上层的查询请求。 注意超过 2 个参数的查询封装，禁止使用 Map 类来传输。

## 目录结构
- dependencies： 通用依赖版本控制：依赖于一个二方库群时，必须定义一个统一的版本变量，避免版本号不一致。
- parent： 通用父工程：产品线下的所有项目必须指定一个父工程项目，以复用 POM 的 <build> 配置
- commons： 通用类库工具类：如 HuTool 等开源类库依赖或二次开发等
- generator： 通用代码生成器：如 MyBatis Plus 等其它开源类库或自定义代码生成器
- repository： 数据访问层：与底层 MySQL、 Oracle、 Hbase 等进行数据交互。
- business： 业务逻辑层：相对具体的业务逻辑服务层。
- manager： 通用处理层：对第三方平台封装的层，预处理返回结果及转化异常信息。对业务逻辑层通用能力的下沉，如缓存方案、 中间件通用处理。与数据访问层交互，对多个数据访问层的组合复用。
- controller： 请求处理层：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
- apiserver： 开放接口网关层：可直接封装 Service 方法暴露成 RPC 接口；通过 Web 封装成 HTTP 接口； 进行网关安全控制、 流量控制等。
- cloud： 外部接口或第三方平台：包括其它部门 RPC 开放接口，基础平台，其它公司的 HTTP 接口。
- oauth： 认证与授权：独立的认证与授权服务
- all： 单体应用打包器：适用于产品的初期运营阶段，利用单体应用的便利性先上线属于临时过渡项目。
- dashboard： 终端显示层：前后分离方案，采用 Vue + ElementUI 组件库实现的平台控制面板项目。
- portal： 终端显示层：前后分离方案，采用 Vue + Vuetify 组件库实现的平台门户网站项目。
- bin： 用于存放构建工具的目录
- docs： 用于存放项目文档的目录

## 关于接口幂等性的说明
### 接口调用的问题
在微服务架构的系统下会包含多个子系统服务，一个子系统服务又会调用另一个系统服务（链式调用模式），在通信的过程中就有可能出现返回结果的时候挂掉，如果系统长时间没有反应用户就会多次点击按钮，这样请求多次肯定会造成处理数据的结果不一致，此时我们就需要统一数据处理结果。

### 接口幂等性
所谓接口幂等性就是用户对于同一操作发起的一次请求或者多次请求的结果是一致的。比如，用户支付扣款成功，返回结果的时候网络异常，其实钱已经扣了，用户再次点击支付会出现多次扣款的情况，这就说明接口没有保证幂等性。

### RESTful 风格
GET：查询操作（幂等），在数据不变的情况下，查询一次和多次数据始终是一致的，所以 GET 请求是幂等的。
DELETE：删除操作（幂等），删除一次和多次都是把数据删除，在不考虑返回结果的情况下删除操作是幂等的。
PUT：更新操作（幂等），比如提供一个接口修改用户的密码为 123456，更新一次和多次结果都是 123456，所以 PUT 请求是幂等的。
POST：新增操作（非幂等），创建资源，重复提交 POST 请求可能产生多个不同的资源，所以 POST 请求是非幂等的。
注意： 某些场景下新增操作也需要做到幂等性，等到具体业务时再说明如何实现。


