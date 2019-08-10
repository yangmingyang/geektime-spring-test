package com.mingYang.IO.Reader;

import java.io.FileWriter;
import java.io.IOException;

public class Demo07Writer_JDK7 {
    public static void main(String[] args) {
        //JDK7的新特性，可以再try()中声明变量
        try( FileWriter fw =new FileWriter("D:\\personalDoc\\2019\\August\\a.txt")) {
            fw.write("abc");
            fw.flush();
            //这样的写法可以自动关闭流
            //fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
