package com.mingYang.IO.ObjectStream;

import com.mingYang.IO.ObjectStream.vo.Method_Serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  练习：序列化集合
 *      当我们想在文件中保存多个对象的时候
 *      可以吧多个集合存储到一个集合中
 *      对集合进行序列化和反序列
 *
 *  分析：
 *      1.定义一个存储method对象的ArrayList集合。
 *      2.往ArrayList集合中存储method对象。
 *      3.创建一个序列化流ObjectOutputStream对象。
 *      4.是引用ObjectOutputStream对象中的方法writeObject，对集合进行序列化。
 *      5.创建一个反序列化ObjectInputStream对象。
 *      6.使用ObjectInputStream对象中的readObject方法读取文件中保存的集合
 *      7.把Object类型的集合转换为ArrayList类型。
 *      8.遍历ArrayList集合。
 *      9.释放资源
 *
 */
public class Demo03ObjectStream_test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义一个存储method对象的ArrayList集合。
        ArrayList<Method_Serializable> methods = new ArrayList<>();
        //2.往ArrayList集合中存储method对象。
        methods.add(new Method_Serializable(1,"小米"));
        methods.add(new Method_Serializable(2,"小红"));
        methods.add(new Method_Serializable(3,"小蓝"));
        //把集合中的对象存储到文件中，进行序列化操作
        // 3.创建一个序列化流ObjectOutputStream对象。
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\personalDoc\\2019\\August\\list.txt"));
        //4.是引用ObjectOutputStream对象中的方法writeObject，对集合进行序列化。
        oos.writeObject(methods);

        //5.创建一个反序列化ObjectInputStream对象。
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\personalDoc\\2019\\August\\list.txt"));
        //6.使用ObjectInputStream对象中的readObject方法读取文件中保存的集合
        //7.把Object类型的集合转换为ArrayList类型。
        List<Method_Serializable> o = (List<Method_Serializable>) ois.readObject();

        //8.遍历ArrayList集合。
        for (Method_Serializable m : o){
            System.out.println(m);
        }

        //9.释放资源
        ois.close();
        oos.close();

    }
}
