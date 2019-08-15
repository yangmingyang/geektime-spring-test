package com.JDBC.JdbcTemplate;

import com.JDBC.DataSource.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *  Spring JDBC
 *  Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发。
 *  步骤：
 *      1.导入5个jar包：commons-logging-1.2.jar spring-beans-5.0.0.RELEASE.jar spring-core-5.0.0.RELEASE.jar
 *       spring-jdbc-5.0.0.RELEASE.jar spring-tx-5.0.0.RELEASE.jar
 *      2.创建JdbcTemplate对象。依赖于数据源DataSource.
 *          JdbcTemplate template = new JdbcTemplate(ds);
 *      3.调用JdbcTemplate的方法来完成CRUD的操作。
 *          update():执行DML语句。增删改查语句。
 *
 *          queryForMap():查询结果将结果封装为map集合,将列名作为key,将值作为value,将这条记录封装为一个map集合。
 *              注意：这个方法查询的结果集长度只能是1.
 *
 *          queryForList():c查询结果将结果封装为list集合。
 *              注意：将每一条记录封装作为一个Map集合，再将Map集合装载到List集合中
 *
 *          query():查询结果，将结果封装为JavaBean对象。
 *              query的参数：RowMapper
 *                  一般我们使用BeanPropertyRowMapper实现类。可以完成数据导JavaBean的自动封装。
 *                  new BeanPropertyRowMapper<类型>（类型.class）
 *
 *          queryForObject():查询结果，将结果封装为对象。
 *
 *
 */
public class Demo01JdbcTemplate {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql="update student set age=30 where id=?";
        int count = template.update(sql, 2);
        System.out.println(count);
    }
}
