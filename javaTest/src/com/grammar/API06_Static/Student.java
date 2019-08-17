package com.grammar.API06_Static;

public class Student {
    private int id;
    static String room;
    private String name;
    private int age;
    //计数器
    static int countId;

    public Student() {
        this.id = countId++;
    }

    public Student( String name, int age) {
        this.name = name;
        this.age = age;
        this.id = countId++;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
