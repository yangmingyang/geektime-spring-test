package com.mego.w03_case.dao.impl;

import com.mego.w03_case.dao.HobbyWordDao;
import com.mego.w03_case.domain.Hobby_word;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public class HobbyWordDaoImpl implements HobbyWordDao {
    @Autowired
    private QueryRunner queryRunner;

    public List<Hobby_word> findAllWord() {
        try {
            return queryRunner.query("select * from hobby_word",new BeanListHandler<Hobby_word>(Hobby_word.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Hobby_word getHobbyWord() {
        try {
            List<Hobby_word> list = queryRunner.query("select * from hobby_word where id=?", new BeanListHandler<Hobby_word>(Hobby_word.class), 10);
            if (list != null) {
                return list.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
