package com.mingYang.File;

import org.junit.Test;

import java.io.File;

/**
 *  File类遍历（文件夹）目录功能
 *       String[] list()
 *           返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
 *       File[] listFiles()
 *           返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
 *  注意：
 *      list方法和listFiles方法遍历的是构造方法中给出的目录
 *      如果构造方法中给出的目录的路径不存在，会抛出空指针异常
 *      如果国债方法中给出的路径不是一个目录，也会抛出空指针异常
 *
 */
public class Demo06File {
    @Test
    public void demo01(){
        File file = new File("D:\\personalDoc\\2019\\August");
        String[] list = file.list();
        for (String s : list){
            System.out.println(s);
        }
    }

    @Test
    public void demo02(){
        File file = new File("D:\\personalDoc\\2019\\August");
        File[] files = file.listFiles();
        for (File f : files){
            System.out.println(f);
            /**
             * 返回的结果：
             * D:\personalDoc\2019\August\a
             * D:\personalDoc\2019\August\a.txt
             * D:\personalDoc\2019\August\ab
             */
        }
    }
}
