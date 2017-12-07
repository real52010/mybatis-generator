package org.zt.ccty.springboot_mybatis_demo.config;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

//@Intercepts({
//	@Signature(type = StatementHandler.class, method = "batch", args = { Statement.class}),
//	@Signature(type = StatementHandler.class, method = "update", args = { Statement.class}),
//	@Signature(type = StatementHandler.class, method = "query", args = { Statement.class,ResultHandler.class}),
//	 })
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }) })
@Slf4j
public class DynamicDataSourcePlugin implements Interceptor {

	private static final Map<String, DataSourceType> cacheMap = new ConcurrentHashMap<>();

	public Object intercept(Invocation invocation) throws Throwable {

		boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();

		Object[] objects = invocation.getArgs();
		MappedStatement ms = (MappedStatement) objects[0];

		BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
		log.debug("execute sql:" + boundSql.getSql(), ", param:" + boundSql.getParameterObject());
		DataSourceType dataSourceType = DataSourceContextHolder.getJdbcType();
		if (synchronizationActive) {
			log.debug("当前事务已经激活，无需选择默认数据源");
		} else if (dataSourceType != null) {
			log.debug("当前数据源已经选择为:" + dataSourceType.getName());
		} else {

			if ((dataSourceType = cacheMap.get(ms.getId())) == null) {

				if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
					if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
						dataSourceType = DataSourceType.write;
						log.debug("默认数据源设置,查询主建操作，设置为数据源:" + dataSourceType.getName());
					} else {
						dataSourceType = DataSourceType.read;
						log.debug("默认数据源设置,查询操作，设置为数据源:" + dataSourceType.getName());
					}

				} else {
					dataSourceType = DataSourceType.write;
					log.debug("默认数据源设置,更新操作，设置为数据源:" + dataSourceType.getName());
				}
				cacheMap.put(ms.getId(), dataSourceType);
			}
			DataSourceContextHolder.SetJdbcType(dataSourceType);

		}

		Object returnVal = invocation.proceed();
		 DataSourceContextHolder.clear();
		return returnVal;

	}

	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
