package com.mingYang.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *  File类创建删除功能的方法
 *       boolean createNewFile() 当且仅当具有该名称的文尚不存在时，创建一个新的空文件。
 *       boolean delete() 删除此抽象路径名表示的文件或目录。
 *       boolean mkdir() 创建此抽象路径名指定的目录。
 *       boolean mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
 */
public class Demo05File {
    @Test
    public void demo01(){
        /**
         *  boolean createNewFile() 当且仅当具有该名称的文尚不存在时，创建一个新的空文件。
         *  创建文件的路径和名称在构造方法中给出（构造方法的参数）
         *  返回值：布尔值
         *      true:文件不存在，创建文件，返回true
         *      false:文件存在，不会创建，返回false
         *  注意：
         *      1.此方法只能创建文件，不能创建文件夹
         *      2.创建文件的路径必须存在，否则抛出异常
         *
         *   public boolean createNewFile() throws IOException
         *   这个方法时抛出了IOException，所以我们调用该方法，就必须处理这个异常，要么throws,要么try...catch
         */
        //File file = new File("D:\\personalDoc\\2019\\August\\ab.txt");
        //不存在的路径
        File file = new File("D:\\personalDoc\\2019\\August1\\ab.txt");
        try {
            boolean f1 = file.createNewFile();
            System.out.println(f1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo02(){
        /**
         *  boolean delete() 删除此抽象路径名表示的文件或目录。
         *  注意：
         *      delete方法是直接在硬盘删除文件/文件夹，不走回收站，删除要谨慎。
         */

        File file = new File("D:\\personalDoc\\2019\\August\\ab1.txt");
        boolean delete = file.delete();
        System.out.println(delete);
    }

    @Test
    public void demo03(){
        //

        /**
         *  boolean mkdir() 创建此抽象路径名指定的目录。
         *  注意：
         *      创建单级空文件夹
         *
         */
        File file = new File("D:\\personalDoc\\2019\\August\\a");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
    }

    @Test
    public void demo04(){
        /**
         *  boolean mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
         *  注意:
         *      既可以创建单级空文件夹，也可以创建多级空文件夹
         */
        //快捷方式加.var 就可以补全前面定义的名称
        File file = new File("D:\\personalDoc\\2019\\August\\ab\\a");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);

    }
}
