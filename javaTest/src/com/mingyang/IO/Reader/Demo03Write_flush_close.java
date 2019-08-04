package com.mingyang.IO.Reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  flush方法和close方法的区别：
 *      flush: 刷新缓冲区，流对象可以继续使用。
 *      close: 先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
 */
public class Demo03Write_flush_close {
    public static void main(String[] args) throws IOException {
        //1.创建FileWriter对象，构造方法中绑定要写入的数据的目的地
        FileWriter fileWriter = new FileWriter("D:\\personalDoc\\2019\\August\\writer1.txt");
        //2.使用FileWriter中write方法，把数据写入到内存缓存区中（这里涉及到一个字符转换为字节的过程）
        fileWriter.write("大飞扬");
        // 3.使用FileWriter中flush方法，把内存缓冲区中的数据，刷新到文件中
        fileWriter.flush();
        //可以继续写入数据
        fileWriter.write("好牛逼");
        fileWriter.flush();
        //4.释放资源（会先把内存缓冲区中的数据刷新到文件中）
        fileWriter.close();
    }
}
