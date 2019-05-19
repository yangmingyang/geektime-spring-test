package com.my.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 该demo是练习如何配置单数据源
	 * 学习的思路：
	 * 1.碰到什么知识点自己不知道的，查找官网，从官网下手
	 * 2.中途实践的过程中，碰到什么坑，记录碰坑的过程
	 * 3.总结知识点
	 *
	 * 思考：
	 * 1.H2数据库是什么来的，什么场景下会使用这种数据库？
	 * 答：在该demo下使用H2数据库，是需要先安装好H2的数据库，才能使用JDBC去调用的。官网是：https://www.h2database.com/html/main.html
	 *
	 * 2.JDBC使用的是什么连接池，各个连接池的优劣性？
	 *
	 * 3.JDBC是如何工作的，如何连接数据库，创建对象？
	 *
	 * 4.为什么引入@Slf4j，在IDEA中就可以直接使用log.info直接打印
	 * 答：这个需要在IDEA中加一个插件，到底是一个什么插件呢？添加lombok的maven依赖到pom.xml，同时还要在IDEA中添加这个插件。
	 * 使用lombok之后，省去了许多没必要的get，set，toString，equals，hashCode代码，简化了代码编写，减少了代码量。
	 * 发现一个问题，IDEA201901版安装该插件有问题。解决方案：https://blog.csdn.net/u011442726/article/details/90314717
	 *
	 * 5.了解一下springboot中的各个组件的作用？什么是组件，类似这个demo在pom.xml中就引入了如下组件：actuator、jdbc、web、h2database、lombok，这种组件的作用是什么？
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("我来了");
		showConnection();
		showData();
	}

	private void showConnection() throws SQLException {
		//System.out.println("我来了"+dataSource.toString());
		log.info(dataSource.toString());
		Connection conn = dataSource.getConnection();
		//System.out.println(conn.toString());
		log.info(conn.toString());
		conn.close();
	}

	private void showData(){
		jdbcTemplate.queryForList("select * from FOO").forEach(
				row->System.out.println(row.toString())
		);
	}
}
