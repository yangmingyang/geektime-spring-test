package com.JDBC.concept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC控制事务：
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
 * 写一个银行转账的案例：
 */
public class Demo06JDBC_transaction {
    public static void main(String[] args) {
        PreparedStatement pst1=null;
        PreparedStatement pst2=null;
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            String sql1="update student set balance=? where id=?";
            String sql2="update student set balance=? where id=?";
            pst1 = conn.prepareStatement(sql1);
            pst2 = conn.prepareStatement(sql2);

            pst1.setInt(1,50);
            pst1.setDouble(2,2);

            pst2.setInt(1,150);
            pst2.setDouble(2,3);

            pst1.executeUpdate();
            //人为弄点错误，让事务回滚
            double i=3/0;
            pst2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn!=null){
                    //事务回滚
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JDBCUtils.close(conn,pst1,null);
            JDBCUtils.close(null,pst2,null);
        }


    }
}
