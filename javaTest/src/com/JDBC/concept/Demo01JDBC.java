package com.JDBC.concept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *  JDBC:
 *      概念：Java DataBase Connectivity Java数据库连接，Java语言操作数据库。
 *      JDBC本质：其实是官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供
 *                 数据库驱动jar包。我们可以使用这套接口（JDBC）编程，真正执行的代码时驱动jar包中的实现类。
 *
 *  快速入门：
 *      步骤：
 *          1.导入驱动jar包 mysql-connector-java-5.1.37-bin.jar。
 *              a.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下。
 *              b.右键-->Add As Library
 *          2.注册驱动。
 *          3.获取驱动。
 *          4.定义sql.
 *          5.获取执行sql语句的对象 Statement.
 *          6.执行sql,接受返回结果。
 *          7.处理结果。
 *          8.释放资源。
 *
 *  详解各个对象：
 *      1.DriverManager:驱动管理对象
 *          功能：
 *              a.注册驱动：告诉程序该使用哪一个数据库驱动jar.
 *              static void registerDriver(Driver driver): 注册与给定的驱动程序 DriverManager.
 *              写代码使用：Class.forName("com.mysql.jdbc.Driver")
 *              通过查看源代码发现：在com.mysql.jdbc.Driver类中存在静态代码块，加载文件的时候就会自动执行。
 *              static {
 *                  try {
 *                      java.sql.DriverManager.registerDriver(new Driver());
 *                  } catch (SQLException E) {
 *                      throw new RuntimeException("Can't register driver!");
 *                  }
 *              }
 *              注意：mysql5之后的驱动jar包可以省略注册驱动的步骤。原因是jar包下的META-INF/services/java.sql.Driver文件中已经加载"com.mysql.jdbc.Driver"
 *              b.获取数据库连接。
 *                  方法：static Connection getConnection(String url,String user, String password)
 *                  参数：
 *                      url:指定连接的路径
 *                          语法：jdbc:mysql://ip地址（域名）:端口号/数据库名称
 *                          例子：jdbc:mysql://localhost:3306/english
 *                          细节:如果连接的是本机mysql服务器，并且mysql服务器默认端口是3306，
 *                               则url可以简写为：jdbc:mysql:///english
 *                      user:用户名
 *                      password:密码
 *
 *      2.Connection:数据库连接对象
 *          功能：
 *              1.获取执行sql的对象
 *                  Statement createStatement()
 *                  PreparedStatement prepareStatement(String sql)
 *              2.管理事务：
 *                  开启事务：setAutoCommit(boolean autoCommit):调用该方法设置参数为false，即开启事务。
 *                  提交事务：commit()
 *                  回滚事务：rollback()
 *
 *      3.Statement:执行sql的对象
 *          1.执行sql
 *              1.boolean execute(String sql): 可以执行任意的sql （了解即可）
 *              2.int executeUpdate(String sql)：执行DML(insert、update、delete)语句、DDL(create、alter、drop)语句。
 *                  返回值:影响的行数，可以通过这个影响的行数判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
 *              3.ResultSet executeQuery(String sql)：执行DQL(select)语句
 *
 *      4.ResultSet:结果集对象
 *      5.PreparedStatement:执行sql的对象
 */
public class Demo01JDBC {
    public static void main(String[] args) throws Exception {
        // 2.注册驱动。
        //Class.forName("com.mysql.jdbc.Driver");
        //3.获取驱动。
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/english", "root", "root");
        //4.定义sql.
        String sql="UPDATE agency SET agencyAddress='广州白云2' WHERE id=7";
        //5.获取执行sql语句的对象 Statement.
        Statement statement = connection.createStatement();
        //6.执行sql,接受返回结果。
        int i = statement.executeUpdate(sql);
        //7.处理结果。
        System.out.println(i);
        //8.释放资源。
        statement.close();
        connection.close();
    }
}
