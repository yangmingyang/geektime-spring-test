package com.grammar2.G07_innerClass;

public class Demo011_body {

    //成员内部类
    public class heart{
        public void beat(){
            System.out.println("心脏跳动");
            System.out.println("我叫："+name);//正确写法
        }
    }

    //外部类的成员变量
    private String name;

    //外部类的方法
    public void methedBody(){
        System.out.println("外部类的方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
