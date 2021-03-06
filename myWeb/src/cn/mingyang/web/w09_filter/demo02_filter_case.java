package cn.mingyang.web.w09_filter;

/**
 案例：
    案例1：登录验证
        需求：
            1.访问day17_case案例的资源。验证其是否登录。
            2.如果登录了。则直接放行。
            3.如果没有登录，则跳转到登录页面，提示“您尚未登录，请先登录”。

    案例2：敏感词汇过滤
        需求：
            1.对day17_case案例录入的数据进行敏感词汇过滤。
            2.敏感词汇参考《敏感词汇.txt》.
            3.如果是敏感词汇，替换为 ***

        分析：
            1.对request对象进行增强

        增强对象的功能：
            设计模式：一些通用的解决固定问题的方式
            1.装饰模式
            2.代理模式
                概念：
                    1.真实对象：被代理的对象。
                    2.代理对象
                    3.代理模式：代理对象代理真实对象，达到增强真实对象功能的目的。
                实现方式：
                    1.静态代理：有一个类文件描述代理模式。
                    2.动态代理：在内存中形成代理类。
                        实现步骤：
                            1.代理对象和真实对象实现相同的接口。
                            2.代理对象 = Proxy.newProxyInstance();
                            3.使用代理对象调用方法。
                            4.增强方法。
 */
public class demo02_filter_case {
}
