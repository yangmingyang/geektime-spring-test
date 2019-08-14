package com.JDBC.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *  1.测试连接池的最大数是否生效
 *  2.其他名称的c3p0配置名字
 */
public class Demo02C3p0_test {

    /**
     * 1.测试连接池的最大数是否生效
     */
    @Test
    public void test() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //现在配置文件默认是10个，所以10以内都没有问题，到11个的时候就会报错了
        for (int i=0;i<=11;i++){
            Connection conn = dataSource.getConnection();
            System.out.println(i+":"+conn.toString());
            //假如我们在第5个的时候，归还了，那么第11个还是可以创建的
            conn.close();
            /**
             * 输出的结果：第5和第6是相同的对象。
             * 0:com.mchange.v2.c3p0.impl.NewProxyConnection@6d763516 [wrapping: com.mysql.jdbc.JDBC4Connection@52bf72b5]
             * 1:com.mchange.v2.c3p0.impl.NewProxyConnection@6c64cb25 [wrapping: com.mysql.jdbc.JDBC4Connection@52bf72b5]
             * 2:com.mchange.v2.c3p0.impl.NewProxyConnection@222545dc [wrapping: com.mysql.jdbc.JDBC4Connection@52bf72b5]
             * 3:com.mchange.v2.c3p0.impl.NewProxyConnection@16293aa2 [wrapping: com.mysql.jdbc.JDBC4Connection@5158b42f]
             * 4:com.mchange.v2.c3p0.impl.NewProxyConnection@72d1ad2e [wrapping: com.mysql.jdbc.JDBC4Connection@52bf72b5]
             * 5:com.mchange.v2.c3p0.impl.NewProxyConnection@399f45b1 [wrapping: com.mysql.jdbc.JDBC4Connection@52bf72b5]
             * 6:com.mchange.v2.c3p0.impl.NewProxyConnection@478190fc [wrapping: com.mysql.jdbc.JDBC4Connection@52bf72b5]
             * 7:com.mchange.v2.c3p0.impl.NewProxyConnection@3a93b025 [wrapping: com.mysql.jdbc.JDBC4Connection@5158b42f]
             * 8:com.mchange.v2.c3p0.impl.NewProxyConnection@7e07db1f [wrapping: com.mysql.jdbc.JDBC4Connection@5158b42f]
             * 9:com.mchange.v2.c3p0.impl.NewProxyConnection@36bc55de [wrapping: com.mysql.jdbc.JDBC4Connection@5158b42f]
             * 10:com.mchange.v2.c3p0.impl.NewProxyConnection@16d04d3d [wrapping: com.mysql.jdbc.JDBC4Connection@5158b42f]
             * 11:com.mchange.v2.c3p0.impl.NewProxyConnection@1d2adfbe [wrapping: com.mysql.jdbc.JDBC4Connection@5158b42f]
             */
        }
    }

    /**
     * 2.其他名称的c3p0配置名字
     */
    @Test
    public void test2() throws SQLException {
        //通过传入不同的配置名称，可以创建不同的数据库连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource("otherc3p0");
        for (int i=0;i<=10;i++) {
            Connection conn = dataSource.getConnection();
            System.out.println(i + ":" + conn.toString());
        }
    }

}
