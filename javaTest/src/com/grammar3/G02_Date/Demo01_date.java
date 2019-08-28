package com.grammar3.G02_Date;

/**
 *  java.util.Date:表示日期和时间的类。
 *  类Date表示特定的瞬间，精确到毫秒。
 *  毫秒：千分之一秒（1000毫秒=1秒）。
 *
 *  毫秒值的作用：可以对时间和日期进行计算。
 *      可以日期转换为毫秒进行计算，计算完毕，再把毫秒转换为日期。
 *
 *  把日期转换为毫秒：
 *      时间原点（0毫秒）：1970年1月1日 00:00:00 （英国格林威治）
 *
 *  注意：
 *      中国属于东八区，会把时间增加8个小时
 *
 *  把毫秒转换为日期：
 *      1天 = 24 * 60 * 60 = 86400 秒 = 86400 * 1000 = 86400000 毫秒
 *
 */
public class Demo01_date {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//1566710152926
    }
}
