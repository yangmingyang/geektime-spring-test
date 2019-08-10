package com.mingYang.IO.Reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  续写和换行
 *  续写，也就是追加写：使用两个参数的构造方法：
 *      FileWriter(String fileName, boolean append)
 *      FileWriter(File file, boolean append)
 *  参数：
 *      String fileName,File file : 写入 数据的目的地
 *      boolean append : 续写开关 true:不会创建新的文件覆盖源文件，可以续写；false:创建新的文件覆盖源文件
 *
 *  换行：换行符号
 *      window:\r\n
 *      linux:/n
 *      mac:/r
 */
public class Demo05Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("D:\\personalDoc\\2019\\August\\writer3.txt", true);
        //fw.write("我要续写");
        //fw.write("abc");
        fw.write("\r\nymy");
        fw.flush();
        fw.close();
    }
}
