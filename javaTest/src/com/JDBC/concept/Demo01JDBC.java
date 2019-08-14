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
 *          next():游标向下移动一行。
 *          getXxx(参数)：获取数据
 *              Xxx:代表数据类型 如：int getInt() , String getString()
 *              参数：
 *                  1.int:代表列的编号，从1开始   如：getString(1)
 *                  2.String:代表列名称。 如： getDouble("balance")
 *
 *      5.PreparedStatement:执行sql的对象（重点说明，以后的增删改查都会使用这个PreparedStatement对象，而不使用Statement）
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
 *          注意：后期都会使用PreparedStatement来完成增删查改的所有操作
 *              1.可以防止sql注入
 *              2.效率更高
 *
 *  JDBC控制事务：
 *      1.事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。
 *      2.操作：
 *          1.开启事务
 *          2.提交事务
 *          3.回滚事务
 *      3.使用Connection对象来管理事务
 *          开启事务：setAutoCommit(boolean autoCommit):调用该方法设置参数为false，即开启事务。
 *              在执行sql之前开启事务
 *          提交事务：commit()
 *              当所有sql都执行完提交事务
 *          回滚事务：rollback()
 *              在catch中回滚事务
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
