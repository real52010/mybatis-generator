package org.real.generator.codegen;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
import org.real.generator.RealInsoIntrospectedTable;

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

	public static void main(String[] args)
			throws SQLException, IOException, InterruptedException, InvalidConfigurationException {
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
		// 根据主键删除
		addDeleteMethod(interfaze);
		addDeleteIndexColumnMethod(interfaze);
		addDeleteByExampleMethod(interfaze);

		addVirtualDeleteMethod(interfaze);
		addVirtualDeleteIndexColumnMethod(interfaze);
		addVirtualDeleteByExampleMethod(interfaze);

		addUpdateMethod(interfaze);
		addUpdateIndexColumnMethod(interfaze);
		addUpdateByExampleMethod(interfaze);
		addUpdateBySelectiveMethod(interfaze);
		addUpdateBatchBySelectiveMethod(interfaze);

		addSelectMethod(interfaze);
		addSelectByExampleMethod(interfaze);
		addSelectIndexColumnMethod(interfaze);
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

	private String getTabIndexJavaMethodComment(String comment, TableIndex tableIndex) {
		List<IntrospectedColumn> listColumns = tableIndex.getIntrospectedColumns();

		StringBuffer paramNames = new StringBuffer();
		StringBuffer colNames = new StringBuffer();
		paramNames.setLength(0);

		for (IntrospectedColumn introspectedColumn : listColumns) {
			paramNames.append("    * @param " + introspectedColumn.getJavaProperty());
			paramNames.append(" " + introspectedColumn.getRemarks());
			paramNames.append("\r\n");
			colNames.append(introspectedColumn.getJavaProperty() + ",");
		}
		colNames.deleteCharAt(colNames.length() - 1);

		StringBuffer sb = new StringBuffer();

		sb.append("* " + String.format(comment, colNames)+ "\r\n");
		sb.append(paramNames.substring(0, paramNames.length() - 2));
		return sb.toString();
	}

	private String getTabIndexJavaMethodName(String preix, TableIndex tableIndex) {
		List<IntrospectedColumn> listColumns = tableIndex.getIntrospectedColumns();
		StringBuffer sb = new StringBuffer();
		sb.setLength(0);
		if (listColumns.size() == 1 && (preix == null || preix.equals(""))) {
			return listColumns.get(0).getJavaProperty();
		}
		String colmunName = null;
		for (IntrospectedColumn introspectedColumn : listColumns) {
			if (colmunName != null) {
				sb.append("And");
			}
			colmunName = introspectedColumn.getJavaProperty();
			sb.append(colmunName.replaceFirst(colmunName.substring(0, 1), colmunName.substring(0, 1).toUpperCase()));
		}
		return preix + sb.toString();

	}

	private void addUpdateIndexColumnMethod(Interface interfaze) {
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			addUpdateMethod(interfaze, entry.getValue());
		}
	}

	private void addDeleteIndexColumnMethod(Interface interfaze) {
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			if (entry.getValue().getIntrospectedColumns().size() == 1) {
				addDeleteMethod(interfaze, entry.getValue());
			}
		}
	}

	private void addSelectIndexColumnMethod(Interface interfaze) {
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			if (entry.getValue().getIntrospectedColumns().size() == 1) {
				addSelectMethod(interfaze, entry.getValue());
			}
		}
	}

	private void addVirtualDeleteIndexColumnMethod(Interface interfaze) {
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			if (entry.getValue().getIntrospectedColumns().size() == 1) {
				addVirtualDeleteMethod(interfaze, entry.getValue());
			}
		}
	}

	protected void addUpdateMethod(Interface interfaze, TableIndex tableIndex) {

		Parameter parameter = new Parameter(baseRecordType, "record");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(baseRecordType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$

		Method method = new Method();
		method.setName(getTabIndexJavaMethodName("updateBy", tableIndex));
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("record");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);

		List<IntrospectedColumn> introspectedColumns = tableIndex.getIntrospectedColumns();
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
		method.addJavaDocLine("/**");
		method.addJavaDocLine(getTabIndexJavaMethodComment("根据%s修改", tableIndex));
		method.addJavaDocLine("**/");
		// context.getCommentGenerator().addGeneralMethodComment(method,
		// introspectedTable);
		interfaze.addMethod(method);

	}

	protected void addSelectMethod(Interface interfaze, TableIndex tableIndex) {

		Method method = new Method();
		method.setName(getTabIndexJavaMethodName("selectBy", tableIndex));
		if (tableIndex.isUnique()) {
			method.setReturnType(baseRecordType);
		} else {
			method.setReturnType(new FullyQualifiedJavaType("List<" + baseRecordType.getShortName() + ">"));
		}
		List<IntrospectedColumn> introspectedColumns = introspectedTable.getPrimaryKeyColumns();
		boolean annotate = introspectedColumns.size() > 1;
		if (annotate) {
			interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		}
		StringBuilder sb = new StringBuilder();
		for (IntrospectedColumn introspectedColumn : tableIndex.getIntrospectedColumns()) {
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
		// context.getCommentGenerator().addGeneralMethodComment(method,
		// introspectedTable);
		method.addJavaDocLine("/**");
		method.addJavaDocLine(getTabIndexJavaMethodComment("根据%s查询，暂不支持分页查询", tableIndex));
		method.addJavaDocLine("**/");
		interfaze.addMethod(method);

	}

	protected void addDeleteMethod(Interface interfaze, TableIndex tableIndex) {

		Parameter parameter = new Parameter(baseRecordType, "record");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(baseRecordType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$

		Method method = new Method();
		method.setName(getTabIndexJavaMethodName("deleteBy", tableIndex));
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("record");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);

		List<IntrospectedColumn> introspectedColumns = tableIndex.getIntrospectedColumns();
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
		method.addJavaDocLine("/**");
		method.addJavaDocLine(getTabIndexJavaMethodComment("根据%s删除", tableIndex));
		method.addJavaDocLine("**/");
		// context.getCommentGenerator().addGeneralMethodComment(method,
		// introspectedTable);
		interfaze.addMethod(method);

	}

	protected void addVirtualDeleteMethod(Interface interfaze, TableIndex tableIndex) {

		Parameter parameter = new Parameter(baseRecordType, "record");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(baseRecordType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$

		Method method = new Method();
		method.setName(getTabIndexJavaMethodName("virtualDeleteBy", tableIndex));
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("record");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());
		method.addParameter(parameter);

		List<IntrospectedColumn> introspectedColumns = tableIndex.getIntrospectedColumns();
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
		method.addJavaDocLine("/**");
		method.addJavaDocLine(getTabIndexJavaMethodComment("根据%s删除,该方法为虚拟删除", tableIndex));
		method.addJavaDocLine("*/");
		// context.getCommentGenerator().addGeneralMethodComment(method,
		// introspectedTable);
		interfaze.addMethod(method);

	}

	/**
	 * 插入数据
	 */
	protected void addInsertMethod(Interface interfaze) {
		// FullyQualifiedJavaType parameterType = new
		// FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

		interfaze.addImportedType(baseRecordType);
		Method method = new Method();
		method.setName("insert");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		Parameter parameter = new Parameter(baseRecordType, "record");
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
	protected void addVirtualDeleteMethod(Interface interfaze) {

		Method method = new Method();
		method.setName("virtualDelete");
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
	protected void addVirtualDeleteByExampleMethod(Interface interfaze) {

		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter = new Parameter(parameterType, "example");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(parameterType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		Method method = new Method();
		method.setName("virtualDeleteByExample");
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		sb.setLength(0);
		sb.append("@Param(\""); //$NON-NLS-1$
		sb.append("example");
		sb.append("\")"); //$NON-NLS-1$
		parameter.addAnnotation(sb.toString());

		sb = new StringBuilder();

		sb.setLength(0);
		// sb.append("@Deprecated"); //$NON-NLS-1$
		method.addAnnotation(sb.toString());

		method.addParameter(parameter);
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
		Parameter parameter = new Parameter(parameterType, "example");
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

		sb = new StringBuilder();

		sb.setLength(0);
		// sb.append("@Deprecated"); //$NON-NLS-1$
		method.addAnnotation(sb.toString());

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

		// FullyQualifiedJavaType parameterType = new
		// FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter = new Parameter(baseRecordType, "record");
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

		// FullyQualifiedJavaType parameterType = new
		// FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter = new Parameter(baseRecordType, "record");
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

		// FullyQualifiedJavaType parameterType = new
		// FullyQualifiedJavaType(introspectedTable.getExampleType());
		Parameter parameter = new Parameter(baseRecordType, "record");
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

		interfaze.addImportedType(exampleParameterType); // $NON-NLS-1$
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
		Parameter parameter = new Parameter(parameterType, "example");
		StringBuilder sb = new StringBuilder();
		interfaze.addImportedType(parameterType);
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
		Method method = new Method();
		method.setName("selectByExample");
		method.setReturnType(new FullyQualifiedJavaType("List<" + baseRecordType.getShortName() + ">"));
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
		Parameter parameter = new Parameter(parameterType, "example");
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
