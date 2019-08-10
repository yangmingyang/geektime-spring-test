package com.mingYang.throwable;

/**
 *  异常处理逻辑
 *
 */
public class Demo02Exception {
    public static void main(String[] args) {
        int[] arr ={0,1,2};
        int e = getElement(arr,3);
        System.out.println(e);
        /**
         *  2.main方法接收到这个异常对象，main方法也没有异常的处理逻辑，继续把对象抛出给main方法的调用者JVM处理
         *
         *  3.JVM接收到这个异常对象，做了两件事情
         *      1.把异常对象（内容，原因，位置）以红色的字体打印在控制台
         *      2.JVM会终止当前正在执行的java程序-->中断处理
         */
    }

    public static int getElement(int[] arr,int index){
        return arr[index];//3
        /**
         * 1.访问了数组中的3索引，而数组是没有3索引的，JVM就会检测出程序会出现异常
         * JVM会做两件事情：
         *      1.JVM会根据异常产生的原因创建一个异常对象，这个异常对象包含了异常产生的（内容，原因，位置）
         *          new ArrayIndexOutOfBoundsException("3");
         *      2.在getElement方法中，没有异常的处理逻辑（try...catch）,那么JVM就会把异常对象抛出给方法的调用者main方法来处理这个异常
         */
    }
}
