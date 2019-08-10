package com.mingYang.IO.OutputStream;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *  一次写入多个字节的方法：
 *   void write(byte[] b)： 将 b.length 个字节从指定 byte 数组写入此文件输出流中。
 *   void write(byte[] b, int off, int len) ：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
 *
 */
public class Demo02OutputStream {
    public static void main(String[] args) {

    }

    @Test
    public void demo1(){
        /**
         * write是可以多次写入数据的，所以也可以直接传入一个字节数组
         */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("D:\\personalDoc\\2019\\August\\20190801.txt"));
            fos.write(98);
            fos.write(98);
            fos.write(98);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void demo2() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\personalDoc\\2019\\August\\20190801.txt"));
        byte[] bytes = {98,98,98,98};
        //void write(byte[] b)： 将 b.length 个字节从指定 byte 数组写入此文件输出流中。
        fos.write(bytes);
        fos.close();
    }

    @Test
    public void demo3() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\personalDoc\\2019\\August\\20190801.txt"));
        byte[] bytes = {98,98,98,98};
        //void write(byte[] b, int off, int len) ：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
        fos.write(bytes,1,1);
        fos.close();
    }

    @Test
    public void demo4() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\personalDoc\\2019\\August\\20190801.txt"));
        /**
         *  String类中有一个方法时可以吧字符串转为字节数组
         *  getBytes()
         */
        byte[] bytes = "你好，名扬".getBytes();//[-28, -67, -96, -27, -91, -67, -17, -68, -116, -27, -112, -115, -26, -119, -84]
        System.out.println(Arrays.toString(bytes));
        fos.write(bytes);
        fos.close();
    }


}
