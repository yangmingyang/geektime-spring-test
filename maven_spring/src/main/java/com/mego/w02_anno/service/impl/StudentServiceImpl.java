package com.mego.w02_anno.service.impl;

import com.mego.w02_anno.service.StudentService;
import org.springframework.stereotype.Repository;

@Repository("studentService1")
public class StudentServiceImpl implements StudentService {
    public void saveStudent() {
        System.out.println("保存一下w02_anno学生信息");
    }
}
