package com.mego.w02_anno.service.impl;

import com.mego.w02_anno.dao.IAStudentDao;
import com.mego.w02_anno.dao.impl.IAStudentDaoImpl;
import com.mego.w02_anno.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentService2")
public class StudentServiceImpl2 implements StudentService {
    @Autowired
    private IAStudentDao studentDao2;

    public void saveStudent() {
        studentDao2.save();
    }
}
