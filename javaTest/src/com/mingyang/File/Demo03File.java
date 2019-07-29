package com.mingyang.File;

import org.junit.Test;

import java.io.File;

/**
 *  File获取功能的方法：
 *      String getAbsolutePath() 返回此抽象路径名的绝对路径名字符串。
 *      String getPath() 将此抽象路径名转换为一个路径名字符串。
 *      String getName() 返回由此抽象路径名表示的文件或目录的名称。
 *      long length() 返回由此抽象路径名表示的文件的长度。
 */
public class Demo03File {
    @Test
    public void demo01(){
        File file = new File("D:\\personalDoc\\2019\\August\\a.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
    }

    @Test
    public void demo02(){
        File file = new File("D:\\personalDoc\\2019\\August\\a.txt");
        String path = file.getPath();
        System.out.println(path);
    }

    @Test
    public void demo03(){
        //File file = new File("D:\\personalDoc\\2019\\August\\a.txt");
        File file = new File("D:\\personalDoc\\2019\\August");
        //返回由此抽象路径名表示的文件或目录的名称。
        //String name = file.getName();//a.txt
        String name = file.getName();//August
        System.out.println(name);
    }

    @Test
    public void demo04(){
        /**
         * 注意：
         *      文件夹是没有大小概念的，不能获取文件夹的大小
         *      如果构造方法中给出的路径不存在，那么length方法返回0
         */
        File file = new File("D:\\personalDoc\\2019\\July\\4.png");
        long length = file.length();//604455 字节
        System.out.println(length);
    }
}
