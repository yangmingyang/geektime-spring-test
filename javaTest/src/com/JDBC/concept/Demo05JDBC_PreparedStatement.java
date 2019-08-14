package com.JDBC.concept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 5.PreparedStatement:执行sql的对象（重点说明，以后的增删改查都会使用这个PreparedStatement对象，而不使用Statement）
 *          1.SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题。
 *              1.随便输入用户名，输入名：a' or 'a' = 'a
 *              2.sql: select * from user where username='fhghghjgh' and password = 'a' or 'a' = 'a'
 *          2.解决sql注入问题：使用PreparedStatement对象来解决
 *          3.预编译的SQL:参数使用？作为占位符。
 *          4步骤：
 *              1.导入驱动包 mysql-connector-java-5.1.37-bin.jar。
 *              2.注册驱动。
 *              3.获取数据库连接对象Connection
 *              4.定义sql
 *                  注意：sql的参数使用？作为占位符。 如：select * from user where username=？ and password =?;
 *              5.获取执行sql语句的对象 PreparedStatement Connection.preparedStatement(String sql)
 *              6.给？赋值：
 *                  方法：setXxx(参数1,参数2)
 *                      参数1：？的位置编号从1开始
 *                      参数2：？的值
 *              7.执行sql,接受返回结果
 *              8.处理结果
 *              9.释放资源
 *         注意：后期都会使用PreparedStatement来完成增删查改的所有操作
 *              1.可以防止sql注入
 *              2.效率更高
 */
public class Demo05JDBC_PreparedStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        Demo05JDBC_PreparedStatement obj = new Demo05JDBC_PreparedStatement();
        Boolean flag = obj.getUser(name, password);
        if (flag==true){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
    }

    public Boolean getUser(String name, String password){
        if (name==null || password==null){
            return false;
        }
        Connection conn=null;
        PreparedStatement pstm = null;
        ResultSet resultSet =null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="select * from student where name=? and password=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,name);
            pstm.setString(2,password);
            resultSet = pstm.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pstm,resultSet);
        }
        return false;
    }
}
