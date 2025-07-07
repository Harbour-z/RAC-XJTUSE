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