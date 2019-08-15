package com.JDBC.JdbcTemplate;

public class Student {
    private Integer id;
    private String naem;
    private Integer age;
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", naem='" + naem + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
