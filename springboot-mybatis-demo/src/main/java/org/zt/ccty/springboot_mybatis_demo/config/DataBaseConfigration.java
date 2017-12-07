package org.zt.ccty.springboot_mybatis_demo.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
@Configuration
public class DataBaseConfigration {

	private Logger log = LoggerFactory.getLogger(DataBaseConfigration.class);

	@Value("${spring.datasource.type}")
	private Class<? extends DataSource> dataSourceType;

	@Bean(name = "writeDataSource", destroyMethod = "close", initMethod = "init")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource writeDataSource() {
		log.info("-------------------- writeDataSource init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	@Bean(name = "readDataSource1")
	@ConfigurationProperties(prefix = "spring.slave")
	public DataSource readDataSourceOne() {
		log.info("-------------------- readDataSourceOne init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	@Bean(name = "readDataSource2")
	@ConfigurationProperties(prefix = "spring.read2")
	public DataSource readDataSourceTwo() {
		log.info("-------------------- readDataSourceTwo init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	@Bean(name = "readDataSources")
	public List<DataSource> readDataSources() {
		List<DataSource> dataSources = new ArrayList<>();
		dataSources.add(readDataSourceOne());
		dataSources.add(readDataSourceTwo());
		return dataSources;
	}
}
