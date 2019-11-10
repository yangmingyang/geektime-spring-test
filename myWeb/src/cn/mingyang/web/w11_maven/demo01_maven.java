package cn.mingyang.web.w11_maven;

/**
 maven项目标准目录结构：
    src/main/java   :核心代码部分。
    src/main/resources  :配置文件部分。
    src/test/java   :测试代码部分。
    src/test/resources  ：测试配置文件。
    src/test/webapp ：页面资源,js,css,图片等等。

 maven常用命令：
    1.mvn clean
    2.mvn compile
    3.mvn test
    4.mvn package
    5.mvn install

 maven生命周期
    清出项目编译信息    编码      测试      打包      安装      发布
        clean           compile   test      package   install   deploy
    每一个构建项目的命令都对应了maven底层一个插件。
 */
public class demo01_maven {
}
