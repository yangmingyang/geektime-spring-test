package com.grammar2.G03_interface;

/**
 *  在任何版本的Java中，接口都能定义抽象方法。
 *  格式：
 *      public abstract 返回值类型 方法名称（参数列表）；
 *
 *  注意事项：
 *      1.接口当中的抽象方法，修饰符必须是两个固定的关键字：public abstract
 *      2.这两个关键字修饰符，可以选择性地省略。
 */
public interface Demo02_interface {
    //这是一个抽象方法
    public abstract void a();

    //这是一个抽象方法
    public  void b();

    ////这是一个抽象方法
    abstract void c();

    ////这是一个抽象方法
    void d();

}
