package cn.mingyang.web.w07_jsp;

/**
 EL表达式
    1.概念：Expression Language 表达式语言
    2.作用；替换和简化jsp页面中java代码编写
    3.语法：${表达式}
    4.注意：
        jsp默认支持el表达式的。如果要忽略el表达式
            1.设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
            2.\${表达式}：忽略当前这个el表达式
    5.使用：
        1.运算
            1.算数运算符：+ - * /(div) %(mod)
            2.比较运算符：> < >=  <= == !=
            3.逻辑运算符：&&(and)  ||(or)  !(not)
            4.空运算符：empty
                功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
                ${empty list}
        2.获取值
            1.el表达式只能从域对象中获取值
            2.语法：
                1.${域名称.键名}：从指定域中获取指定键的值。
                    域名称：
                        1.pageScope         --> pageContext
                        2.requestScope      --> request
                        3.sessionScope      --> session
                        4.applicationScope  --> application (ServletContext)
                2.${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。
            3.获取对象、List集合、Map集合的值
                1.对象：${域名称.键名.属性名}
                    本质上会去调用对象的getter方法
                2.List集合：${域名称.键名[索引]}
                3.Map集合：
                    ${域名称.键名.key名称}
                    ${域名称.键名["key名称"]}
        3.隐式对象
            el表达式中有11个隐式对象
            pageContext:
                该对象可以获取jsp其他八个内置对象
                    ${pageContext.request.contextPath}：动态获取虚拟目录
 */
public class demo04_jsp_el {
}
