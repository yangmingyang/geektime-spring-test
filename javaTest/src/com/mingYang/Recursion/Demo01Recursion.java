package com.mingYang.Recursion;

/**
 *  递归：方法自己调用自己
 *  递归的分类：
 *      递归分为两种，直接递归和间接递归。
 *      直接递归称为方法自身调用自身。
 *      间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法。
 *  注意事项：
 *      递归一定要有条件限定，保证递归能够停下来，否则会发生栈内存溢出。
 *      在递归中虽然有限定条件，但是递归次数不能太多。否则也会发生栈内存溢出。
 *      构造方法，禁止递归。
 *  递归的使用前提：
 *      当调用方法的时候，方法的主体不变，每次调用方法的参数不同，可以使用递归。
 */
public class Demo01Recursion {
    public static void main(String[] args) {
        //a();
        b(1);
    }

    public Demo01Recursion(){
        //构造方法，禁止递归,写出来代码后，直接报错，因为这样会创建无数个对象
        //Demo01Recursion();
    }

    public static void a(){
        /**
         *  a方法会在栈内存中一直调用a方法，就会导致栈内存中有无数多个a方法；
         *  方法太多了，超出了栈内存的大小，就会导致内存溢出的错误。
         *
         *  注意：
         *      当一个方法调用其他方法的时候，被调用的方法没有执行完毕，当前方法会一直等待调用的方法执行完毕，才会继续执行
         */
        System.out.println("a方法！");
        a();//最后会报Exception in thread "main" java.lang.StackOverflowError
    }

    public static void b(int i){
        System.out.println(i);
        if(i>20000){
            return;
        }
        //所以递归的次数也不能太多
        b(++i);//10516 Exception in thread "main" java.lang.StackOverflowError
    }

}
