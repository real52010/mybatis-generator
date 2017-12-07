package org.zt.ccty.springboot_mybatis_demo.config;

import org.apache.log4j.Logger;

import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.zt.ccty.springboot_mybatis_demo.SpringUtils;

import javax.annotation.Resource;

import javax.sql.DataSource;

/**
 *
 * @author 周涛
 *
 */
@Configuration
@EnableTransactionManagement
public class DataSourceTransactionManager extends DataSourceTransactionManagerAutoConfiguration {
	private static Logger log = Logger.getLogger(DataSourceTransactionManager.class);

	/**
	 * 
	 * MyBatis自动参与到spring事务管理中，无需额外配置，只要org.mybatis.spring.SqlSessionFactoryBean引用的数据源与DataSourceTransactionManager引用的数据源�?致即可，否则事务管理会不起作用�??
	 * 
	 * @return
	 */
	@Resource(name = "writeDataSource")
	private DataSource dataSource;

	@Bean(name = "transactionManager")
	public org.springframework.jdbc.datasource.DataSourceTransactionManager transactionManagers() {
		log.info("-------------------- transactionManager init ---------------------");

		// return new
		// org.springframework.jdbc.datasource.DataSourceTransactionManager(dataSource);
		MyDataSourceTransactionManager dstm = new MyDataSourceTransactionManager(
				(DataSource) SpringUtils.getBean("roundRobinDataSouceProxy"));
		return dstm;
	}
}
