# 软院小学期后端项目

本项目为软件学院大二小学期专业实习项目，点评数据分析及推荐项目。

本项目分为前端和后端两个模块，以此进行前后端分离模式的开发。

这个仓库为后端的实现代码，项目技术栈为：SpringBoot+MySql。


## 项目配置

### 配置文件

本项目使用SpringBoot的“多环境配置（Profile）机制”和“配置源优先级规则”，根据激活的环境（Profile ）自动识别并加载对应环境的配置文件，多个配置文件的内容按优先级合并，形成最终的应用配置。

环境配置文件必须遵循固定命名格式：`application-{profile}.yml`，可以有dev（开发）、test（测试）、prod（生产）等不同配置。

`application.yml`：基础配置文件，存放所有环境通用的配置（如框架默认值、非敏感公共配置）

您在拉取项目后请将`application-templte.yml`复制一份到同一包下，即复制为`application-{profile}.yml`文件，对于非默认值信息，请取消注释并在对应项中填入您自己的相关配置信息（如数据库密码、端口号等）。