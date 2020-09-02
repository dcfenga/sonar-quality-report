Sonar HTML Report Plugin
========================

基于SonarQube开发的、可生成HTML格式统计分析报告的插件。

基于[GeekSpring/SonarReport](https://github.com/GeekSpring/SonarReport)项目改进而来。

# Features

- 使用SonarQube分析项目组成员代码质量,并生成报表；
- 对Git提交用户展示进行优化处理；
- 支持SonarQube版本：7.9.3+。

# Building

```
mvn clean package
```

# Quickstart

- Setup a SonarQube instance.
- Run an analysis with sonar-scanner, maven, gradle, msbuild, etc.
- Execute generete html report:

  Copy the sonar-htmlreport-plugin.jar in the plugin folder of SonarQube (On linux path
  should be like `/opt/sonarqube/plugins`)

- Restart SonarQube (On linux: `sudo service sonar restart`)
