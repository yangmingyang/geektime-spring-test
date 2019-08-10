package com.mingYang.IO.InputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  复制文件：原理就是一读一写
 *
 */
public class Demo03CopyFile {
    public static void main(String[] args) throws IOException {
        long begin = System.currentTimeMillis();
        //电脑存储的所有文件都是字节，所有使用字节流可以读取任意的文件
        FileInputStream fis = new FileInputStream("D:\\personalDoc\\2019\\baby\\a.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\personalDoc\\2019\\August\\baby.mp4");
        int len ;
        //这里可以是1024的整数倍
        byte[] bytes = new byte[1024*100];
        while ((len=fis.read(bytes))!=-1){
            //该方法时可以写有效的字符
            fos.write(bytes,0,len);
        }
        //两个流，要先关写的流，再关读的流
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"毫秒");
    }
}
