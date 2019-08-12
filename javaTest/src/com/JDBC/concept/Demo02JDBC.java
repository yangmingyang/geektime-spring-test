package com.JDBC.concept;

import org.junit.Test;

import java.sql.*;

/**
 *  练习：
 *      1.使用jdbc进行新增
 *
 */
public class Demo02JDBC {
    /**
     * 新增
     */
    @Test
    public void test(){
        Connection conn =null;
        Statement statement = null;
        try {
            //1.注册一下驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取驱动
            conn = DriverManager.getConnection("jdbc:mysql:///english", "root", "root");
            //3.定义sql
            //String sql="insert student value(null,'小洋',27)";
            //更新sql
            //String sql ="update student set age=28 where id=1";
            //删除sql
            String sql="delete from student where id=1";
            //4.获取statement执行对象
            statement = conn.createStatement();
            //5.执行sql
            int count = statement.executeUpdate(sql);
            if(count>0){
                System.out.println("添加成功"+count);
            }else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
