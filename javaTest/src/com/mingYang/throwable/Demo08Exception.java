package com.mingYang.throwable;

import org.junit.Test;

/**
 *  多个异常捕获又该如何处理呢？
 *      1.多个异常分别处理
 *      2.多个异常一次捕获，多次处理
 *      3.多个异常一次捕获一次处理
 *
 */
public class Demo08Exception {
    //数组越界异常
    //使用List.of方法不能再使用add方法
    public static void main(String[] args) {
        /**
         * 1.多个异常分别处理
         */
        int[] arr ={0,1,2};
        try {
            int a = arr[3];
            System.out.println(a);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        /**
         * 2.多个异常一次捕获，多次处理
         *  一个try多个catch注意事项：
         *      catch里定义的异常变量，如果有子父类关系，那么子类的异常变量必须写在上边，否则就会报错
         */

        /**
         * 运行时异常被抛出可以不处理。既不捕获也不声明抛出。
         * 默认给虚拟机处理，终止程序，什么时候不抛出运行时异常了，在来继续执行程序
         */

        /**
         * 注意：
         *      父类有什么异常，子类也就得有什么异常即可。
         */
    }

    @Test
    public void method(){
        //JDK1.8所以不支持List.of方法
        //List<Integer> list = List.of(1, 2, 3);
        //list.get(1);
    }
}
