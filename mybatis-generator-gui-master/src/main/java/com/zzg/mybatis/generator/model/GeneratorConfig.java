package com.zzg.mybatis.generator.model;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * GeneratorConfig is the Config of mybatis generator config exclude database
 * config
 *
 * Created by Owen on 6/16/16.
 */
public class GeneratorConfig {

	/**
	 * 本配置的名称
	 */
	private String name;

	private String connectorJarPath;

	private String projectFolder;

	private String modelPackage;

	private String modelPackageTargetFolder;

	private String daoPackage;

	private String daoTargetFolder;

//	private String mapperName;
	
	private String mapperNamePostfix;
	
	private String modelNamePostfix;
	
	private String mappingFilePostfix;

	private String mappingXMLPackage;

	private String mappingXMLTargetFolder;

	private String tableName;

	private String domainObjectName;

	private boolean offsetLimit;
	
	private boolean orderByClause;

	private boolean comment;

	private boolean needToStringHashcodeEquals;

	private boolean annotation;

	private boolean useActualColumnNames;

	private String generateKeys;
	
	private boolean createBaseExp;
	
	private boolean createIndexMethod;
	
	private boolean overwriteExtFiles;
	
	private boolean createVirtualDelete;
	private boolean supportLombok;
	
	
	
	private String virtualDeleteSql;
	
	private String exampleName;


	private String exampleTargetPackage;

	private String exampleTargetProject;
	
	private String tableAliasName;
	
	public String getTableAliasName() {
		return tableAliasName;
	}

	public void setTableAliasName(String tableAliasName) {
		this.tableAliasName = tableAliasName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getDomainObjectName() {
		return domainObjectName;
	}

	public void setDomainObjectName(String domainObjectName) {
		this.domainObjectName = domainObjectName;
	}

	public String getConnectorJarPath() {
		return connectorJarPath;
	}

	public void setConnectorJarPath(String connectorJarPath) {
		this.connectorJarPath = connectorJarPath;
	}

	public String getProjectFolder() {
		return projectFolder;
	}

	

	public void setProjectFolder(String projectFolder) {
		this.projectFolder = projectFolder;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getModelPackageTargetFolder() {
		return modelPackageTargetFolder;
	}

	public void setModelPackageTargetFolder(String modelPackageTargetFolder) {
		this.modelPackageTargetFolder = modelPackageTargetFolder;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	
	public String getExampleName() {
		return exampleName;
	}

	public void setExampleName(String exampleName) {
		this.exampleName = exampleName;
	}

	public String getDaoTargetFolder() {
		return daoTargetFolder;
	}

	public void setDaoTargetFolder(String daoTargetFolder) {
		this.daoTargetFolder = daoTargetFolder;
	}

	public String getMappingXMLPackage() {
		return mappingXMLPackage;
	}

	public void setMappingXMLPackage(String mappingXMLPackage) {
		this.mappingXMLPackage = mappingXMLPackage;
	}

	public String getMappingXMLTargetFolder() {
		return mappingXMLTargetFolder;
	}

	public void setMappingXMLTargetFolder(String mappingXMLTargetFolder) {
		this.mappingXMLTargetFolder = mappingXMLTargetFolder;
	}

	public boolean isOffsetLimit() {
		return offsetLimit;
	}

	public void setOffsetLimit(boolean offsetLimit) {
		this.offsetLimit = offsetLimit;
	}

	public boolean isComment() {
		return comment;
	}

	public void setComment(boolean comment) {
		this.comment = comment;
	}

    public boolean isNeedToStringHashcodeEquals() {
        return needToStringHashcodeEquals;
    }

    public void setNeedToStringHashcodeEquals(boolean needToStringHashcodeEquals) {
        this.needToStringHashcodeEquals = needToStringHashcodeEquals;
    }

    public boolean isAnnotation() {
		return annotation;
	}

	public void setAnnotation(boolean annotation) {
		this.annotation = annotation;
	}

	public boolean isUseActualColumnNames() {
		return useActualColumnNames;
	}

	public void setUseActualColumnNames(boolean useActualColumnNames) {
		this.useActualColumnNames = useActualColumnNames;
	}

	
	public String getMapperNamePostfix() {
		return mapperNamePostfix;
	}

	public void setMapperNamePostfix(String mapperNamePostfix) {
		this.mapperNamePostfix = mapperNamePostfix;
	}

	public String getModelNamePostfix() {
		return modelNamePostfix;
	}

	public void setModelNamePostfix(String modelNamePostfix) {
		this.modelNamePostfix = modelNamePostfix;
	}

	public String getMappingFilePostfix() {
		return mappingFilePostfix;
	}

	public void setMappingFilePostfix(String mappingFilePostfix) {
		this.mappingFilePostfix = mappingFilePostfix;
	}

	public String getGenerateKeys() {
		return generateKeys;
	}

	public void setGenerateKeys(String generateKeys) {
		this.generateKeys = generateKeys;
	}

	public boolean isCreateBaseExp() {
		return createBaseExp;
	}

	public void setCreateBaseExp(boolean createBaseExp) {
		this.createBaseExp = createBaseExp;
	}

	public boolean isCreateIndexMethod() {
		return createIndexMethod;
	}

	public void setCreateIndexMethod(boolean createIndexMethod) {
		this.createIndexMethod = createIndexMethod;
	}

	public boolean isOverwriteExtFiles() {
		return overwriteExtFiles;
	}

	public void setOverwriteExtFiles(boolean overwriteExtFiles) {
		this.overwriteExtFiles = overwriteExtFiles;
	}

	public boolean isCreateVirtualDelete() {
		return createVirtualDelete;
	}

	public void setCreateVirtualDelete(boolean createVirtualDelete) {
		this.createVirtualDelete = createVirtualDelete;
	}

	public String getVirtualDeleteSql() {
		return virtualDeleteSql;
	}

	public void setVirtualDeleteSql(String virtualDeleteSql) {
		this.virtualDeleteSql = virtualDeleteSql;
	}

	public String getExampleTargetPackage() {
		return exampleTargetPackage;
	}

	public void setExampleTargetPackage(String exampleTargetPackage) {
		this.exampleTargetPackage = exampleTargetPackage;
	}

	public String getExampleTargetProject() {
		return exampleTargetProject;
	}

	public void setExampleTargetProject(String exampleTargetProject) {
		this.exampleTargetProject = exampleTargetProject;
	}

	public boolean isSupportLombok() {
		return supportLombok;
	}

	public void setSupportLombok(boolean supportLombok) {
		this.supportLombok = supportLombok;
	}

	public boolean isOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(boolean orderByClause) {
		this.orderByClause = orderByClause;
	}

	
	
}
