package com.mingyang.Recursion;

/**
 *  使用递归计算1 - n 之间的和
 */
public class Demo02Recursion {

    public static void main(String[] args) {
        int sum = sum1(100);
        System.out.println("for循环的结果："+sum);

        int s = sum(100);
        System.out.println("递归的结果："+s);
    }

    public static int sum1(int n){
        int sumNu =0;
        for (int i=1;i<=n;i++){
            sumNu += i;
        }
        return sumNu;
    }

    /**
     *  注意：
     *      使用递归求和，main方法调用sum方法，sum方法会一直调用sum方法
     *      导致在内存中有多个sum方法（频繁的创建方法，调用方法，销毁方法）效率低下
     *  所以如果仅仅是计算1-n之间的和，不推荐使用递归，而应该使用for循环即可
     */
    public static int sum(int n){
        if (n==1){
            return 1;
        }
        return n + sum(n-1);
    }
}
