package com.zzg.mybatis.generator.bridge;

import com.zzg.mybatis.generator.model.DatabaseConfig;
import com.zzg.mybatis.generator.model.DbType;
import com.zzg.mybatis.generator.model.GeneratorConfig;
import com.zzg.mybatis.generator.util.ConfigHelper;
import com.zzg.mybatis.generator.util.DbUtil;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.real.generator.plugins.DbRemarksCommentGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The bridge between GUI and the mybatis generator. All the operation to
 * mybatis generator should proceed through this class
 * <p>
 * Created by Owen on 6/30/16.
 */
public class MybatisGeneratorBridge {

	private static final Logger _LOG = LoggerFactory.getLogger(MybatisGeneratorBridge.class);

	private GeneratorConfig generatorConfig;

	private DatabaseConfig selectedDatabaseConfig;

	private ProgressCallback progressCallback;

	private List<IgnoredColumn> ignoredColumns;

	private List<ColumnOverride> columnOverrides;

	public MybatisGeneratorBridge() {
	}

	public void setGeneratorConfig(GeneratorConfig generatorConfig) {
		this.generatorConfig = generatorConfig;
	}

	public void setDatabaseConfig(DatabaseConfig databaseConfig) {
		this.selectedDatabaseConfig = databaseConfig;
	}

	public void generate() throws Exception {
		Configuration configuration = new Configuration();
		// Context context = new Context(ModelType.CONDITIONAL);

		Context context = new Context(ModelType.FLAT);
		configuration.addContext(context);
		context.addProperty("javaFileEncoding", "UTF-8");

		String connectorLibPath = ConfigHelper.findConnectorLibPath(selectedDatabaseConfig.getDbType());
		_LOG.info("connectorLibPath: {}", connectorLibPath);
		configuration.addClasspathEntry(connectorLibPath);
		// Table configuration
		TableConfiguration tableConfig = new TableConfiguration(context);
		tableConfig.setTableName(generatorConfig.getTableName());
		tableConfig.setDomainObjectName(generatorConfig.getDomainObjectName());

		// 针对 postgresql 单独配置
		if (DbType.valueOf(selectedDatabaseConfig.getDbType()).getDriverClass() == "org.postgresql.Driver") {
			tableConfig.setDelimitIdentifiers(true);
		}

		// 添加GeneratedKey主键生成
		if (StringUtils.isNoneEmpty(generatorConfig.getGenerateKeys())) {
			tableConfig.setGeneratedKey(new GeneratedKey(generatorConfig.getGenerateKeys(),
					selectedDatabaseConfig.getDbType(), true, null));
		}
//
//		if (generatorConfig.getMapperName() != null) {
//			tableConfig.setMapperName(generatorConfig.getMapperName());
//		}
		
		// add ignore columns
		if (ignoredColumns != null) {
			ignoredColumns.stream().forEach(ignoredColumn -> {
				tableConfig.addIgnoredColumn(ignoredColumn);
			});
		}
		if (columnOverrides != null) {
			columnOverrides.stream().forEach(columnOverride -> {
				tableConfig.addColumnOverride(columnOverride);
			});
		}

		// 分页插件
		if (generatorConfig.isOffsetLimit()) {
			tableConfig.addProperty("offsetLimit", "true");
		}
		// 分页插件
		if (generatorConfig.isOrderByClause()) {
			tableConfig.addProperty("orderByClause", "true");
		}

		if (generatorConfig.isUseActualColumnNames()) {
			tableConfig.addProperty("useActualColumnNames", "true");
		}
		if (generatorConfig.isCreateBaseExp()) {
			tableConfig.addProperty("createBaseExp", "true");
		}

		if (generatorConfig.isCreateIndexMethod()) {
			tableConfig.addProperty("createIndexMethod", "true");
		}
		if (!StringUtils.isEmpty(generatorConfig.getExampleName())) {
			tableConfig.addProperty("exampleName", generatorConfig.getExampleName());
		}
		if (!StringUtils.isEmpty(generatorConfig.getExampleTargetPackage())) {
			tableConfig.addProperty("exampleTargetPackage", generatorConfig.getExampleTargetPackage());
		}
		if (!StringUtils.isEmpty(generatorConfig.getExampleTargetProject())) {
			tableConfig.addProperty("exampleTargetProject", generatorConfig.getExampleTargetProject());
		} 
		if (generatorConfig.isCreateVirtualDelete()) {
			tableConfig.addProperty("createVirtualDelete", "true");
			tableConfig.addProperty("virtualDeleteSql", generatorConfig.getVirtualDeleteSql());
		}
		
		if (!StringUtils.isEmpty(generatorConfig.getMapperNamePostfix())) {
			tableConfig.addProperty("mapperNamePostfix", generatorConfig.getMapperNamePostfix());
		}
		if (!StringUtils.isEmpty(generatorConfig.getModelNamePostfix())) {
			tableConfig.addProperty("modelNamePostfix", generatorConfig.getModelNamePostfix());
		}
		if (!StringUtils.isEmpty(generatorConfig.getMappingFilePostfix())) {
			tableConfig.addProperty("mappingFilePostfix", generatorConfig.getMappingFilePostfix());
		}
		if (generatorConfig.isSupportLombok()) {
			tableConfig.addProperty("supportLombok", "true");
		}
//	    public static final String COMMENT_GENERATOR_ADD_JPAANNOTATIONS = "isAnnotations"; //$NON-NLS-1$
	    
//		private String mapperNamePostfix;
//		
//		private String modelNamePostfix;
//		
//		private String mappingFilePostfix;
		
		JDBCConnectionConfiguration jdbcConfig = new JDBCConnectionConfiguration();
		jdbcConfig.setDriverClass(DbType.valueOf(selectedDatabaseConfig.getDbType()).getDriverClass());
		jdbcConfig.setConnectionURL(DbUtil.getConnectionUrlWithSchema(selectedDatabaseConfig));
		jdbcConfig.setUserId(selectedDatabaseConfig.getUsername());
		jdbcConfig.setPassword(selectedDatabaseConfig.getPassword());
		// java model
		JavaModelGeneratorConfiguration modelConfig = new JavaModelGeneratorConfiguration();
		modelConfig.setTargetPackage(generatorConfig.getModelPackage());
		modelConfig.setTargetProject(
				generatorConfig.getProjectFolder() + "/" + generatorConfig.getModelPackageTargetFolder());
		// Mapper configuration
		SqlMapGeneratorConfiguration mapperConfig = new SqlMapGeneratorConfiguration();
		mapperConfig.setTargetPackage(generatorConfig.getMappingXMLPackage());
		mapperConfig.setTargetProject(
				generatorConfig.getProjectFolder() + "/" + generatorConfig.getMappingXMLTargetFolder());
		// DAO
		JavaClientGeneratorConfiguration daoConfig = new JavaClientGeneratorConfiguration();
		daoConfig.setConfigurationType("XMLMAPPER");
		daoConfig.setTargetPackage(generatorConfig.getDaoPackage());
		daoConfig.setTargetProject(generatorConfig.getProjectFolder() + "/" + generatorConfig.getDaoTargetFolder());

		context.setId("myid");
		context.addTableConfiguration(tableConfig);
		context.setJdbcConnectionConfiguration(jdbcConfig);
		context.setJdbcConnectionConfiguration(jdbcConfig);
		context.setJavaModelGeneratorConfiguration(modelConfig);
		context.setSqlMapGeneratorConfiguration(mapperConfig);
		context.setJavaClientGeneratorConfiguration(daoConfig);
		// Comment
		CommentGeneratorConfiguration commentConfig = new CommentGeneratorConfiguration();
		commentConfig.setConfigurationType(DbRemarksCommentGenerator.class.getName());
		if (generatorConfig.isComment()) {
			commentConfig.addProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS, "true");
		}
		if (generatorConfig.isAnnotation()) {
			commentConfig.addProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_JPAANNOTATIONS, "true");
		}
		
		context.setCommentGeneratorConfiguration(commentConfig);

		// 实体添加序列化
		PluginConfiguration serializablePluginConfiguration = new PluginConfiguration();
		serializablePluginConfiguration.addProperty("type", "org.mybatis.generator.plugins.SerializablePlugin");
		serializablePluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
		context.addPluginConfiguration(serializablePluginConfiguration);
		// toString, hashCode, equals插件
		if (generatorConfig.isNeedToStringHashcodeEquals()) {
			PluginConfiguration pluginConfiguration1 = new PluginConfiguration();
			pluginConfiguration1.addProperty("type", "org.mybatis.generator.plugins.EqualsHashCodePlugin");
			pluginConfiguration1.setConfigurationType("org.mybatis.generator.plugins.EqualsHashCodePlugin");
			context.addPluginConfiguration(pluginConfiguration1);
			PluginConfiguration pluginConfiguration2 = new PluginConfiguration();
			pluginConfiguration2.addProperty("type", "org.mybatis.generator.plugins.ToStringPlugin");
			pluginConfiguration2.setConfigurationType("org.mybatis.generator.plugins.ToStringPlugin");
			context.addPluginConfiguration(pluginConfiguration2);
		}

		// 自动检查表主键插件
		if (StringUtils.isEmpty(generatorConfig.getGenerateKeys())) {
			PluginConfiguration pluginConfiguration3 = new PluginConfiguration();
			pluginConfiguration3.addProperty("type", "org.real.generator.plugins.GeneratIDPlugin");
			pluginConfiguration3.setConfigurationType("org.real.generator.plugins.GeneratIDPlugin");
			context.addPluginConfiguration(pluginConfiguration3);
		}
		// // 生成索引列方法
		// if (generatorConfig.isCreateIndexMethod()) {
		// // PluginConfiguration pluginConfiguration4 = new PluginConfiguration();
		// // pluginConfiguration4.addProperty("type",
		// // "org.real.generator.plugins.GeneratIndexColumnPlugin");
		// //
		// pluginConfiguration4.setConfigurationType("org.real.generator.plugins.GeneratIndexColumnPlugin");
		// // context.addPluginConfiguration(pluginConfiguration4);
		// }
		//
		// // 生成索引列方法
		// if (generatorConfig.isCreateVirtualDelete()) {
		// // PluginConfiguration pluginConfiguration5 = new PluginConfiguration();
		// // pluginConfiguration5.addProperty("type",
		// // "org.real.generator.plugins.VirtualDeletePlugin");
		// //
		// pluginConfiguration5.setConfigurationType("org.real.generator.plugins.VirtualDeletePlugin");
		// // context.addPluginConfiguration(pluginConfiguration5);
		// }
		context.setTargetRuntime("org.real.generator.RealInsoIntrospectedTable");
		List<String> warnings = new ArrayList<>();
		Set<String> fullyqualifiedTables = new HashSet<>();
		Set<String> contexts = new HashSet<>();
		ShellCallback shellCallback = new DefaultShellCallback(generatorConfig.isOverwriteExtFiles()); // override=true
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
		myBatisGenerator.generate(progressCallback, contexts, fullyqualifiedTables);
	}

	public void setProgressCallback(ProgressCallback progressCallback) {
		this.progressCallback = progressCallback;
	}

	public void setIgnoredColumns(List<IgnoredColumn> ignoredColumns) {
		this.ignoredColumns = ignoredColumns;
	}

	public void setColumnOverrides(List<ColumnOverride> columnOverrides) {
		this.columnOverrides = columnOverrides;
	}
}
