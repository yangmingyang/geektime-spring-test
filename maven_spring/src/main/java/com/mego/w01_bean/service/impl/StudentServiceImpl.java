package com.mego.w01_bean.service.impl;

import com.mego.w01_bean.service.StudentService;

import java.util.Date;

public class StudentServiceImpl implements StudentService {
    /**
     * 定义这三个变量的含义：就是体现spring是怎么处理不同的对象值
     */
    private Integer id;
    private String name;
    private Date birthDate;

    public StudentServiceImpl(Integer id,String name,Date birthDate){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    public void saveStudent() {
        System.out.println("保存学生信息：" + this.name + ":" + this.birthDate);
    }
}
