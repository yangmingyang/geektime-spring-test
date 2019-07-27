package com.mingyang.throwable;
import java.io.IOException;
/**
 *  try...catch:异常处理的第二种方式，自己处理异常
 *  格式：
 *      try{
 *          可能产生异常的代码
 *      }catch（定义一个异常的变量，用来接收try中抛出的异常对象）{
 *          异常的处理逻辑，异常异常对象之后，怎么处理异常对象
 *          一般在工作中，会把异常的信息记录到一个日志中
 *      }
 *      ...
 *      catch(异常类名 变量名){
 *
 *      }
 *   注意：
 *      1.try中可能会抛出多个异常对象，那么就可以使用多个catch来处理这些异常对象
 *      2.如果try中产生了异常，那么就会执行catch中的异常处理逻辑，执行完毕catch中的处理逻辑，继续执行try...catch之后的代码
 *        如果try中没有产生异常，那么就不会执行catch中异常的处理逻辑，执行完try中的代码，继续执行try...catch之后的代码
 *
 */
public class Demo06TryCatch {
    public static void main(String[] args) {
        try {
            readFile("d:\\a.tx");
            //readFile("d:\\a.txt");
        }catch (IOException e){
            //执行catch中的异常处理逻辑
            //System.out.println("文件后缀名不对");
            /**
             * Throwable类中定义了三个处理异常的方法：
             *      String getMessage​() 返回此throwable的详细消息字符串。
             *      String toString​() 返回此可抛出的简短描述。
             *      void printStackTrace​() 将此throwable和其追溯打印到标准错误流。
             */
            //System.out.println(e.getMessage());
            //System.out.println(e.toString());//重写了Object类的toString()方法
            //System.out.println(e);
            e.printStackTrace();//打印的信息最全面
            /**
             * java.io.IOException: 文件的后缀名不对
             * 	at com.mingyang.throwable.Demo06TryCatch.readFile(Demo06TryCatch.java:47)
             * 	at com.mingyang.throwable.Demo06TryCatch.main(Demo06TryCatch.java:25)
             */
        }
        System.out.println("继续执行后续代码");
    }


    public static void readFile(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }
        System.out.println("往后执行");
    }
}
