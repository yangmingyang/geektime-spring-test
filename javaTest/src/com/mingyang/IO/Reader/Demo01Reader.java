package com.mingyang.IO.Reader;

import java.io.FileReader;
import java.io.IOException;

/**
 *  java.io.Reader:字符输入流，是字符输入流的最顶层的父类，定义了一些共性的成员方法，是一个抽象类
 *
 *  共性的成员方法：
 *      int read() 读取单个字符并返回
 *      int read(char[] cbuf) 一次读取多个字符，将字符读入数组
 *      void close() 关闭该流并释放与之关联的所有资源
 *
 *  java.io.FileReader extends InputStreamReader extends Reader
 *  FileReader:文件字符输入流
 *  作用：把硬盘文件中的数据以字符的方式读取到内存中
 *
 *  构造方法：
 *      FileReader(String fileName)
 *      FileReader(File file)
 *      参数：读取文件的数据源
 *          String fileName:文件的路径
 *          File file:一个文件
 *  FileReader构造方法的作用：
 *      1.创建一个FileReader对象
 *      2.会把FileReader对象指向要读取的文件
 */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:\\personalDoc\\2019\\August\\20190801.txt");
       /* int read = fileReader.read();
        System.out.println((char)read);

        read = fileReader.read();
        System.out.println((char)read);

        read = fileReader.read();
        System.out.println(read);
        System.out.println((char)read);*/
       //优化上面的代码
        /*int len ;
        while ((len=fileReader.read())!=-1){
            System.out.println((char) len);
        }*/
        //如果文件比较大，那可以定义一次读多个字符，继续优化
        int len ;
        char[] chars = new char[1024];
        while ((len=fileReader.read(chars))!=-1){
            System.out.println(len);
            System.out.println(new String(chars,0,len));
        }
        fileReader.close();
    }
}
