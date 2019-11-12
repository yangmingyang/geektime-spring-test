package com.mego.w02_anno.dao.impl;

import com.mego.w02_anno.dao.IAStudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class IAStudentDaoImpl implements IAStudentDao {
    public void save() {
        System.out.println("持久化保存学生数据1111");
    }
}
