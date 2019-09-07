package cn.mingyang.web.w01_servlet;

/**
 *  IDEA与Tomcat的相关配置
 *      1.IDEA会为每一个Tomcat部署的项目单独建立一份配置文件
 *          查看控制台的log:Using CATALINA_BASE:
 *          "C:\Users\Administrator.SC-201909031117\.IntelliJIdea2019.1\system\tomcat\Tomcat_8_5_45_myWeb"
 *      2.工作空间项目 和 Tomcat部署的web项目
 *          Tomcat真正访问的时“Tomcat部署的web项目”,“Tomcat部署的web项目”对应着“工作空间项目”的web目录下的所有资源
 *          WEB-INF目录下的资源不能被浏览器直接访问
 *      3.断点调试：使用“小虫子”启动debug启动。
 *
 */
public class ServletDemo04 {
}
