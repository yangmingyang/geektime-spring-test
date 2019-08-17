package com.grammar.API08_Math;

/**
 *  java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作。
 *      public static double abc(double num):获取绝对值。
 *      public static double ceil(double num):向上取整。
 *      public static double floor(double num):向下取整。
 *      public static long round(double num):四舍五入。
 *
 */
public class Demo01_Math {
    public static void main(String[] args) {
        double d =-54.24;
        double abs = Math.abs(d);
        System.out.println(abs);//54.24

        double d1 = 10.34;
        double ceil = Math.ceil(d1);
        System.out.println(ceil);//11.0

        double floor = Math.floor(d1);
        System.out.println(floor);//10.0

        long round = Math.round(d1);
        System.out.println(round);//10
    }
}
