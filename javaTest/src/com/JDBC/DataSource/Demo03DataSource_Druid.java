package com.JDBC.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 *  Druid：数据库连接池技术实现技术，由阿里巴巴提供。
 *      步骤：
 *          1.导入jar包 druid-1.0.9.jar
 *          2.定义配置文件
 *              配置文件是properties形式
 *              是可以叫任意名称，可以放在任意目录下。c3p0放在src目录会自动被加载，这点有点不一样。
 *          3.加载配置文件 properties
 *          4.获取数据库连接池对象：通过工厂类来获取 DruidDataSourceFactory
 *          5.获取连接：getConnection
 */
public class Demo03DataSource_Druid {
    public static void main(String[] args) throws Exception {
        InputStream is = Demo03DataSource_Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        pro.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
