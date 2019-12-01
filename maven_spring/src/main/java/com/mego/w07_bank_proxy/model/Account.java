package com.mego.w07_bank_proxy.model;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 余额
     */
    private Double balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    /**
     * 空的构造参数不要顺便写其他东西，比如就直接输出一句打印话就完事
     */



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
