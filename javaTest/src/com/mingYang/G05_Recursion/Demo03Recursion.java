package com.mingYang.G05_Recursion;

/**
 *  练习：
 *      使用递归计算阶乘
 *      n的阶乘：n！ = n * (n-1) * (n-2) * ...* 3 * 2 * 1
 *
 */
public class Demo03Recursion {
    public static void main(String[] args) {
        int ji = ji(4);
        System.out.println(ji);
    }

    public static int ji(int n){
        if(n==1){
            return 1;
        }
        return n * ji(n-1);
    }
}
