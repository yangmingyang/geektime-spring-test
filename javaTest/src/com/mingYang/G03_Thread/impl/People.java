package com.mingYang.G03_Thread.impl;

public class People {

    private int id;
    private String name;

    public void run(){
        for (int i=0;i<20;i++){
            System.out.println(getName()+"-->"+i);
        }
    }

    public People(int id, String name) {
        this.id = id;
        this.name = name;
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
