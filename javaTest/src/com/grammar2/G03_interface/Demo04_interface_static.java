package com.grammar2.G03_interface;

/**
 *  从Java8 开始，接口中允许定义静态方法。
 *  格式：
 *      public static 返回值类型 方法名称（参数列表）{
 *          方法体
 *      }
 *  提示：就是将abstract或者default换成static即可，带上方法体。
 *
 *  注意事项：不能通过接口实现类的对象来调用接口当中的静态方法。
 *  正确用法：通过接口名称，直接跳龙其中的静态方法。
 *  格式：
 *      接口名称.静态方法名（参数）;
 *
 */
public interface Demo04_interface_static {
    //public可以默认不写
    static void staticMethod(){
        System.out.println("我是一个静态接口类方法");
    }
}
