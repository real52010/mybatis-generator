package org.zt.ccty.springboot_mybatis_demo.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceContextHolder {

	
	
	private static final ThreadLocal<DataSourceType> local = new ThreadLocal<DataSourceType>();  
	  
    public static ThreadLocal<DataSourceType> getLocal() {  
        return local;  
    }  
  
    /** 
     * 读可能是多个库 
     */  
    public static void read() {  
        log.info("===============已切换数据据源到[读]模式===============");  
        local.set(DataSourceType.read);  
    }  
  
    /** 
     * 写只有一个库 
     */  
    public static void write() {  
        log.info("===============已切换数据据源到[写]模式===============");  
        local.set(DataSourceType.write);  
    }  
  
    public static DataSourceType getJdbcType() {  
        return local.get();  
    }  
    public static void SetJdbcType(DataSourceType dataSourceType) {  
    	local.set(dataSourceType);;  
    }  
    
    public static void clear() {

        log.info("==============清楚设置的数据源模式===============");  
    	local.remove();
    }

}
