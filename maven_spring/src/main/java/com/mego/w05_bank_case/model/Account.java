package com.mego.w05_bank_case.model;

public class Account {
    private Integer id;
    private String name;
    private Double balance;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
