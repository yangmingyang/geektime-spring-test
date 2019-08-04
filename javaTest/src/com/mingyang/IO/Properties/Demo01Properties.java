package com.mingyang.IO.Properties;

import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 *  java.util.Properties集合 extends Hashtable<K,V> implements Map<K.V>
 *  Properties 类表示了一个持久的属性集。 Properties 可保存在流中或从流中加载。
 *
 *  Properties 集合是一个唯一和IO流相结合的集合。
 *      可以使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储。
 *      可以使用Properties集合中的方法load,把硬盘中保存的文件（键值对），读取到集合中使用。
 *
 *  属性列表中每个键及对应值都是一个字符串。
 *      Properties集合是一个双列集合，key和value默认都是字符串
 *
 */
public class Demo01Properties {

    /**
     *  使用Properties集合存储数据，遍历取出Properties集合中数据
     *  Properties集合是一个双列集合，key和value默认都是字符串
     *  Properties集合有一些操作字符串的特有方法
     *      Object setProperty(String key, String value) 调用Hashtable 的方法put.
     *      String getProperties(String key) 通过key找到value值，此方法相当于Map集合中的get（key）方法
     *      Set<String>stringPropertyName() 返回此属性列表中的键集，其中该键及其对应值是字符串，此方法相当于Map集合中的keySet方法
     */
    @Test
    public void demo1(){
        Properties pt = new Properties();
        //怎么设置属性值
        pt.setProperty("赵丽颖","170");
        pt.setProperty("范冰冰","160");
        pt.setProperty("张娜拉","162");

        //怎么单独读取数据值
        String property = pt.getProperty("赵丽颖");
        System.out.println(property);

        //怎么读取数据
        Set<String> stringSet = pt.stringPropertyNames();
        for (String name : stringSet){
            System.out.println(name + pt.getProperty(name));
        }
    }

    /**
     *  可以使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储。
     *  void store(OutputStream out, String comments)
     *  void store(Writer writer, String comments)
     *  参数：
     *      OutputStream out:字节输出流，不能写入中文
     *      Writer writer:字符输出流，可以写中文
     *      String comments: 注释，用来解释说明保存的文件是做什么用的
     *          不能使用中文，会产生乱码，默认是Unicode编码
     *          一般使用""空字符串
     *
     *  使用步骤：
     *      1.创建Properties集合对象，添加数据
     *      2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
     *      3.使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储
     *      4.释放资源
     */
    @Test
    public void demo2() throws IOException {
        //1.创建Properties集合对象，添加数据
        //注意：这里的键值对如果是中文，保存的时候就会乱码
        Properties pt = new Properties();
        pt.setProperty("url","http://www.baidu.com");
        pt.setProperty("url2","http://www.tengxun.com");
        pt.setProperty("url3","http://www.xunlei.com");

        // 2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        FileOutputStream fos = new FileOutputStream("D:\\personalDoc\\2019\\August\\properties.txt");

        //3.使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储
        pt.store(fos,"abc");
        //4.释放资源
        fos.close();
    }

    /**
     * 使用字符流来进行持久化
     * @throws IOException
     */
    @Test
    public void demo3() throws IOException {
        //1.创建Properties集合对象，添加数据
        Properties pt = new Properties();
        pt.setProperty("url","http://www.baidu.com");
        pt.setProperty("url2","http://www.tengxun.com");
        pt.setProperty("url3","http://www.xunlei.com");

        // 2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        FileWriter fileWriter = new FileWriter("D:\\personalDoc\\2019\\August\\properties.txt");

        //3.使用Properties集合中的方法store,把集合中的临时数据，持久化写入到硬盘中存储
        pt.store(fileWriter,"data");
        //4.释放资源
        fileWriter.close();
    }

    /**
     *  可以使用Properties集合中的方法load,把硬盘中保存的文件（键值对），读取到集合中使用。
     *  void load(InputStream inStream)
     *  void load(Reader reader)
     *  参数：
     *      InputStream inStream : 字节输入流，不能读取含有中文的键值对
     *      Reader reader: 字符输入流，能读取含有中文的键值对
     *  使用步骤：
     *      1.创建Properties集合对象
     *      2.使用Properties集合对象中的方法load读取保存键值对的文件
     *      3.遍历Properties集合
     *  注意：
     *      1.存储键值对的文件中，键与值默认的连接符号可以使用=，空格（其他符号）。
     *      2.存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取。
     *      3.存储键值对的文件中，键和值默认都是字符串，不用再加引号。
     *
     */
    @Test
    public void demoLoad() throws IOException {
        Properties pt = new Properties();
        //第一种方式通过加载字节流的方式
        //pt.load(new FileInputStream("D:\\personalDoc\\2019\\August\\properties.txt"));
        //第二种方式：通过加装字符流分方式,一般情况下我们都会使用字符流来加装，防止中文乱码
        pt.load(new FileReader("D:\\personalDoc\\2019\\August\\properties.txt"));
        Set<String> strings = pt.stringPropertyNames();
        for (String name : strings){
            System.out.println(name + "="+pt.getProperty(name));
        }
    }
}
