package com.mego.w03_case.domain;

import java.io.Serializable;

public class Hobby_word implements Serializable {
    private Integer id;
    private String name;
    private String meaning;

    @Override
    public String toString() {
        return "Hobby_word{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meaning='" + meaning + '\'' +
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

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
