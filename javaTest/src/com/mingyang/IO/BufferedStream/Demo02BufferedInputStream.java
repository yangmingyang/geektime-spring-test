package com.mingyang.IO.BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  java.io.BufferedInputStream extends InputStream
 *  BufferedInputStream ；字节缓冲输入流
 *
 *  继承自父类的成员方法：
 *      int read() 从输入流中读取数据的下一个字节。
 *      int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
 *      void close() 关闭此输入流并释放与该流关联的所有系统资源。
 *
 *  构造方法：
 *      BufferedInputStream（InputStream in） 创建一个BufferedInputStream并保存其参数，即输入流in，以便将来使用。
 *      BufferedInputStream(InputStream in, int size) 创建具有指定缓冲区大小的BufferedInputStream并保存其参数，即输入流
 *      参数：
 *          InputStream in : 字节输入流
 *              我们可以传递FileInputStream,缓冲流会给FileInputStream增加一个缓冲区，提高FileInputStream的读取效率
 *          int size: 指定缓冲流内部缓冲区的大小，不指定默认
 *
 *  使用步骤（重点要掌握）：
 *      1.创建一个FileInputStream对象，构造方法中绑定要读取的数据源
 *      2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象的读取效率。
 *      3.使用BufferedInputStream对象中read方法，读取文件。
 *      4.释放资源
 *
 */
public class Demo02BufferedInputStream {
    public static void main(String[] args) throws IOException {
        //1.创建一个FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\personalDoc\\2019\\August\\a.txt");
        //2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象的读取效率。
        BufferedInputStream bis = new BufferedInputStream(fis);
        //3.使用BufferedInputStream对象中read方法，读取文件。
        int len;
        while ((len=bis.read())!=-1){
            System.out.println((char) len);
        }
        //释放资源
        bis.close();
    }
}
