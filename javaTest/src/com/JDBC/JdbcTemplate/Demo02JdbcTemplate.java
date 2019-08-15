package com.JDBC.JdbcTemplate;

import com.JDBC.DataSource.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *  需求：
 *      1.修改id为2数据的 age 为35
 *      2.添加一条记录
 *      3.删除刚才添加的记录
 *      4.查询id为2的记录，将其封装为Map集合
 *      5.查询所有记录，将其封装为List集合
 *      6.查询所有记录，将其封装为Student对象的List集合
 *      7.查询总记录数
 */
public class Demo02JdbcTemplate {

    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    /**
     * 修改id为2数据的 age 为35
     */
    @Test
    public void demo01(){
        String sql="update student set age=35 where id=?";
        int count = template.update(sql, 2);
        System.out.println(count);
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void demo02(){
        String sql="insert into student (id,name,age,balance)value(?,?,?,?)";
        int count = template.update(sql, 4, "hb", 18, 2000);
        System.out.println(count);
    }

    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void demo03(){
        String sql="delete from student where id=?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }

    /**
     * 4.查询id为2的记录，将其封装为Map集合
     */
    @Test
    public void demo04(){
        String sql="select * from student where id =?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql, 2);
        System.out.println(stringObjectMap);
    }

    /**
     * 5.查询所有记录，将其封装为List集合
     */
    @Test
    public void demo05(){
        String sql="select * from student";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
    }

    /**
     * 6.查询所有记录，将其封装为Student对象的List集合
     *  自己去实现该接口
     */
    @Test
    public void demo06(){
        String sql="select * from student";
        List<Student> lists = template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet res, int i) throws SQLException {
                Student student = new Student();
                int id = res.getInt("id");
                String name = res.getString("name");
                int age = res.getInt("age");
                double balance = res.getDouble("balance");
                student.setId(id);
                student.setNaem(name);
                student.setAge(age);
                student.setBalance(balance);
                return student;
            }
        });
        for (Student student : lists){
            System.out.println(student);
        }
    }

    /**
     *  6.查询所有记录，将其封装为Student对象的List集合
     *  调用别人的实现类
     */
    @Test
    public void demo06_2() {
        String sql = "select * from student";
        List<Student> lists = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        for (Student student : lists){
            System.out.println(student);
        }
    }

    /**
     * 7.查询总记录数
     */
    @Test
    public void demo07() {
        String sql="select count(id) from student";
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println(aLong);
    }
}
