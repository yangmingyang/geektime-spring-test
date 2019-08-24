package com.mingYang.G10_Reflect.domain;

public class Person {
    private Integer id;
    private String name;
    public String a;
    protected String b;
    String c;
    private String d;

    public Person() {
    }

    /**
     *  把构造方法改成私有的
     */
    private Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void eat(){
        System.out.println("eat....");
    }

    public void eat(String food){
        System.out.println("eat..."+food);
    }

    private void eat(String name,String food){
        System.out.println(name+"==="+food);
    }
}
