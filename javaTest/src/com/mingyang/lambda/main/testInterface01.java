package com.mingyang.lambda.main;

import com.mingyang.lambda.Interfaces.Impl.Father;

public class testInterface01 {
    /**
     * 如何调用匿名的函数方法？
     * 使用场景：比如要打印一个日志，日志是有级别的，但日志的级别是1的时候，才可以打印，如何实现该功能
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 该案例思考：为什么我在实现了该内部类的时候，然后最后去调用speak()方法的时候，不是去调用Father类中的方法，而是内部类的方法呢？
         * 答：实际上这个就是实现了java语言的多态了，如果不实现内部类去实现多态，那么实现接口的方法，就只能是一种形态。
         * 但我如果使用内部类去实现接口中的方法，那么我就是各种形式都可以实现，即我们想要的多态。
         */
        new Father(){
            @Override
            public void speak() {
                //super.speak();
                System.out.println("my会说");
            }
        }.speak();
        /*String msg1="hello";
        String msg2="java";
        String msg3="lambda";*/
        /**
         * 线程的这个写法，实际上就是往对象里传一个对象，然后我们传的实现内部类方法的对象而已
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程");
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2");
            }
        }).start();

        new Thread(()-> System.out.println("线程3")).start();

        //如果方法内容很多，那么就应该要加一个中括号
        new Thread(()->{
            System.out.println("线程4_1");
            System.out.println("线程4_2");
        }).start();
    }
}
