package org.zt.ccty.springboot_mybatis_demo.config;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据库路由
 * 
 * @author 周涛
 *
 */
@Slf4j
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {

	private final int dataSourceNumber;
	private static final Long MAX_POOL = Long.MAX_VALUE;
	private AtomicLong count = new AtomicLong(0);
	private final Lock lock = new ReentrantLock();

	public MyAbstractRoutingDataSource(int dataSourceNumber) {
		this.dataSourceNumber = dataSourceNumber;
	}

	@Override
	protected Object determineCurrentLookupKey() {
		DataSourceType dataSourceType = DataSourceContextHolder.getJdbcType();

		if (dataSourceType == null) {
			log.debug("根据数据源模式选择数据源,数据源模式不存在，默认为：" + DataSourceType.write.getName());
			return DataSourceType.write.getType();
		} 

		log.debug("根据数据源模式选择数据源,数据源为：" + dataSourceType.getName());
		if (dataSourceType.equals(DataSourceType.write)) {
			return DataSourceType.write.getType();
		}

		// 读 简单负载均衡
		long number = count.getAndAdd(1);
		if ((number + 1) >= MAX_POOL) {
			try {
				lock.lock();
				if ((number + 1) >= MAX_POOL) {
					count.set(0l);
				}

			} finally {
				lock.unlock();
			}
		}
		int lookupKey = (int) number % dataSourceNumber;
		return new Integer(lookupKey);
	}

}
