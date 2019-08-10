package com.mingYang.IO.InputstreamReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  java.io.InputStreamReader extends Reader
 *  InputStreamReader:是字节流通向字符流的桥梁，他使用指定的 charset 读取字节并将其解码为字符。（解码：把看不懂的变成能看懂的）
 *
 *  继承自父类的共性成员方法：
 *      int read() 读取单个字符并返回
 *      int read(char[] cbuf) 一次读取多个字符，将字符读入数组
 *      void close() 关闭该流并释放与之关联的所有资源
 *
 *  构造方法：
 *      InputStreamReader(InputStream in) 创建一个默认字符集的 InputStreamReader.
 *      InputStreamReader(InputStream in, String charsetName) 创建使用指定字符集的 InputStreamReader.
 *      参数：
 *          InputStream in: 字节输入流，用来读取文件中保存的字节。
 *          String charsetName: 指定的编码表名称，不区分大小写，可以是uft-8/UTF-8,gbk/GBK,...不指定默认使用UTF-8
 *
 *  使用步骤：
 *      1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
 *      2.使用InputStreamReader对象中read方法读取文件。
 *      3.释放资源。
 *  注意事项：
 *      构造方法中指定的编码名称要和文件的编码相同，否则会发生乱码
 *
 */
public class Demo01InputStreamReader {
    public static void main(String[] args) throws IOException {
        //1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\personalDoc\\2019\\August\\gbk文本.txt"), "utf-8");
        //2.使用InputStreamReader对象中read方法读取文件。
        int len;
        while ((len=isr.read())!=-1){
            System.out.println((char)len);
        }
        //3.释放资源。
        isr.close();
    }
}
