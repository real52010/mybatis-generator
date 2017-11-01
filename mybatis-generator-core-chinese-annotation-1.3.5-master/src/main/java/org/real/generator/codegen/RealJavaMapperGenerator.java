package org.real.generator.codegen;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.exception.InvalidConfigurationException;

import test.RealTest;

/**
 * 实体文件生成工具类
 * 
 * @author Administrator
 *
 */
public class RealJavaMapperGenerator extends JavaMapperGenerator {

	private static final FullyQualifiedJavaType JAVATYPE_LIST = new FullyQualifiedJavaType("java.util.List");
	private FullyQualifiedJavaType baseRecordType = null;

	public static void main(String[] args) throws SQLException, IOException, InterruptedException, InvalidConfigurationException {
		RealTest.main(null);
	}

	/**
	 * 返回XML生成器
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator#
	 * getMatchedXMLGenerator()
	 */
	@Override
	public AbstractXmlGenerator getMatchedXMLGenerator() {
		return new RealXMLMapperGenerator();
	}

	@Override
	public List<CompilationUnit> getCompilationUnits() {
		progressCallback.startTask(getString("Progress.17", //$NON-NLS-1$
				introspectedTable.getFullyQualifiedTable().toString()));
		CommentGenerator commentGenerator = context.getCommentGenerator();

		FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
		Interface interfaze = new Interface(type);
		interfaze.setVisibility(JavaVisibility.PUBLIC);
		commentGenerator.addJavaFileComment(interfaze);

		// 添加类注释
		commentGenerator.addExampleClassComment(interfaze);

		String rootInterface = introspectedTable.getTableConfigurationProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
		if (!stringHasValue(rootInterface)) {
			rootInterface = context.getJavaClientGeneratorConfiguration()
					.getProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
		}

		if (stringHasValue(rootInterface)) {
			FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootInterface);
			interfaze.addSuperInterface(fqjt);
			interfaze.addImportedType(fqjt);
		}
		// MLIST = new FullyQualifiedJavaType("List<M>");
		baseRecordType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		addInsertMethod(interfaze);
		addInsertBatchMethod(interfaze);
		addDeleteMethod(interfaze);
		addDeleteByExampleMethod(interfaze);
		addUpdateMethod(interfaze);
		addUpdateByExampleMethod(interfaze);
		addUpdateBySelectiveMethod(interfaze);
		addUpdateBatchBySelectiveMethod(interfaze);
		addSelectMethod(interfaze);
		addSelectByExampleMethod(interfaze);
		addCountByExampleMethod(interfaze);
		List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
		if (context.getPlugins().clientGenerated(interfaze, null, introspectedTable)) {
			answer.add(interfaze);
		}

		List<CompilationUnit> extraCompilationUnits = getExtraCompilationUnits();
		if (extraCompilationUnits != null) {
			answer.addAll(extraCompilationUnits);
		}

		return answer;
	}

	/**
	 * 插入数据
	 */
	protected void addInsertMethod(Interface interfaze) {
//		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

		interfaze.addImportedType(baseRecordType);
		Method method = new Method();
		method.setName("insert");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		Parameter parameter=new Parameter(baseRecordType, "record");
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("record");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		
		method.addParameter(parameter);
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}

	/**
	 * 批量插入数据
	 * 
	 * @param interfaze
	 */
	protected void addInsertBatchMethod(Interface interfaze) {
		interfaze.addImportedType(JAVATYPE_LIST);
		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(
				"List<" + baseRecordType.getShortName() + ">");
		Method method = new Method();
		method.setName("insertBatch");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addParameter(new Parameter(parameterType, "list"));
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}

	/**
	 * 删除数据
	 * 
	 * @param interfaze
	 */
	protected void addDeleteMethod(Interface interfaze) {

		Method method = new Method();
		method.setName("delete");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());

		List<IntrospectedColumn> introspectedColumns = introspectedTable.getPrimaryKeyColumns();
		boolean annotate = introspectedColumns.size() > 1;
		if (annotate) {
			interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		}
		StringBuilder sb = new StringBuilder();
		for (IntrospectedColumn introspectedColumn : introspectedColumns) {
			FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
			interfaze.addImportedType(type);
			Parameter parameter = new Parameter(type, introspectedColumn.getJavaProperty());
			if (annotate) {
				sb.setLength(0);
				sb.append("@Param(\""); //$NON-NLS-1$
				sb.append(introspectedColumn.getJavaProperty());
				sb.append("\")"); //$NON-NLS-1$
				parameter.addAnnotation(sb.toString());
			}
			method.addParameter(parameter);
		}
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);

	}

	// /**
	// * 批量删除数据
	// *
	// * @param interfaze
	// */
	// protected void addDeleteBatchMethod(Interface interfaze) {
	// super.addInsertMethod(interfaze);
	// }

	/**
	 * 按模板删除数据
	 * 
	 * @param interfaze
	 */
	protected void addDeleteByExampleMethod(Interface interfaze) {
		
		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter=new Parameter(parameterType, "example");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(parameterType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		Method method = new Method();
		method.setName("deleteByExample");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("example");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}
	/**
	 * 按模板对象数据
	 * 
	 * @param interfaze
	 */
	protected void addUpdateBySelectiveMethod(Interface interfaze) {
		
//		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter=new Parameter(baseRecordType, "record");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(baseRecordType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$

		Method method = new Method();
		method.setName("updateBySelective");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("record");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);
		
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}
	
	/**
	 * 按模板对象数据
	 * 
	 * @param interfaze
	 */
	protected void addUpdateBatchBySelectiveMethod(Interface interfaze) {
		interfaze.addImportedType(JAVATYPE_LIST);
		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(
				"List<" + baseRecordType.getShortName() + ">");
		Method method = new Method();
		method.setName("updateBatchBySelective");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addParameter(new Parameter(parameterType, "list"));
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}
	/**
	 * 按模板删除数据
	 * 
	 * @param interfaze
	 */
	protected void addUpdateMethod(Interface interfaze) {
		
//		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter=new Parameter(baseRecordType, "record");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(baseRecordType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$

		Method method = new Method();
		method.setName("update");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("record");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);
		
		List<IntrospectedColumn> introspectedColumns = introspectedTable.getPrimaryKeyColumns();
		boolean annotate = introspectedColumns.size() > 1;
		if (annotate) {
			interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		}
		
		for (IntrospectedColumn introspectedColumn : introspectedColumns) {
			 sb = new StringBuilder();
			FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
			interfaze.addImportedType(type);
			Parameter keyParameter = new Parameter(type, introspectedColumn.getJavaProperty());
			
			sb.setLength(0);
			sb.append("@Param(\""); //$NON-NLS-1$
			sb.append(introspectedColumn.getJavaProperty());
			sb.append("\")"); //$NON-NLS-1$
			keyParameter.addAnnotation(sb.toString()); 
			method.addParameter(keyParameter);
		}
		
		
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}

	/**
	 * 按模板删除数据
	 * 
	 * @param interfaze
	 */
	protected void addUpdateByExampleMethod(Interface interfaze) {
		
//		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter=new Parameter(baseRecordType, "record");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(baseRecordType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		
		Method method = new Method();
		method.setName("updateByExample");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("record");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);
		
		
		FullyQualifiedJavaType exampleParameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		
		interfaze.addImportedType(exampleParameterType); //$NON-NLS-1$
		Parameter exapleParameter = new Parameter(exampleParameterType, "example");
		
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("example");
		sb.append("\")"); //$NON-NLS-1$
		exapleParameter.addAnnotation(sb.toString()); 
		method.addParameter(exapleParameter);
		
		
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}

	

	/**
	 * 按模板对象数据
	 * 
	 * @param interfaze
	 */
	protected void addSelectMethod(Interface interfaze) { 
		Method method = new Method();
		method.setName("select");
		method.setReturnType(baseRecordType);
		List<IntrospectedColumn> introspectedColumns = introspectedTable.getPrimaryKeyColumns();
		boolean annotate = introspectedColumns.size() > 1;
		if (annotate) {
			interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		}
		StringBuilder sb = new StringBuilder();
		for (IntrospectedColumn introspectedColumn : introspectedColumns) {
			FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
			interfaze.addImportedType(type);
			Parameter parameter = new Parameter(type, introspectedColumn.getJavaProperty());
			if (annotate) {
				sb.setLength(0);
				sb.append("@Param(\""); //$NON-NLS-1$
				sb.append(introspectedColumn.getJavaProperty());
				sb.append("\")"); //$NON-NLS-1$
				parameter.addAnnotation(sb.toString());
			}
			method.addParameter(parameter);
		}
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);

	}

	/**
	 * 按模板对象数据
	 * 
	 * @param interfaze
	 */
	protected void addSelectByExampleMethod(Interface interfaze) {
		
		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter=new Parameter(parameterType, "example");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(parameterType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		Method method = new Method();
		method.setName("selectByExample");
		method.setReturnType(new FullyQualifiedJavaType(
				"List<" + baseRecordType.getShortName() + ">"));
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("example");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}

	/**
	 * 按模板对象数据
	 * 
	 * @param interfaze
	 */
	protected void addCountByExampleMethod(Interface interfaze) {
		
		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter=new Parameter(parameterType, "example");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(parameterType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		Method method = new Method();
		method.setName("countByExample");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("example");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);
		method.setVisibility(JavaVisibility.PUBLIC);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		interfaze.addMethod(method);
	}
}
