package com.JDBC.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *  定义一个Druid工具类
 */
public class DruidUtils {
    private static DataSource ds;
    static {
        try {
            Properties properties = new Properties();
            properties.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    public static void close(Connection conn, Statement stm){
        //这样去重写方法
        close(conn,stm,null);
    }
    /**
     * 释放资源
     */
    public static void close(Connection conn, Statement stm, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stm!=null){
            try {
                stm.close();
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
