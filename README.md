Sonar HTML Report Plugin
========================

基于SonarQube插件机制开发的、用于展示项目组成员代码质量的插件。

# Features

- 展示每个项目的每个开发者的Bug、漏洞、异味3个指标的详细数据；
- 每个指标均按照阻塞、严重、主要、次要、提示4个维度进行展示；
- 展示每个项目的Bug、漏洞、异味3个指标的总和数据；
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
  should be like `/opt/sonarqube/plugins`).

- Restart SonarQube.

- Open SoanrQube web UI: "More" > "HTML Report".
