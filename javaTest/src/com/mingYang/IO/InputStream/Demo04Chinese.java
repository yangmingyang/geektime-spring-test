package com.mingYang.IO.InputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *  使用字节流读取中文文件的相关问题
 *  一个中文，不同的格式，所占用的空间不同
 *      GBK格式：一个中文占用两个字节
 *      UTF-8:一个中文占用3个字节
 *
 *  解决方法：应该是读取文件的时候，需要指定对应的编码格式
 *
 */
public class Demo04Chinese {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\personalDoc\\2019\\August\\20190801.txt");
        int len;
        while ((len=fis.read())!=-1){
            System.out.println(len);
            System.out.println((char) len);//读出来的结果就是乱码，因为
        }
        fis.close();
    }
}
