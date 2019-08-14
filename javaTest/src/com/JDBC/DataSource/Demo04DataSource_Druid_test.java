package com.JDBC.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试一下DruidUtils工具类
 */
public class Demo04DataSource_Druid_test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm =null;
        ResultSet resultSet = null;
        try {
            conn = DruidUtils.getConnection();
            String sql ="select * from student";
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id+"+"+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(conn,pstm,resultSet);
        }

    }
}
