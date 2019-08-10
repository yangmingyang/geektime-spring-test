package com.mingYang.IO.InputstreamReader;

import java.io.*;

/**
 *  练习：转换文件编码
 *      将GBK编码的文本文件，转换为UTF-8编码的文本文件。
 *
 *  思路：
 *      先从硬盘中去取文件，然后再重新以不同编码格式的方式写回硬盘中，进行持久化保存。
 *  分析：
 *      1.创建InputStreamReader对象，构造方法中传递自己输入流和指定的编码表名称GBK.
 *      2.创建OutputStreamWriter对象，构造方法中传字节输出流和指定的编码表名称UTF-8.
 *      3.使用InputStreamReader对象中read方法读取文件。
 *      4.使用OutputStreamWriter对象中write方法，把读取的数据写入到文件中。
 *      5.释放资源。
 */
public class Demo02InputStreamReader_test {
    public static void main(String[] args) throws IOException {
        //1.创建InputStreamReader对象，构造方法中传递自己输入流和指定的编码表名称GBK.
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\personalDoc\\2019\\August\\gbk文本.txt"),"GBK");
        // 2.创建OutputStreamWriter对象，构造方法中传字节输出流和指定的编码表名称UTF-8.
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\personalDoc\\2019\\August\\uft8文本.txt"),"UTF-8");
        //3.使用InputStreamReader对象中read方法读取文件。
        int len;
        while ((len=isr.read())!=-1){
            //4.使用OutputStreamWriter对象中write方法，把读取的数据写入到文件中。
            osw.write(len);
        }
        //5.释放资源。
        osw.close();
        isr.close();
    }
}
