## Start_Guide

项目本身的启动很简单，这里假设已经执行了：

`git clone git@github.com:wendisx/realtime_chat`

为了确保依赖能够正常构建，推荐使用同一版本的`maven`构建启动项目，项目使用`spring initializr`初始化的结构，所以可以直接根据使用的操作系统来快速启动项目，(注意：初次构建项目需要从远程仓库下载`maven`到本地，如果下载失败，尝试切换下载源)

进入项目根目录，根据操作系统执行如下指令：

on **Linux**:

`./mvnw spring-boot:run`

on **Windows**:

`./mvnw.cmd spring-boot:run`

等待构建完成即可