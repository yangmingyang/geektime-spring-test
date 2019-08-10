package com.mingYang.IO.Reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  java.io.Writer:字符输出流，是所有字符输出流的最顶层的父类，是一个抽象类
 *
 *  共性的成员方法：
 *      void write(int c) 写入单个字符。
 *      void write(char[] cbuf) 写入字符数组。
 *      abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分，off数组的开始索引，len写的字符个数。
 *      void write(String str) 写入字符串。
 *      void write(String str, int off, int len) 写入字符串的某一部分，off字符串的开始索引，len写的字符个数。
 *      void flush() 刷新该流的缓冲。
 *      void close() 关闭此流，但要先刷新它。
 *
 *  java.io.FileWriter extends OutputStreamWriter extends Writer
 *  FileWriter:文件字符输出流
 *  作用：把内存中的字符数组写入到文件中
 *
 *  构造方法：
 *      FileWriter(File file) 根据给定的 file 对象构造一个 FileWriter 对象。
 *      FileWriter(String fileName) 根据给定的文件名构造一个 FileWriter 对象。
 *      参数：写入数据的目的地
 *          String fileName:文件的路径
 *          File file:是一个文件
 *      构造方法的作用：
 *          1.会创建一个FileWriter对象
 *          2.会根据构造方法中传递的文件/文件的路径，创建文件
 *          3.会把FileWriter对象指向创建好的文件
 *
 *  字符输出流的使用步骤（重点）：
 *      1.创建FileWriter对象，构造方法中绑定要写入的数据的目的地
 *      2.使用FileWriter中write方法，把数据写入到内存缓存区中（这里涉及到一个字符转换为字节的过程）
 *      3.使用FileWriter中flush方法，把内存缓冲区中的数据，刷新到文件中
 *      4.释放资源（会先把内存缓冲区中的数据刷新到文件中）
 */
public class Demo02Write {
    public static void main(String[] args) throws IOException {
        //1.创建FileWriter对象，构造方法中绑定要写入的数据的目的地
        FileWriter fileWriter = new FileWriter("D:\\personalDoc\\2019\\August\\writer.txt");
        //2.使用FileWriter中write方法，把数据写入到内存缓存区中（这里涉及到一个字符转换为字节的过程）
        fileWriter.write("大飞扬");
        // 3.使用FileWriter中flush方法，把内存缓冲区中的数据，刷新到文件中
        fileWriter.flush();
        //4.释放资源（会先把内存缓冲区中的数据刷新到文件中）
        fileWriter.close();
    }
}
