package com.mingYang.throwable;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  java.lang.Throwable
 *      Throwable类是Java语言中所有错误和异常的超类。
 *      Exception:编译期异常，进行编译（写代码）java程序出现的问题。
 *      Error:错误
 *          错误就相当于程序得了一个无法治愈的毛病、必须修改源代码，程序才能继续执行。
 *
 *
 *
 *
 */
public class Demo01Exception {
    public static void main(String[] args) throws ParseException {
        /**
         * Exception异常有两种处理方法：
         *      1.直接抛出去给虚拟机处理，程序不再往下执行；
         *      2.通过try catch捕获异常，并进行处理,程序还能往下继续执行。
         */
        method();
        method2();
    }

    public static void method() throws ParseException {
        //该方法就是直接把异常抛出去给虚拟机，程序不能再往下运行
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        //该时间有错误
        //Date d = sdf.parse("2039-333");
        Date d = sdf.parse("2019-07-27");
        System.out.println(d);
        System.out.println("有异常，程序不能继续执行");
    }

    public static  void method2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date d = sdf.parse("2039-333");
            //Date d = sdf.parse("2019-07-27");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("有异常，程序还能继续执行");
    }


}
