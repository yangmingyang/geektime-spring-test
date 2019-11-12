package com.mego.w02_anno.dao.impl;

import com.mego.w02_anno.dao.IAStudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDao2")
public class IAStudentDaoImpl2 implements IAStudentDao {
    public void save() {
        System.out.println("持久化保存学生数据2222");
    }
}
