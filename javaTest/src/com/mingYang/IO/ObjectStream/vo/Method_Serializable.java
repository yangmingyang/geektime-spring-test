package com.mingYang.IO.ObjectStream.vo;

import java.io.Serializable;

/**
 *  序列化和反序列化的时候，会抛出NotSerializableException没有序列化异常
 *  类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
 *
 *  serializable接口也叫标记型接口
 *      要进行序列化和反序列化的类必须实现Serializable接口，就会给类添加一个标记。
 *      当我们进行序列化和反序列化的时候，就会检测类上是否有这个标记
 *          有：就可以序列化和反序列化。
 *          没有：就会抛出NotSerializableException异常
 *
 *  static关键字：静态关键字
 *      静态优先于非静态加载到内存中（静态优先于对象进入内存中）
 *      被static修饰的成员变量不能被序列化的，序列化的都是对象
 *
 *  transient关键字：瞬态关键字
 *      被transient修饰成员变量，不能被序列化
 *
 */
public class Method_Serializable implements Serializable {
    //使用该serialVersionUID能够确保每次序列化的时候都是这个对象，不声明的话，每次修改该文件，class文件中serialVersionUID都是在变化的。
    private static final long serialVersionUID=1L;

    private int id;
    //被transient修饰成员变量，不能被序列化
    //private transient int id;
    private String name;

    public Method_Serializable() {
    }

    public Method_Serializable(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Method_Serializable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
