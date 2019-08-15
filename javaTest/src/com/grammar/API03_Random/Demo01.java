package com.grammar.API03_Random;

import org.junit.Test;

import java.util.Random;

/**
 *  Random类用来生成随机数字。
 *      注意：
 *          1.获取一个随机的int数字（范围是int所有范围，有正反两种）: int num = r.nextInt();
 *          2.获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num = r.nextInt(3);
 *              实际上代表的含义是：[0,3),也就是0-2
 */
public class Demo01 {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt();
        System.out.println(num);
    }

    /**
     * 2.获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num = r.nextInt(3);
     */
    @Test
    public void demo(){
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(10);
            //这个随机数就只能取0到9之间的数字了
            System.out.println(num);
        }
    }

    /**
     *  要求：
     *      根据int变量n的值，来获取随机数字，方法[1,n],可以取到1也可以取到n.
     *  思路：
     *      定义一个int变量n,随意赋值，整体+1即可。
     */
    @Test
    public void demo02(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(10);
            System.out.println(num+1);
        }
    }
}
