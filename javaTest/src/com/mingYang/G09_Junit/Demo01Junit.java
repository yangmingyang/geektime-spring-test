package com.mingYang.G09_Junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *  Junit单元测试：
 *      测试分类：
 *          1.黑盒测试：不需要写代码，给输入值，看程序是否能够输出期望的值。
 *          2.白盒测试：需要些代码。关注程序具体的执行流程。
 *
 *  Junit使用：白盒测试
 *      步骤：
 *          1.定义一个测试类（测试用例）
 *          建议：
 *              测试类名：被测试的类名+Test
 *              包名：xxx.xxx.xx.test
 *
 *          2.定义测试方法：可以独立运行
 *          建议：
 *              方法名：test测试的方法名
 *              返回值：void
 *              参数列表：空参
 *
 *          3.给方法加@Test
 *          4.导入junit依赖环境
 *      判定结果：
 *          红色：失败
 *          绿色：成功
 *          一般我们会使用断言操作来处理结果
 *              Assert.assertEquals(预期结果,实际结果);
 *
 *  补充：
 *      @Before:
 *          修饰的方法会在测试方法之前被自动执行
 *      @After:
 *          修饰的方法会在测试方法执行之后自动被执行
 *
 */
public class Demo01Junit {

    @Before
    public void init(){
        System.out.println("初始化之前执行");
    }

    @After
    public void close(){
        System.out.println("不管报不报错，都执行最后的方法");
    }

    @Test
    public void test(){
        //使用断言
        Assert.assertArrayEquals("me".getBytes(),"me1".getBytes());
        System.out.println("执行测试的过程");
    }

}
