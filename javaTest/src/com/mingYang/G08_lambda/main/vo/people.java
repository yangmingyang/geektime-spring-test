package com.mingYang.G08_lambda.main.vo;

public class people {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "people{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
