package com.grammar.API08_Math;

/**
 * 需求：计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？
 */
public class Demo02_Math_practise {
    public static void main(String[] args) {
        double min = -10.8;
        double max = 5.9;
        int count =0;
        //强转整数(int)min
        for (int i = (int)min;i<max;i++){
            int abs = Math.abs(i);
            if (abs<2.1 || abs>6){
                System.out.println(abs);
                count++;
            }
        }
        System.out.println("总共："+count);
    }
}
