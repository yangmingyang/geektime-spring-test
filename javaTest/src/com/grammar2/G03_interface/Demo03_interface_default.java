package com.grammar2.G03_interface;

/**
 *  从Java8 开始，接口里允许定义默认方法。
 *  格式：
 *      public default 返回值类型 方法名称（参数列表）{
 *          方法体
 *      }
 *  备注：接口当中的默认方法，可以解决接口升级的问题。
 *
 *  1.接口的默认方法，可以通过接口实现类对象，直接调用。
 *  2.接口的默认方法，也可以被接口实现类进行覆盖重写
 */
public interface Demo03_interface_default {

    public abstract void methodA();

    public default void defaultMethod(){
        System.out.println("这是一个默认的方法，到时候会在landom表达式中大量使用到");
    }
}
