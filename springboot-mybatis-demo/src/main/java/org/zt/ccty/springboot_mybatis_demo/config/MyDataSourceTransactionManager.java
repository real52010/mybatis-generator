package org.zt.ccty.springboot_mybatis_demo.config;

import javax.sql.DataSource;

import org.springframework.transaction.TransactionDefinition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyDataSourceTransactionManager extends org.springframework.jdbc.datasource.DataSourceTransactionManager {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

	public MyDataSourceTransactionManager(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		// 如果已经设置了读写权限测不进行修改

		// if (null == DataSourceContextHolder.getJdbcType()) {
		if (!definition.isReadOnly()) {
			DataSourceContextHolder.write();
		} else {
			DataSourceContextHolder.read();
		}
		// }
		super.doBegin(transaction, definition);
	}

	/**
	 * 清理本地线程的数据源
	 * 
	 * @param transaction
	 */
	@Override
	protected void doCleanupAfterCompletion(Object transaction) {
		super.doCleanupAfterCompletion(transaction);
		DataSourceContextHolder.clear();
	}

}
