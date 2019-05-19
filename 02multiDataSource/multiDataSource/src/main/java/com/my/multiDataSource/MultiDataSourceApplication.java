package com.my.multiDataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * 实践碰到的问题：
 * 1.在spring官网初始化代码的时候，觉得java 11 版本新奇，就选了，但是到自己的环境来的时候，才发现本地的java版本才1.8，根本跑不起来
 * 解决方法：https://mp.csdn.net/postlist
 *
 *
 */
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class})
@Slf4j
public class MultiDataSourceApplication {

	public static void main(String[] args) {
		log.info("我来了");
		SpringApplication.run(MultiDataSourceApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("foo.datasource")
	public DataSourceProperties footDataSourceProperties(){
		log.info("我来初始化一个对象foo：DataSourceProperties" );
		return  new DataSourceProperties();
	}

	@Bean
	public DataSource fooDataSource(){
		DataSourceProperties dataSourceProperties = footDataSourceProperties();
		log.info("我来初始化调用1：DataSourceProperties" );
		log.info("====foo datasource:{}"+dataSourceProperties.getUrl());
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Resource
	public PlatformTransactionManager fooTxManager(DataSource fooDataSource){
		return new DataSourceTransactionManager(fooDataSource);
	}

	@Bean
	@ConfigurationProperties("bar.datasource")
	public DataSourceProperties barDataSourceProperties(){
		return new DataSourceProperties();
	}

	@Bean
	public DataSource barDataSource(){
		DataSourceProperties dataSourceProperties = barDataSourceProperties();
		log.info("我来初始化调用bar：DataSourceProperties" );
		log.info("====bar datasource:{}"+dataSourceProperties.getUrl());
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Resource
	public PlatformTransactionManager barTxManager(DataSource barDataSource){
		return new DataSourceTransactionManager(barDataSource);
	}
}
