package com.mingyang.IO.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  java.io.InputStream:字节输入流
 *  此抽象类是表示字节输入流的所有类的超类。
 *
 *  定义了所有子类共性的方法：
 *      int read() 从输入流中读取数据的下一个字节。
 *      int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
 *      void close() 关闭此输入流并释放与该流关联的所有系统资源。
 *
 *  java.io.FileInputStream extends InputStream
 *  FileInputStream:文件字节输入流
 *  作用：把硬盘文件中的数据，读取到内存中使用
 *
 *  构造方法：
 *      FileInputStream(String name)
 *      FileInputStream(File file)
 *      参数：读取文件的数据源
 *          String name:文件路径
 *          File file:文件
 *  构造方法的作用：
 *      1.会创建一个FileInputStream对象
 *      2.会把FileInputStream对象指定构造方法中要读取的文件
 *
 *  读取数据的原理(硬盘-->内存)
 *      java程序-->JVM-->OS(操作系统)-->OS调用读取数据的方法-->读取文件
 *
 *  字节输入流的使用步骤（重点要掌握）：
 *      1.创建FileInputStream对象，构造方法中绑定要读取的数据源
 *      2.使用FileInputStream对象中的read方法，读取文件
 *      3.释放资源
 *
 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("D:\\personalDoc\\2019\\August\\20190802.txt"));
        /**
         *  重点掌握这个循环：
         *  布尔表达式（len=fis.read()）!=-1
         *  他做了三件事情：
         *  1.fis.read():读取一个字节
         *  2.len = fis.read()：把读取到的字节赋值给变量len
         *  3.(len = fis.read()) != -1:判断变量len是否不等于-1
         */
        int len;
        while ((len = fis.read()) != -1){
            System.out.println((char)len);
        }
        fis.close();
    }
}
