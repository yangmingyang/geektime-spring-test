package com.JDBC.concept;

import java.sql.*;

/**
 *  4.ResultSet:结果集对象
 *      next():游标向下移动一行，判断当前行是否是最后一行末尾（是否有数据），如果是，则返回false,如果不是则返回true.
 *      getXxx(参数)：获取数据
 *          Xxx:代表数据类型 如：int getInt() , String getString()
 *              参数：
 *                  1.int:代表列的编号，从1开始   如：getString(1)
 *                  2.String:代表列名称。 如： getDouble("balance")
 *      使用步骤：
 *          1.游标向下移动一行
 *          2.判断是否有数据
 *          3.获取数据
 */
public class Demo03JDBC {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //先注册
            Class.forName("com.mysql.jdbc.Driver");
            //获取驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/english", "root", "root");
            //sql
            String sql="select * from student";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            //循环判读游标是否是最后一行末尾。
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id+"="+name+"="+age);
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
            if (statement!=null){
                try {
                    statement.close();
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
    }
}
