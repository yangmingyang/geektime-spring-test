package com.mingYang.Recursion;

import java.io.File;

/**
 * 练习：
 *  递归打印多级目录,进行文件搜索
 * 需求：
 *   遍历某个文件夹，及文件夹的子文件夹
 *   其中我只要.docx结尾的文件
 *
 *   我们可以使用过滤器来实现
 *   在File类中有两个和ListFiles重载的方法，方法的参数传递的就是过滤器
 *      File[] listFiles(FileFilter filter) 返回抽象路径名数组
 *          public interface FileFilter 用于抽象路径名的过滤器。
 *              作用：用来过滤文件（File对象）
 *              抽象方法：用来过滤文件的方法
 *                  boolean accept(File pathname) 测试指定抽象路径名是否应该包含在某个路径名列表中。
 *                      参数：pathname - 要测试的抽象路径名
 *      File[] listFiles(FilenameFilter filter) 返回抽象路径名数组
 *          public interface FilenameFilter 实现此接口的类实例可用于过滤器文件名。
 *              作用：用于过滤文件名称
 *              抽象方法：用来过滤文件的方法
 *                   boolean accept(File dir, String name) 测试指定文件是否应该包含在某一文件列表中。
 *                   参数：
 *                      dir - 构造方法中传递的被遍历的目录
 *                      name - 使用ListFiles方法遍历目录，获取的每一个文件/文件夹的名称
 *
 *      注意：
 *          两个过滤器接口是没有实现类的，需要我们自己写实现类，重写过滤的方法accept，在方法中自己定义过滤的规则
 */
public class Demo06FileFilter {
    public static void main(String[] args) {
        //getAllFile(new File("D:\\personalDoc\\2019\\August"));
        getAllFile2(new File("D:\\personalDoc\\2019\\August"));
    }
    public static void getAllFile(File file){
        //File[] files = file.listFiles(new FileFilterImpl());
        //可以使用匿名内部类来实现这个接口,同时该接口只有一个抽象方法，所以可以使用lambda进行优化
        /*File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()){
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith(".docx");
            }
        });*/
        //使用lambda优化
        File[] files = file.listFiles(pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".docx"));
        for (File f : files){
            if (f.isDirectory()) {
                getAllFile(f);
            }else {
                if (f.getName().toLowerCase().endsWith(".docx")){
                    System.out.println(f);
                }
            }
        }
    }


    public static void getAllFile2(File file){
        /*File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.isDirectory() || name.toLowerCase().endsWith(".docx");
            }
        });*/
        //使用lambda优化代码
        File[] files = file.listFiles((dir, name) -> dir.isDirectory() || name.toLowerCase().endsWith(".docx"));
        for (File f : files){
            if (f.isDirectory()) {
                getAllFile(f);
            }else {
                if (f.getName().toLowerCase().endsWith(".docx")){
                    System.out.println(f);
                }
            }
        }
    }
}
