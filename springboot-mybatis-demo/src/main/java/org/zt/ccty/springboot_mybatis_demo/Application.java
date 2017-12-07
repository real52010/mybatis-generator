package org.zt.ccty.springboot_mybatis_demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.zt.ccty.springboot_mybatis_demo.config.DataSourceType;
import org.zt.ccty.springboot_mybatis_demo.config.DynamicDataSourcePlugin;
import org.zt.ccty.springboot_mybatis_demo.config.MyAbstractRoutingDataSource;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("org.zt.ccty.springboot_mybatis_demo.dao")
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class);

    @Value("${spring.datasource.type}")  
    private Class<? extends DataSource> dataSourceType;  
  
    @Value("${datasource.readSize}")  
    private String dataSourceSize;  
    @Resource(name = "writeDataSource")  
    private DataSource dataSource;  
    @Resource(name = "readDataSources")  
    private List<DataSource> readDataSources; 
    
    @Bean  
    @ConditionalOnMissingBean  
    public SqlSessionFactory sqlSessionFactory() throws Exception {  
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();  
        sqlSessionFactoryBean.setDataSource(roundRobinDataSouceProxy());  
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        sqlSessionFactoryBean.setPlugins( new Interceptor[]{new DynamicDataSourcePlugin()});
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);  
        return sqlSessionFactoryBean.getObject();  
    } 
    
    /** 
     * 有多少个数据源就要配置多少个bean 
     * @return 
     */  
    @Bean  
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {  
        int size = Integer.parseInt(dataSourceSize);  
        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(size);  
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();  
        // DataSource writeDataSource = SpringContextHolder.getBean("writeDataSource");  
        // 写  
        targetDataSources.put(DataSourceType.write.getType(),dataSource);  
        // targetDataSources.put(DataSourceType.read.getType(),readDataSource);  
        //多个读数据库时  
        for (int i = 0; i < size; i++) {  
            targetDataSources.put(i, readDataSources.get(i));  
        }  
        proxy.setDefaultTargetDataSource(dataSource);  
        proxy.setTargetDataSources(targetDataSources);  
        return proxy;  
    }  
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("SpringBoot Start Success!");
	}
}
