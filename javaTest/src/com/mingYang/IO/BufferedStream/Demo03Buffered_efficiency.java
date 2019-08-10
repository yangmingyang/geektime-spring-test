package com.mingYang.IO.BufferedStream;

import java.io.*;

/**
 *  缓冲输入流和缓冲输出流在读取和写入的效率比其他的字符流或者字节流效率更高
 *
 */
public class Demo03Buffered_efficiency {
    public static void main(String[] args) throws IOException {
        //例子：复制一个文件功能
        //思路：先读取文件，然后再写到硬盘中
        long begin = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\personalDoc\\2019\\baby\\a.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\personalDoc\\2019\\August\\b1.mp4"));
        int len;
        //没有加byte[]数组的时候，花了103毫秒，加了数组后8毫秒搞定，提高了10几倍的速度
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println(end-begin+"毫秒");//8毫秒
    }
}
