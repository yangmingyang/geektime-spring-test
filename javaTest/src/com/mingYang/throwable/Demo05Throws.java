package com.mingYang.throwable;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  throws关键字：异常处理的第一种方式，交给别人处理
 *  作用：
 *      当方法内部抛出异常对象的时候，那么我们就必须处理这个异常对象
 *      可以使用throws关键字处理异常对象，会把异常对象声明抛出给方法的调用者处理（自己不处理，给别人处理），最终交给JVM处理-->中断处理
 *  使用格式：在方法声明时使用
 *      修饰符 返回值类型 方法名（参数列表） throws AAAException,BBBException...{
 *          throw new AAAException("产生原因");
 *          throw new BBBException("产生的原因");
 *      }
 *   注意：
 *      1.throws关键字必须写在方法声明处
 *      2.throws关键字后边声明的异常必须是Exception或者是Exception的子类
 *      3.方法内部如果抛出了多个异常对象，那么throws后面必须也声明多个异常
 *      4.调用了一个声明抛出异常的方法，我们就必须的处理声明的异常
 *          要么继续使用throws声明抛出，交给方法的调用者处理，最终交给JVM
 *          要么try...catch自己处理异常
 *
 *
 */
public class Demo05Throws {
    //public static void main(String[] args) throws FileNotFoundException,IOException
    public static void main(String[] args) throws IOException {
        readFile("c://a.txt");
    }

    //public static void readFile(String fileName) throws FileNotFoundException,IOException
    //因为IOException是FileNotFoundException父类，所以只要一个就可以了
    public static void readFile(String fileName) throws IOException {
        if (!fileName.equals("d://a.txt")){
            throw new FileNotFoundException("该文件路径不对");
        }

        if (!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }
    }
}
