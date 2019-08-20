package com.grammar2.G03_interface;

/**
 *  问题描述：
 *      我们需要抽取一个共有方法，用来解决两个默认方法之间重复代码问题。
 *      但是这个共有方法不应该让实现类使用，应该是私有化的。
 *  解决方案：
 *      从Java9开始，接口当中允许定义私有方法。
 *      1.普通私有方法，解决多个默认方法之间重复代码问题
 *          格式：
 *              private 放回值类型 方法名称（参数列表）{
 *                  方法体
 *              }
 *      2.静态私有方法，解决多个静态方法之间重复代码问题。
 *          格式：
 *              private static 返回值类型 方法名称（参数列表）{
 *                  方法体
 *              }
 */
public interface Demo05_interface_private {
    public default void methodA(){
        System.out.println("这是A方法");

        //下面这三行代码是一个共性的方法
        /*System.out.println("a");
        System.out.println("b");
        System.out.println("c");*/
        //methodCommon();
    }

    public default void methodB(){
        System.out.println("这是B方法");

        /*System.out.println("a");
        System.out.println("b");
        System.out.println("c");*/
        //methodCommon();
    }

   /* private void methodCommon(){
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
    }*/


}
