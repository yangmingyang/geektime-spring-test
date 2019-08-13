package com.JDBC.concept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  练习：
 *      定义一个方法，查询student表的数据将其封装为对象，然后装载集合，返回。
 */
public class Demo04JDBC {
    public static void main(String[] args) {
        Demo04JDBC demo04JDBC = new Demo04JDBC();
        List<Student> allStudent = demo04JDBC.getAllStudent();
        System.out.println(allStudent);
    }

    public List<Student> getAllStudent(){
        ResultSet resultSet = null;
        Statement stat = null;
        Connection conn = null;
        List<Student> studentList = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///english", "root", "root");
            stat = conn.createStatement();
            String sql="select * from student";
            resultSet = stat.executeQuery(sql);
            Student student=null;
            studentList = new ArrayList<Student>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                studentList.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }
}
