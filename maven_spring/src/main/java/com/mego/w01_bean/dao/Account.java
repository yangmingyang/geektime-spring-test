package com.mego.w01_bean.dao;

public class Account {
    private Integer id;
    private String name;
    Account(){
        System.out.println("创建Account对象了");
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
}
