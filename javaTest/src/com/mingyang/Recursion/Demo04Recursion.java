package com.mingyang.Recursion;

import java.io.File;

/**
 *  练习：
 *      递归打印多级目录
 *  需求：
 *      遍历某个文件夹，及文件夹的子文件夹
 *
 */
public class Demo04Recursion {
    public static void main(String[] args) {
        getAllFile(new File("D:\\personalDoc\\2019\\August"));
    }
    public static void getAllFile(File file){
        /**
         *  思考：
         *      遍历文件夹的终止条件是什么？
         *      判断该file是否一个文件夹，如果是则进行遍历，如果不是则终止
         */
        File[] files = file.listFiles();
        for (File f : files){
            boolean directory = f.isDirectory();
            if (directory==true){
                getAllFile(f);
            }
            //String name = f.getName();
            System.out.println(f);
        }
    }
}
