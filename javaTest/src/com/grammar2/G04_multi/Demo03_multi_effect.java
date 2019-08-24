package com.grammar2.G04_multi;

/**
 *  多态的好处：无论右边new的时候换成哪个子类对象，等号左边调用方法都不会改变。
 *
 */
public class Demo03_multi_effect {
    public static void main(String[] args) {
        /**
         * 场景分析；
         *  1.我们定义一个抽象类或者接口就叫做【员工类】，里面有一个work()抽象方法。
         *  2.那么接下来我们还有一个【讲师类】和【助教类】都是继承或者实现了【员工类】，
         *    那对应的类就需要覆盖重写里面的work方法。
         */

        //传统的方式调用work方法，都是创建对应的各自的对象
        Demo032_teacher teacher = new Demo032_teacher();
        teacher.work();//老师工作
        Demo033_assistant assistant = new Demo033_assistant();
        assistant.work();//助教工作

        System.out.println("=================================");

        //现在我们使用多态来实现
        //多态的好处：无论右边new的时候换成哪个子类对象，等号左边调用方法都不会改变。
        Demo031_employee one = new Demo032_teacher();
        one.work();//老师工作
        Demo031_employee two = new Demo033_assistant();
        two.work();//助教工作
    }
}
