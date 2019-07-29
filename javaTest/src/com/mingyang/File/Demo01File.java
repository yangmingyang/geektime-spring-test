package com.mingyang.File;

import java.io.File;

/**
 *  java.io.File类
 *  文件和目录路径名的抽象表示形式。
 *  java把电脑中的文件和文件夹（目录）封装为一个File类，我们可以使用File类对文件和文件夹进行操作
 *  我们可以使用File类的方法
 *      创建一个文件/文件夹
 *      删除文件/文件夹
 *      判断文件/文件夹是否存在
 *      对文件夹进行遍历
 *      获取文件的大小
 *  File类是一个与系统无关的类，任务的操作系统都可以使用这个类的方法
 *
 *  重点：记住这三个单词
 *      file:文件
 *      directory：文件夹/目录
 *      path：路径
 */
public class Demo01File {
    public static void main(String[] args) {
        /**
         * static String pathSeparator
         *           与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
         * static char pathSeparatorChar
         *           与系统有关的路径分隔符。
         * static String separator
         *           与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
         * static char separatorChar
         *           与系统有关的默认名称分隔符
         *
         * 操作路径：路径不能写死了
         *  c:\file\a.txt     window
         *  /data/file/a.txt  linux
         *  那么我们就可以这样定义
         *  "c:"++"file"+\+“a.txt”
         */
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);//;    路径的分隔符 window:分号；  linux：冒号：

        String separator = File.separator;
        System.out.println(separator);//反斜杠\    文件名称分隔符 window：反斜杠\   linux:正斜杠/
    }








}
