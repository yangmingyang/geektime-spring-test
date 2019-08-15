package com.grammar.API01_Scanner;
import org.junit.Test;
import java.util.Scanner;

/**
 *  Scanner类的功能：可实现键盘输入数据到程序中。、
 *  引用类型的一般使用步骤：
 *      1.导包
 *          import 包路径.类名称；
 *          如果需要使用的目标类，和当前类位于同一个包下，则可以省略导包语句不写。
 *          只有java.lang包下的内容不需要导包，其他的包都需要import语句。
 *      2.创建
 *          类名称 对象名 = new 类名称（）;
 *      3.使用
 *          对象名.成员方法名（）
 *
 */
public class Demo01Scanner {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("输入的是"+i);

        String next = scanner.next();
        System.out.println("你输入的是："+next);*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int a = scanner.nextInt();
        System.out.println("请输入第二个数字：");
        int b = scanner.nextInt();
        System.out.println(a+b);
    }


    /**
     * 这样直接使用测试方法会报错，一直在加载，为什么呢？在main方法可以
     */
    @Test
    public void demo01(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int a = scanner.nextInt();
        System.out.println("请输入第二个数字：");
        int b = scanner.nextInt();
        System.out.println(a+b);
    }
}
