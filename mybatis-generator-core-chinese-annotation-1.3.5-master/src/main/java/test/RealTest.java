package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.real.generator.plugins.DbRemarksCommentGenerator;


public class RealTest {
	public static void main(String[] args) throws SQLException, IOException, InterruptedException, InvalidConfigurationException {

        Configuration configuration = new Configuration();
        Context context = new Context(ModelType.FLAT);
        context.setTargetRuntime("org.real.generator.RealInsoIntrospectedTable");
//        context.setTargetRuntime("MyBatis3");
        configuration.addContext(context);
        context.addProperty("javaFileEncoding", "UTF-8");
//	    String connectorLibPath = ConfigHelper.findConnectorLibPath(DbType.MySQL.toString());
	    configuration.addClasspathEntry("D:/gitserver/mybatis-generator/mybatis-code/lib/mysql-connector-java-5.1.22-bin.jar");
        // Table configuration
        TableConfiguration tableConfig = new TableConfiguration(context);
        tableConfig.setTableName("userprofile");
        tableConfig.setDomainObjectName("UserProfile");
     
        // 针对 postgresql 单独配置
//        if (DbType.valueOf(selectedDatabaseConfig.getDbType()).getDriverClass() == "org.postgresql.Driver") {
//            tableConfig.setDelimitIdentifiers(true);
//        }

        //添加GeneratedKey主键生成
//		if (StringUtils.isNoneEmpty(generatorConfig.getGenerateKeys())) {
//			tableConfig.setGeneratedKey(new GeneratedKey(generatorConfig.getGenerateKeys(), selectedDatabaseConfig.getDbType(), true, null));
//		}

//        if (generatorConfig.getMapperName() != null) {
//            tableConfig.setMapperName(generatorConfig.getMapperName());
//        }
        // add ignore columns
//        if (ignoredColumns != null) {
//            ignoredColumns.stream().forEach(ignoredColumn -> {
//                tableConfig.addIgnoredColumn(ignoredColumn);
//            });
//        }
//        if (columnOverrides != null) {
//            columnOverrides.stream().forEach(columnOverride -> {
//                tableConfig.addColumnOverride(columnOverride);
//            });
//        }
//        if (generatorConfig.isUseActualColumnNames()) {
//			tableConfig.addProperty("useActualColumnNames", "true");
//        }
        JDBCConnectionConfiguration jdbcConfig = new JDBCConnectionConfiguration();
        jdbcConfig.setDriverClass("com.mysql.jdbc.Driver");
        jdbcConfig.setConnectionURL("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8");
        jdbcConfig.setUserId("root");
        jdbcConfig.setPassword("root");
        String projectPath="D:/gitserver/mybatis-generator/mybatis-generator-core-chinese-annotation-1.3.5-master";
        // java model
        JavaModelGeneratorConfiguration modelConfig = new JavaModelGeneratorConfiguration();
        modelConfig.setTargetPackage("com.huilian.model");
        modelConfig.setTargetProject(projectPath+ "/" +"src/test/java");
        // Mapper configuration
        SqlMapGeneratorConfiguration mapperConfig = new SqlMapGeneratorConfiguration();
        mapperConfig.setTargetPackage("com.huilian.mapper");
        mapperConfig.setTargetProject(projectPath + "/" + "src/test/java");
        // DAO
        JavaClientGeneratorConfiguration daoConfig = new JavaClientGeneratorConfiguration();
        daoConfig.setConfigurationType("XMLMAPPER");
        daoConfig.setTargetPackage("com.huilian.dao");
        daoConfig.setTargetProject(projectPath + "/" +"src/test/java");
//        
        daoConfig.addProperty("enableSubPackages", "true");
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
//        if (generatorConfig.isComment()) {
            commentConfig.addProperty("columnRemarks", "true");
//        }
//        if (generatorConfig.isAnnotation()) {
            commentConfig.addProperty("annotations", "false");
//        }
        context.setCommentGeneratorConfiguration(commentConfig);
        
        //实体添加序列化
        PluginConfiguration serializablePluginConfiguration = new PluginConfiguration();
        serializablePluginConfiguration.addProperty("type", "org.mybatis.generator.plugins.SerializablePlugin");
        serializablePluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
        context.addPluginConfiguration(serializablePluginConfiguration);
        // toString, hashCode, equals插件
//        if (generatorConfig.isNeedToStringHashcodeEquals()) {
            PluginConfiguration pluginConfiguration1 = new PluginConfiguration();
            pluginConfiguration1.addProperty("type", "org.mybatis.generator.plugins.EqualsHashCodePlugin");
            pluginConfiguration1.setConfigurationType("org.mybatis.generator.plugins.EqualsHashCodePlugin");
            context.addPluginConfiguration(pluginConfiguration1);
            PluginConfiguration pluginConfiguration2 = new PluginConfiguration();
            pluginConfiguration2.addProperty("type", "org.mybatis.generator.plugins.ToStringPlugin");
            pluginConfiguration2.setConfigurationType("org.mybatis.generator.plugins.ToStringPlugin");
            context.addPluginConfiguration(pluginConfiguration2);

            PluginConfiguration pluginConfiguration3 = new PluginConfiguration();
            pluginConfiguration3.addProperty("type", "org.real.generator.plugins.GeneratIDPlugin");
            pluginConfiguration3.setConfigurationType("org.real.generator.plugins.GeneratIDPlugin");
            context.addPluginConfiguration(pluginConfiguration3);
            
            
            
//            PluginConfiguration pluginConfiguration3 = new PluginConfiguration();
//            pluginConfiguration3.addProperty("type", "org.mybatis.generator.plugins.MapperPlugin");
//            pluginConfiguration3.setConfigurationType("org.mybatis.generator.plugins.MapperPlugin");
//            pluginConfiguration3.addProperty("interfaceName", "IMapper");
//            pluginConfiguration3.addProperty("deleteMethod", "true");
//            context.addPluginConfiguration(pluginConfiguration3);
            
            
//            PluginConfiguration pluginConfiguration4 = new PluginConfiguration();
//            pluginConfiguration4.addProperty("type", "org.mybatis.generator.plugins.MybatisServicePlugin");
//            pluginConfiguration4.setConfigurationType("org.mybatis.generator.plugins.MybatisServicePlugin");
//            pluginConfiguration4.addProperty("implementationPackage", "com.huilian.service.impl");
//            pluginConfiguration4.addProperty("targetPackage", "com.huilian.service");
//
//            pluginConfiguration4.addProperty("targetProject", "D:/gitserver/mybatis-generator/mybatis-code" + "/" + "src/main/java");
//            context.addPluginConfiguration(pluginConfiguration4);

//            <!-- 统一Mapper 接口 -->
//            <plugin type="org.mybatis.generator.plugins.MapperPlugin">
//                <property name="interfaceName" value="IMapper"/>
//                <!-- 是否删除Mapper类里的方法，默认删除-->
//                <property name="deleteMethod" value="true"/>
//            </plugin>
//
//            <!-- service层插件 -->
//            <plugin type="org.mybatis.generator.plugins.MybatisServicePlugin">
//                <property name="targetPackage" value="${service.package}"/>
//                <property name="implementationPackage" value="${service.package.impl}"/>
//                <property name="targetProject" value="${service.path}"/>
//                <property name="enableInsert" value="true"/>
//                <property name="enableUpdateByExampleSelective" value="true"/>
//                <property name="enableInsertSelective" value="true"/>
//                <property name="enableUpdateByPrimaryKey" value="true"/>
//                <property name="enableDeleteByPrimaryKey" value="true"/>
//                <property name="enableDeleteByExample" value="true"/>
//                <property name="enableUpdateByPrimaryKeySelective" value="true"/>
//                <property name="enableUpdateByExample" value="true"/>
//            </plugin>
            
            
//            PluginConfiguration pluginConfiguration3 = new PluginConfiguration();
//            pluginConfiguration3.addProperty("type", "org.mybatis.generator.plugins.MapperConfigPlugin");
//            pluginConfiguration3.setConfigurationType("org.mybatis.generator.plugins.MapperConfigPlugin");
//            context.addPluginConfiguration(pluginConfiguration3);
//        }
        // limit/offset插件
//        if (generatorConfig.isOffsetLimit()) {
//            if (DbType.MySQL.name().equals(selectedDatabaseConfig.getDbType())
//		            || DbType.PostgreSQL.name().equals(selectedDatabaseConfig.getDbType())) {
//                PluginConfiguration pluginConfiguration = new PluginConfiguration();
//                pluginConfiguration.addProperty("type", "com.zzg.mybatis.generator.plugins.MySQLLimitPlugin");
//                pluginConfiguration.setConfigurationType("com.zzg.mybatis.generator.plugins.MySQLLimitPlugin");
//                context.addPluginConfiguration(pluginConfiguration);
//            }
//        }
            
        List<String> warnings = new ArrayList<String>();
        Set<String> fullyqualifiedTables = new HashSet<String>();
        Set<String> contexts = new HashSet<String>();
        ShellCallback shellCallback = new DefaultShellCallback(true); // override=true
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
        myBatisGenerator.generate(new TestProgressCallback(), contexts, fullyqualifiedTables);
    
	}
}
