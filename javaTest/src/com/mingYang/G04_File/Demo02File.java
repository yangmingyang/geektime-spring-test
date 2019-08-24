package com.mingYang.G04_File;

import org.junit.Test;
import java.io.File;

/**
 *  路径：
 *      绝对路径：是一个完整的路径
 *      相对路径：是一个简化的路径
 *
 *  注意：
 *      1.路径是不区分大下写
 *      2.路径中的文件名称分隔符window使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
 */

public class Demo02File {
    public static void main(String[] args) {
        /**
         *  File类的构造方法
         *      G04_File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 G04_File 实例。
         *      G04_File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 G04_File 实例。
         *      G04_File(G04_File parent, String child)  根据 parent 抽象路径名和 child 路径名字符串创建一个新 G04_File 实例。
         */

    }

    @Test
    public void show01(){
        /**
         *  G04_File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 G04_File 实例。
         *  参数：
         *      1.String pathname:字符串的路径名称
         *      2.路径可以是以文件结尾，也可以是以文件夹结尾
         *      3.路径可以是相对路径，也可以是绝对路径
         *      4.路径可以是存在，也可以是不存在
         *      5.创建File对象，只是把字符串路径封装为File对象，不考虑路径的真假情况
         */

        File file = new File("D:\\personalDoc\\2019\\August\\a.txt");
        System.out.println(file);//重写了toString的方法，返回的就是D:\personalDoc\2019\August\a.txt

        File file1 = new File("D:\\personalDoc\\2019\\August");
        System.out.println(file1);

        File file2 = new File("\\a.txt");
        System.out.println(file2);
    }

    @Test
    public void show2(){
        /**
         *  G04_File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 G04_File 实例。
         *      参数：把路径分成了两部分
         *          String parent：父路径
         *          String child：子路径
         *      好处：父路径和子路径，可以单独书写，使用起来非常灵活；父路径和子路径都可以变化
         */
        File file = new File("d:\\personalDoc\\2019\\August","a.txt");
        System.out.println(file);
    }

    @Test
    public void show3(){
        /**
         *  G04_File(G04_File parent, String child)  根据 parent 抽象路径名和 child 路径名字符串创建一个新 G04_File 实例。
         *      参数：把路径分成了两部分
         *          G04_File parent：父路径
         *          String child：子路径
         *          好处：
         *          1.父路径和子路径，可以单独书写，使用起来非常灵活；父路径和子路径都可以变化
         *          2.父路径是File类型，可以使用File的方法对路径进行一些操作，再使用路径创建对象
         */
        File file = new File("d:\\personalDoc\\2019\\August");
        File childFile = new File(file,"\\hello.txt");
        System.out.println(childFile);//d:\personalDoc\2019\August\hello.txt
    }
}
