package com.mingYang.IO.Reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  使用try...catch...finally处理异常
 */
public class Demo06Writer_try_catch_finally {
    public static void main(String[] args) {
        FileWriter fw =null;
        try {
            //fw = new FileWriter("");
            fw = new FileWriter("D:\\personalDoc\\2019\\August\\writer4.txt");
            fw.write("使用try catch finally处理流异常");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //需要判断fw不能为空才调用close方法，因为该对象有可能在创建的时候异常
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
