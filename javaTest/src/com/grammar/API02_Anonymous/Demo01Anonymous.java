package com.grammar.API02_Anonymous;

import java.util.Scanner;

/**
 *  了解匿名对象的写法
 *      注意事项：匿名对象只能使用唯一的一次，下次再用就得重新再创建一个新的对象。
 *      使用建议：如果确定有一个对象只需要使用唯一的一次，就可以用匿名对象。
 *  思考：在什么场景可以使用匿名对象呢？
 *      1.方法的参数是一个对象。
 *      2.返回值是一个对象。
 */
public class Demo01Anonymous {
    public static void main(String[] args) {
        //1.方法的参数是一个对象。
        //method1(new Scanner(System.in));

        //2.返回值是一个对象。
        Scanner scanner = method2();
        int i = scanner.nextInt();
        System.out.println("你输入的是："+i);
    }

    /**
     * 1.方法的参数是一个对象。
     */
    public static void method1(Scanner scanner){
        int i = scanner.nextInt();
        System.out.println("你输入的是"+i);
    }

    public static Scanner method2(){
        return new Scanner(System.in);
    }
}
