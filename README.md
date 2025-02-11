<div align="center">
  <img src="docs/resources/fit-logo.png" alt="FIT Logo" width="395">

  # FIT Framework v3.5.0-SNAPSHOT

  **面向全场景的 Java 企业级插件化编程框架，支持聚散部署和共享内存，以一切皆可替换为核心理念，旨在为用户提供一种灵活的服务开发范式。**

  [![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/license/MIT)
  [![JDK](https://img.shields.io/badge/JDK-17-green.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
</div>

----------
本项目提供了一套完整的大模型应用开发数据框架，主要包含三大模块：
- **FIT 函数框架**  
  - FIT 函数平台是一套支持多语言融合编程、插件化开发、聚散部署和共享内存的解决方案，它的核心设计理念是一切皆可替换，在不影响功能正确性的前提下，任意服务、任意插件等都应该是可以替换的，我们旨在通过以下特性，为用户提供一种灵活的服务开发范式。
    - **多语言融合编程：** FIT 调度支持多种编程语言，如 Java、Python、C 和 C++ 等，允许开发者根据具体需求选择合适的编程语言（目前先行开源 Java 部分）。FIT 函数调用中，屏蔽了目标实现语言细节，由于 FIT 的动态调度特性，真正的实现函数只有在运行时才会命中。
    - **插件化开发：** 插件化开发允许所有算子服务像函数即服务（FaaS）一样，被开发成独立的发布单位。这种方式为开发者提供了极大的灵活性，使他们可以根据需要将一个或多个算子单独封装，也可以选择将多个相关的算子组合到一个应用中进行集中开发。这种模块化的方法不仅简化了开发和部署过程，还提高了维护的效率，因为每个算子或算子集都可以独立更新和管理，而不影响其他部分的功能。
    - **聚散部署：**  FIT 框架中的插件化开发支持了一种灵活的聚散部署方式。这种部署策略允许算子发布单元（如 A 算子和 B 算子）以两种方式部署：它们可以聚合在一个单一的大型应用中部署，也可以各自独立部署在不同的容器中。 当算子发布单元聚合在一起部署时，即所有相关的算子都在同一个应用环境中运行，它们之间的调用如 A 调用 B，将通过内存中直接调用来执行，这种方式提高了执行效率并减少了调用延迟。而当算子分散部署时，如 A 和 B 分别部署在不同的容器里，A 算子调用 B 算子的操作将自动转化为远程调用。这种远程调用虽然可能增加一些通信开销，但提供了更高的灵活性和可扩展性。FIT 引擎在这一过程中扮演了关键角色，它自动判断和执行这些部署和调用变化，无需开发者手动更改代码。这种智能的自动化处理极大地简化了运维工作，使开发者可以专注于算子的逻辑和性能优化，而不是部署的细节。这样的设计不仅提高了系统的可维护性，也加强了其适应不同运行环境的能力。
  
- **WaterFlow 流调度引擎** 
  -  Waterflow 引擎致力于打破传统 BPM 工具与响应式编程工具之间的界限，通过引入一种既支持图形化配置也支持声明式编程的混合设计，为业务流程管理带来前所未有的灵活性和表达力。这种设计允许非技术背景的用户通过直观的图形界面设计复杂的业务流程，同时也支持开发者通过声明式编程构建高度定制化的数据处理逻辑。这不仅大大降低了业务流程设计和管理的门槛，也使得 Waterflow 能够灵活应对各种复杂场景，从而实现更高效的业务流程优化和数据处理。

- **FEL 标准原语（FIT Expression for LLM）** 
  - FEL 是构建在 Waterflow 之上的超集，统一完备的大模型开发原语体系。FEL 提供了一系列抽象和标准原语，作为 AI 应用程序的基础组件，开发者可以根据具体需求选择使用并自定义这些组件之间的调用规则。开发者无需关心复杂的流程调度和数据流转，只需关注业务逻辑和功能实现，这种编程方式大大简化了开发过程，降低了开发难度。
  - FEL 构建了大模型、知识存储对外的开发与访问标准。FEL 支持跨 AI 供应商的通用 API，屏蔽不同厂商之间的 API 差异，做到接口层面的统一调用。这使得开发者可以无缝集成多个 AI 服务，而无需担心底层实现的复杂性。 
  - 无论是在数据处理、模型训练还是推理应用中，FEL 都能显著提升开发效率和应用质量，成为下一代 AI 应用开发的重要工具。

## 环境配置

 开发环境配置

- 开发环境：`IntelliJ IDEA`
- Java 17
- 代码格式化文件：[CodeFormatterFromIdea.xml](CodeFormatterFromIdea.xml)
- `Maven` 配置：推荐版本 Maven 3.8.8+

 **构建命令**
```
mvn clean install
```

 **输出目录**

```
framework/fit/java/target
```

 **增加权限**

```
chmod +x framework/fit/java/target/bin/*
```

 **启动命令**

```
framework/fit/java/target/bin/fit start
```

> 以上编译构建出的 `fit` 命令可以通过系统操作（别名或添加系统路径）来简化输入。 

 **配置系统环境变量及创建插件目录**
- 首先用`maven`编译打包`./framework/fit/java`，将`target`目录内容存储在本地`fitframework`目录下，此目录为 FIT 核心框架目录地址。
- 配置`FIT`框架目录的系统环境变量，变量值为`FIT`核心框架目录地址，使`fit`命令可执行。例如 `FIT` 核心框架位置在`D:/demo/fitframework`，则变量值配置为`D:/demo/fitframework`。
- 新建任意目录作为插件目录，在该目录下存放插件，可在插件目录下使用命令`fit start`启动服务。
> 以上环境配置步骤请根据使用的操作系统使用相应的路径分隔符和环境变量配置操作。
## 快速开始

- FIT 函数框架 
  - 请参考 [FIT 快速开始](framework%2Ffit%2Fjava%2FREADME.md)，该指南将简单介绍 FIT 的核心设计概念，并指导您构建基础的应用。
- WaterFlow 流调度引擎 
  - 请参考 [WaterFlow 快速开始](framework%2Fwaterflow%2Fjava%2Fwaterflow-core%2FREADME.md)，该指南将简单介绍 WaterFlow 声明式语法，并构建流程输出`hello world！`。
- FEL 标准原语 
  - 请参考 [FEL 快速开始](docs/framework/fel/java/quick-start-guide/01.%20模型.md)，该指南将简要介绍如何使用 FEL 构建端到端的大模型应用程序。


## 文档

您可以从`docs`目录查看项目的完整文档，文档包含框架的快速入门指南和用户指导手册，并以一个基于本框架开发的大模型应用编排平台（Model Engine）为例，向您介绍本框架在商业化的成熟产品中是如何应用的。
- [ModelEngine 技术白皮书](docs/model-engine-technical-white-paper/00.%20摘要.md)
- [FIT 快速入门指南](docs/framework/fit/java/quick-start-guide/01.%20构建基础%20Web%20应用.md)、[用户指导手册](docs/framework/fit/java/user-guide-book/01.%20插件%E3%80%81IoC%20容器和%20Bean.md)
- [Waterflow 快速入门指南](docs/framework/waterflow/java/quick-start-guide/01.%20介绍.md)、[用户指导手册](docs/framework/waterflow/java/user-guide-book.md)
- [FEL 快速入门指南](docs/framework/fel/java/quick-start-guide/01.%20模型.md)、[用户指导手册](docs/framework/fel/java/user-guide-book/01.%20AI%20流程.md)


## 贡献

欢迎贡献者加入本项目。
请阅读 [CONTRIBUTING.md](CONTRIBUTING.md)，这将指导您完成分支管理、标签管理、提交规则、代码审查等内容。遵循这些指导有助于项目的高效开发和良好协作。

## 联系

1. 如果发现问题，可以在该项目的 `Issue` 模块内提出。
2. 微信公众号：`FitFramework`。
3. 微信技术交流群：通过公众号菜单“技术交流”点击获取最新群二维码。
4. QQ技术交流群：`1029802553`。

![wechat-gh](docs/resources/qrcode_for_wechat_gh.png)
![qq-01](docs/resources/qrcode_for_qq_01.png)
