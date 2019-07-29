package com.mingyang.File;

import org.junit.Test;

import java.io.File;

/**
 *  File判断功能方法：
 *  boolean exists() 测试此抽象路径名表示的文件或目录是否存在。
 *  boolean isDirectory() 测试此抽象路径名表示的文件是否是一个目录。
 *  boolean isFile() 测试此抽象路径名表示的文件是否是一个标准文件。
 */
public class Demo04File {
    @Test
    public void demo01(){
        File file = new File("D:\\personalDoc\\2019\\August\\a.txt");
        boolean exists = file.exists();
        System.out.println(exists);
    }

    @Test
    public void demo02(){
        File file = new File("D:\\personalDoc\\2019\\August\\a.txt");
        boolean directory = file.isDirectory();
        System.out.println(directory);
    }

    @Test
    public void demo03(){
        File file = new File("D:\\personalDoc\\2019\\August\\a.txt");
        boolean file1 = file.isFile();
        System.out.println(file1);
    }
}
