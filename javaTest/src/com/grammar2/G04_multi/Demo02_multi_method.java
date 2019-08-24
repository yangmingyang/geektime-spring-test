package com.grammar2.G04_multi;

/**
 *  在多态的代码中，成员方法的访问规则是：
 *      看new的是谁，就优先用谁，没有则往上找。
 *
 *  口诀：编译看左边，运行看右边。
 *
 *  对比：
 *      成员变量：编译看左边，运行还看左边。
 *      成员方法：编译看左边，运行看右边。
 */
public class Demo02_multi_method {
    public static void main(String[] args) {
        Father father = new Son();//多态
        //父子类都有，右边new的是子类，优先用子类
        father.showString();//son
        father.fatherMethod();//父类特有的方法

        /**
         * 编译看左边，左边是Father,Father当中没有sonMethod方法，所以编译保存
         */
        //father.sonMethod();//错误写法！
    }
}
