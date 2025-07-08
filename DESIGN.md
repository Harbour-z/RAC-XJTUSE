# 项目设计文档

## 项目配置

### SpringMVC统一响应

统一响应给前端的数据格式位于：src/main/java/com/example/mybatisplusdemo/common/Result.
java中：

* status是响应的状态；
* code是自定义格式码；
* message为响应消息，主要针对请求失败时的消息响应，方便排查；
* 泛型类型的data为真正响应的数据；
* otherData为保留数据，目的是支持未来的拓展；
#
## 接口开发

### 命名统一约定
与用户模块功能相关的Controller、Service、Mapper层的类以 `User` 开头，商家模块相关的以 `Merchant` 
开头，管理员相关的以 `Admin` 开头，内容发布与评论相关的以 `Content` 开头。

### Service层命名规约

接口以I开头+业务名称+功能，接口实现类置于Service包下的Impl包中，具体实现类的类名结尾需添加 `Impl`。

### 关于Result的code的约定含义
code：100表示出现注册重复