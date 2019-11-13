package com.mego.w02_anno.service.impl;

import com.mego.w02_anno.dao.IAStudentDao;
import com.mego.w02_anno.dao.impl.IAStudentDaoImpl;
import com.mego.w02_anno.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("studentService2")
//@Scope("prototype")
public class StudentServiceImpl2 implements StudentService {
    @Autowired
    @Qualifier("studentDao2")
    private IAStudentDao studentDao;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法");
    }

    public void saveStudent() {
        studentDao.save();
    }
}
