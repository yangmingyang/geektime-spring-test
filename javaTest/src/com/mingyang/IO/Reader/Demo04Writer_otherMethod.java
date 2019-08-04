package com.mingyang.IO.Reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  字符输出流写入数据的其他方法
 *  void write(char[] cbuf) 写入字符数组。
 *      abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分，off数组的开始索引，len写的字符个数。
 *      void write(String str) 写入字符串。
 *      void write(String str, int off, int len) 写入字符串的某一部分，off字符串的开始索引，len写的字符个数。
 *
 */
public class Demo04Writer_otherMethod {
    public static void main(String[] args) throws IOException {
        //1.创建FileWriter对象，构造方法中绑定要写入的数据的目的地
        FileWriter fileWriter = new FileWriter("D:\\personalDoc\\2019\\August\\writer2.txt");
        //2.使用FileWriter中write方法，把数据写入到内存缓存区中（这里涉及到一个字符转换为字节的过程）
        char[] chars ={'a','b','c','d'};
        fileWriter.write(chars);
        fileWriter.write(chars,2,1);
        fileWriter.write("大飞扬");
        fileWriter.write("大飞扬",1,1);
        // 3.使用FileWriter中flush方法，把内存缓冲区中的数据，刷新到文件中
        fileWriter.flush();
        //4.释放资源（会先把内存缓冲区中的数据刷新到文件中）
        fileWriter.close();
    }
}
