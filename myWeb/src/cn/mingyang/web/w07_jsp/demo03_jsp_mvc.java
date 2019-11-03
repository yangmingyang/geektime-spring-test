package cn.mingyang.web.w07_jsp;

/**
 MVC：开发模式
    1.jsp演变历史
        1.早期只有servlet，只能使用response输出标签数据，非常麻烦
        2.后来有jsp,简化了Servlet的开发，如果过度使用jsp,在jsp中既写大量的java代码，有写html，造成难于维护，难分工。
        3.再后来，java的web开发，借鉴mvc开发模式，使得程序的设计更加合理性。
    2.MVC
        1.M:Model,模型。JavaBean
            完成具体的业务操作，如：查询数据库，封装对象
        2.V：View,视图。JSP
            展示数据
        3.C：Controller,控制器。Servlet
            获取用户的输入
            调用模型
            将数据交给视图进行展示
    3.优缺点
        1.优点：
            1.耦合性低，方便维护，可以利于分工协作。
            2.重用性高
        2.缺点：
            1.使得项目架构变得复杂，对开发人员要求高。
 */
public class demo03_jsp_mvc {
}
