package com.real.demo.common.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import lombok.extern.slf4j.Slf4j;

/**
 * 配置druid数据源
 */
@Slf4j
@Configuration
@MapperScan(basePackages = { "com.real.demo.**.dao" }, sqlSessionFactoryRef = "baseSqlSessionFactory")
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("allow", "127.0.0.1");
        registrationBean.addInitParameter("deny", "192.168.31.234");
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "123456");
        registrationBean.addInitParameter("resetEnable", "false");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");

        return registrationBean;

    }

    @Bean(name = "baseDataSource")
    public DataSource druidDataSource(@Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.driverClassName}") String driver,
                                      @Value("${spring.datasource.username}") String userName,
                                      @Value("${spring.datasource.password}") String password,
                                      @Value("${spring.datasource.maxActive}") int maxActive,
                                      @Value("${spring.datasource.filters}") String filters,
                                      @Value("${spring.datasource.initialSize}")
                                              int initialSize,
                                      @Value("${spring.datasource.minIdle}")
                                              int minIdle,
                                      @Value("${spring.datasource.maxWait}")
                                              int maxWait,
                                      @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
                                              int timeBetweenEvictionRunsMillis,
                                      @Value("${spring.datasource.minEvictableIdleTimeMillis}")
                                              int minEvictableIdleTimeMillis,
                                      @Value("${spring.datasource.validationQuery}")
                                              String validationQuery,
                                      @Value("${spring.datasource.testWhileIdle}")
                                              boolean testWhileIdle,
                                      @Value("${spring.datasource.testOnBorrow}")
                                              boolean testOnBorrow,
                                      @Value("${spring.datasource.testOnReturn}")
                                              boolean testOnReturn,
                                      @Value("${spring.datasource.poolPreparedStatements}")
                                              boolean poolPreparedStatements,
                                      @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
                                              int maxPoolPreparedStatementPerConnectionSize,
                                      @Value("${spring.datasource.connectionProperties}")
                                              String connectionProperties,
                                      @Value("${spring.datasource.useGlobalDataSourceStat}")
                                              boolean useGlobalDataSourceStat,
                                      @Qualifier("log-filter") Slf4jLogFilter slf4jLogFilter

    ) {
        DruidDataSource dataSource = new DruidDataSource();
        /*数据源主要配置*/
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        /*数据源补充配置*/
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setConnectionProperties(connectionProperties);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);

        try {
        	
            dataSource.setFilters(filters);
            dataSource.getProxyFilters().add(slf4jLogFilter);
            log.info("Druid数据源初始化设置成功......");
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Druid数据源filters设置失败......");
        }
        return dataSource;
    }

    @Bean(name = "log-filter")
    public Slf4jLogFilter setSlf4jLogFilter() {
        Slf4jLogFilter filter = new Slf4jLogFilter();
        filter.setDataSourceLogEnabled(false);
        filter.setConnectionLogEnabled(false);
        filter.setConnectionLogErrorEnabled(true);
        filter.setStatementLogEnabled(false);
        filter.setStatementLogErrorEnabled(true);
        filter.setResultSetLogEnabled(false);
        filter.setResultSetLogErrorEnabled(true);
        filter.setConnectionConnectBeforeLogEnabled(false);
        filter.setConnectionConnectAfterLogEnabled(false);
        filter.setConnectionCommitAfterLogEnabled(false);
        filter.setConnectionRollbackAfterLogEnabled(true);
        filter.setConnectionCloseAfterLogEnabled(false);
        filter.setStatementCreateAfterLogEnabled(false);
        filter.setStatementPrepareAfterLogEnabled(false);
        filter.setStatementPrepareCallAfterLogEnabled(false);
        filter.setStatementExecuteAfterLogEnabled(false);
        filter.setStatementExecuteQueryAfterLogEnabled(false);
        filter.setStatementExecuteUpdateAfterLogEnabled(false);
        filter.setStatementExecuteBatchAfterLogEnabled(false);
        filter.setStatementCloseAfterLogEnabled(false);
        filter.setStatementParameterSetLogEnabled(false);
        filter.setResultSetNextAfterLogEnabled(false);
        filter.setResultSetOpenAfterLogEnabled(false);
        filter.setResultSetCloseAfterLogEnabled(false);
        filter.setStatementExecutableSqlLogEnable(true);
        
        return filter;

    }
    @Bean
    public StatFilter statFilter () {

        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(3000);
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        return statFilter;
    }

    /**
     * sql防火墙过滤器配置
     * @param wallConfig
     * @return
     */
    @Bean
    public WallFilter wallFilter (WallConfig wallConfig) {

        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        wallFilter.setLogViolation(true);//对被认为是攻击的SQL进行LOG.error输出
        wallFilter.setThrowException(false);//对被认为是攻击的SQL抛出SQLException
        return wallFilter;
    }

    /**
     * sql防火墙配置
     * @return
     */
    @Bean
    public WallConfig wallConfig () {

        WallConfig wallConfig = new WallConfig();
        wallConfig.setAlterTableAllow(false);
        wallConfig.setCreateTableAllow(false);
        wallConfig.setDeleteAllow(false);
        wallConfig.setMergeAllow(false);
        wallConfig.setDescribeAllow(false);
        wallConfig.setShowAllow(false);
        return wallConfig;
    }
    @Bean(name = "baseTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("baseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "baseSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.real.demo.**.dao");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("baseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


//    @Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName("baseSqlSessionFactory");
//		mapperScannerConfigurer.setBasePackage("com.peiqi.zf.**.dao");
////		Properties properties = new Properties();
////		properties.setProperty("mappers", BaseDao.class.getName());
////		properties.setProperty("notEmpty", "false");
////		properties.setProperty("IDENTITY", "MYSQL");
////		mapperScannerConfigurer.setpr
////		mapperScannerConfigurer.set
//		return mapperScannerConfigurer;
//	}


//    
//    @Bean
//    public static MapperScannerConfigurer getMapperScannerConfigurer(){
//        MapperScannerConfigurer config = new MapperScannerConfigurer();
//        config.setBasePackage("com.peiqi.zf.**.dao");
//        config.setSqlSessionFactoryBeanName("baseSqlSessionFactory");
//        return config;
//    }
//    



}