package com.mingyang.Thread;

/**
 *  匿名内部类方式实现线程的创建
 *
 *  匿名：没有名字
 *  内部类：写在其他类内部的类
 *
 *  匿名内部类作用：简化代码
 *      把子类继承父类，重写父类的方法，创建子类对象合成一步完成
 *      把实现类实现接口，重写接口中的方法，创建实现类对象合成一步完成
 *  匿名内部类的最终产物：子类/实现类对象，而这个类没有名字
 *
 *  格式：
 *      new 父类/接口（）{
 *          重写父类/接口中的方法
 *      }
 *
 *
 */
public class Demo07InnerClassThread {
    public static void main(String[] args) {
        //重写父类的方式
        new Thread(){
            @Override
            public void run() {
                System.out.println("重写父类run方法来创建新线程");
                for (int i=0;i<10;i++){
                    System.out.println("父类："+Thread.currentThread().getName()+"==>"+i);
                }
            }
        }.start();

        //实现接口的方式
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("使用匿名内部类来创建线程");
                        for (int i=0;i<10;i++){
                            System.out.println("匿名类："+Thread.currentThread().getName()+"==>"+i);
                        }
                    }
                }
        ).start();
    }
}
