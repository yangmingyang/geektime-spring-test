package com.mingyang.Thread.safety;
import com.mingyang.Thread.impl.RunnableImpl05;

public class Demo04Synchronized {
    public static void main(String[] args) {
        /**
         *  静态的同步方法
         *  锁对象是谁？
         *  答：不能是this,this是创建对象后产生的，静态方法优先于对象。
         *       静态方法的锁对象是本类的class属性-->class文件对象（反射）
         */
        RunnableImpl05 run = new RunnableImpl05();
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t0.start();
        t1.start();
        t2.start();
    }
}
