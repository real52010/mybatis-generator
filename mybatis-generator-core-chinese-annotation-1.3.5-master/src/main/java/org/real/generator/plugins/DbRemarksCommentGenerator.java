/*
 *  Copyright 2008 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.real.generator.plugins;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.util.StringUtility;

import test.RealTest;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * 此插件使用数据库表中列的注释来生成Java Model中属性的注释
 *
 * @author Owen Zou
 * 
 */
public class DbRemarksCommentGenerator implements CommentGenerator {

	/**
	 * The properties.
	 */
	private Properties properties;

	/**
	 * The suppress date.
	 */
	private boolean suppressDate;

	/**
	 * 所有注解
	 */
	private boolean suppressAllComments;

	/**
	 * 类注解
	 */
	private boolean addRemarkComments;

	/**
	 * JPA注解
	 */
	private boolean isAnnotations;

	private SimpleDateFormat dateFormat;

	// 是否在get、set方法里添加final关键字
	private boolean addMethodFinal;

	private String author;

	private static final String SOURCEURL = "https://github.com/real52010/mybatis-generator.git";

	/**
	 * Instantiates a new default comment generator.
	 */
	public DbRemarksCommentGenerator() {
		super();
		properties = new Properties();
		suppressDate = false;
		suppressAllComments = false;
		addRemarkComments = true;
		addMethodFinal = true;
		author = "real code generator";
	}

	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);

		suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

		suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

		addRemarkComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

		addMethodFinal = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_METHOD_FINAL));

		isAnnotations = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_JPAANNOTATIONS));

		String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
		if (StringUtility.stringHasValue(dateFormatString)) {
			dateFormat = new SimpleDateFormat(dateFormatString);
		}

		String authorString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_AUTHOR);
		if (StringUtility.stringHasValue(authorString)) {
			author = authorString;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addJavaFileComment(org.mybatis.
	 * generator.api.dom.java.CompilationUnit)
	 */
	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		if (suppressAllComments) {
			return;
		}
		if (isAnnotations) {
			compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.persistence.Table"));
			compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.persistence.Id"));
			compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.persistence.Column"));
			compilationUnit.addImportedType(new FullyQualifiedJavaType("javax.persistence.GeneratedValue"));
			compilationUnit.addImportedType(new FullyQualifiedJavaType("org.hibernate.validator.constraints.NotEmpty"));
		}
		compilationUnit.addFileCommentLine(" /** 本文件由 工具自动生成自动生成 " + SOURCEURL + "*/");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.generator.api.CommentGenerator#addClassComment(org.mybatis.
	 * generator.api.dom.java.InnerClass,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		// add no document level comments by default
		// 删除生成GeneratedCriteria对象的注释信息的注释
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		String shortName = innerClass.getType().getShortName();
		innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
		sb.append(" * ").append(introspectedTable.getFullyQualifiedTable().getRemark())
				.append(introspectedTable.getFullyQualifiedTable());
		if ("GeneratedCriteria".equals(shortName)) {
			sb.append("的基本动态SQL对象.");
		} else if ("Criterion".equals(shortName)) {
			sb.append("的动态SQL对象.");
		}

		innerClass.addJavaDocLine(sb.toString());
		innerClass.addJavaDocLine(" */");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis.
	 * generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		if ("distinct".equals(field.getName())) {
			sb.append(" 过滤重复数据");
		} else if ("orderByClause".equals(field.getName())) {
			sb.append(" 排序字段");
		} else if ("oredCriteria".equals(field.getName())) {
			sb.append(" 查询条件");
		} else if ("serialVersionUID".equals(field.getName())) {
			sb.append("串行版本ID");
		} else if ("paginLimit".equals(field.getName())) {
			sb.append(" 查询条数");
		} else if ("paginOffset".equals(field.getName())) {
			sb.append(" 查询开始数");
		}
		if (sb.length() > 0) {
			field.addJavaDocLine("/**" + sb.toString() + "**/");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis.
	 * generator.api.dom.java.Field, org.mybatis.generator.api.IntrospectedTable,
	 * org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		// 添加字段注释
		// StringBuffer sb = new StringBuffer();
		// 对应表中字段的备注(数据库中自己写的备注信息)

		if (addRemarkComments && introspectedColumn.getRemarks() != null
				&& !introspectedColumn.getRemarks().equals("")) {
			field.addJavaDocLine("/** ");
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
			if (introspectedColumn.getDefaultValue() != null && !introspectedColumn.getDefaultValue().isEmpty()) {
				field.addJavaDocLine(" * 默认：" + introspectedColumn.getDefaultValue());
			}
			field.addJavaDocLine(" */ ");
		}

		if (isAnnotations) {
			boolean isId = false;
			for (IntrospectedColumn column : introspectedTable.getPrimaryKeyColumns()) {
				if (introspectedColumn == column) {
					isId = true;
					field.addAnnotation("@Id");
					field.addAnnotation("@GeneratedValue");
					break;
				}
			}
			if (!introspectedColumn.isNullable() && !isId) {
				field.addAnnotation("@NotEmpty");
			}
			if (introspectedColumn.isIdentity()) {
				if (introspectedTable.getTableConfiguration().getGeneratedKey().getRuntimeSqlStatement()
						.equals("JDBC")) {
					field.addAnnotation("@GeneratedValue(generator = \"JDBC\")");
				} else {
					field.addAnnotation("@GeneratedValue(strategy = GenerationType.IDENTITY)");
				}
			} else if (introspectedColumn.isSequenceColumn()) {
				field.addAnnotation("@SequenceGenerator(name=\"\",sequenceName=\""
						+ introspectedTable.getTableConfiguration().getGeneratedKey().getRuntimeSqlStatement() + "\")");
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.generator.api.CommentGenerator#addGetterComment(org.mybatis.
	 * generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable,
	 * org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		method.setFinal(addMethodFinal);
		 if (addRemarkComments) {
		method.addJavaDocLine("/** "); //$NON-NLS-1$

		StringBuilder sb = new StringBuilder();
		sb.append(" * 获取 "); //$NON-NLS-1$
		if ( introspectedColumn.getRemarks() != null
				&& !introspectedColumn.getRemarks().equals("")) {
			sb.append(introspectedColumn.getRemarks()).append(" ");
		} else {
			sb.append(introspectedTable.getFullyQualifiedTable()).append('.')
					.append(introspectedColumn.getActualColumnName());
		}

		method.addJavaDocLine(sb.toString());

		sb.setLength(0);

		sb.append(" * @return "); //$NON-NLS-1$
		if (introspectedColumn.getRemarks() != null
				&& !introspectedColumn.getRemarks().equals("")) {
			sb.append(introspectedColumn.getRemarks());
		} else {
			sb.append(introspectedTable.getFullyQualifiedTable()).append('.')
					.append(introspectedColumn.getActualColumnName());
		}
		method.addJavaDocLine(sb.toString());
		method.addJavaDocLine(" */"); //$NON-NLS-1$
		 }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.generator.api.CommentGenerator#addSetterComment(org.mybatis.
	 * generator.api.dom.java.Method, org.mybatis.generator.api.IntrospectedTable,
	 * org.mybatis.generator.api.IntrospectedColumn)
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		method.setFinal(addMethodFinal);
		if (addRemarkComments) {
			method.addJavaDocLine("/** "); //$NON-NLS-1$

			StringBuilder sb = new StringBuilder();
			sb.append(" * 设置 "); //$NON-NLS-1$
			if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
				sb.append(introspectedColumn.getRemarks()).append(" ");
			} else {
				sb.append(introspectedTable.getFullyQualifiedTable()).append('.')
						.append(introspectedColumn.getActualColumnName());
			}

			method.addJavaDocLine(sb.toString());

			// 参数
			Parameter parm = method.getParameters().get(0);
			sb.setLength(0);
			sb.append(" * @param ").append(parm.getName() + " ");
			if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
				sb.append(introspectedColumn.getRemarks());
			} else {
				sb.append(introspectedTable.getFullyQualifiedTable()).append('.')
						.append(introspectedColumn.getActualColumnName());
			}
			method.addJavaDocLine(sb.toString());
			method.addJavaDocLine(" */"); //$NON-NLS-1$
		}
	}

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// 添加类注释
		if (suppressAllComments) {
			return;
		}
		if (addRemarkComments) {
			topLevelClass.addJavaDocLine("/** "); //$NON-NLS-1$

			String remarks = introspectedTable.getFullyQualifiedTable().getRemark();
			// String remarks = introspectedTable.getRemarks();
			if (StringUtility.stringHasValue(remarks)) {
				String[] remarkLines = remarks.split(System.getProperty("line.separator")); //$NON-NLS-1$
				for (String remarkLine : remarkLines) {
					topLevelClass.addJavaDocLine(" * " + remarkLine + " " + introspectedTable.getRemarks()); //$NON-NLS-1$
				}
			}

			addJavadocTag(topLevelClass);

			topLevelClass.addJavaDocLine(" */"); //$NON-NLS-1$
		}
		if (isAnnotations) {
			topLevelClass
					.addAnnotation("@Table(name=\"" + introspectedTable.getFullyQualifiedTableNameAtRuntime() + "\")");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addExampleClassComment(org.mybatis
	 * .generator.api.dom.java.JavaElement,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addExampleClassComment(JavaElement javaElement, IntrospectedTable introspectedTable) {
		// * @author Acooly Code Generator
		// * Date: 2016-04-05 20:12:59
		if (suppressAllComments) {
			return;
		}
		javaElement.addJavaDocLine("/**");
		String remarks = introspectedTable.getFullyQualifiedTable().getRemark();
		if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator")); //$NON-NLS-1$
			for (String remarkLine : remarkLines) {
				javaElement.addJavaDocLine(" * " + remarkLine + " " + introspectedTable.getRemarks() + "<br/>"); //$NON-NLS-1$
			}
		}
		addJavadocTag(javaElement);
		javaElement.addJavaDocLine(" */");

	}

	protected void addJavadocTag(JavaElement javaElement) {
		StringBuilder sb = new StringBuilder();

		sb.append(" * @author " + author);
		String s = getDateString();
		if (s != null) {
			sb.append("\n * date:");
			sb.append(s);
		}
		javaElement.addJavaDocLine(sb.toString());
	}

	protected String getDateString() {
		if (suppressDate) {
			return null;
		} else if (dateFormat != null) {
			return dateFormat.format(new Date());
		} else {
			// 我就喜欢这个格式化，不服自己修改
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.generator.api.CommentGenerator#addGeneralMethodComment(org.
	 * mybatis.generator.api.dom.java.Method,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

		if (suppressAllComments) {
			return;
		}
		method.setFinal(addMethodFinal);
		StringBuilder sb = new StringBuilder();

		sb.append(" *");
		if (method.isConstructor()) {
			sb.append(" 构造查询条件");
		}
		String method_name = method.getName();
		if ("toString".equals(method_name) || "hashCode".equals(method_name) || "equals".equals(method_name)) {
			return;
		} else if ("setOrderByClause".equals(method_name)) {
			sb.append(" 设置排序字段");
		} else if ("setDistinct".equals(method_name)) {
			sb.append(" 设置过滤重复数据");
		} else if ("getOredCriteria".equals(method_name)) {
			sb.append(" 获取当前的查询条件实例");
		} else if ("isDistinct".equals(method_name)) {
			sb.append(" 是否过滤重复数据");
		} else if ("getOrderByClause".equals(method_name)) {
			sb.append(" 获取排序字段");
		} else if ("createCriteria".equals(method_name)) {
			sb.append(" 创建一个查询条件");
		} else if ("createCriteriaInternal".equals(method_name)) {
			sb.append(" 内部构建查询条件对象");
		} else if ("clear".equals(method_name)) {
			sb.append(" 清除查询条件");
		} else if ("countByExample".equals(method_name)) {
			sb.append(" 查询数量");
		} else if ("delete".equals(method_name)) {
			sb.append(" 根据主键删除,该方法为物理删除");
		} else if ("deleteByExample".equals(method_name)) {
			sb.append("  <strong>根据条件删除,该方法为虚拟删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>");

		} else if ("virtualDelete".equals(method_name)) {
			sb.append(" 根据主键删除,该方法为物理删除");
		} else if ("virtualDeleteByExample".equals(method_name)) {
			sb.append("  <strong>根据条件删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>");

		} else if ("deleteByPrimaryKey".equals(method_name)) {
			sb.append(" 根据ID删除");
		} else if ("insert".equals(method_name)) {
			sb.append(" 添加对象所有字段");
		} else if ("insertSelective".equals(method_name)) {
			sb.append(" 添加对象对应字段");
		} else if ("insertBatch".equals(method_name)) {
			sb.append(" 添加List集合对象所有字段");
		} else if ("insertBatchSelective".equals(method_name)) {
			sb.append(" 添加List集合对象对应字段");
		} else if ("select".equals(method_name)) {
			sb.append(" 根据主键查询");
		} else if ("selectByExample".equals(method_name)) {
			sb.append(" 根据条件查询");
		} else if ("selectByPrimaryKey".equals(method_name)) {
			sb.append(" 根据ID查询");
		} else if ("update".equals(method_name)) {
			sb.append(" 根据主键修改");
		} else if ("addUpdateBySelective".equals(method_name)) {
			sb.append(" 根据对象里的字段修改");
		} else if ("updateByExampleSelective".equals(method_name)) {
			sb.append(" 根据条件修改对应字段");
		} else if ("updateByExample".equals(method_name)) {
			sb.append(" 根据条件修改所有字段");
		} else if ("updateBatchBySelective".equals(method_name)) {
			sb.append(" 根据列表里的字段批量修改");
		} else if ("updateByPrimaryKeySelective".equals(method_name)) {
			sb.append(" 根据ID修改对应字段");
		} else if ("updateByPrimaryKey".equals(method_name)) {
			sb.append(" 根据ID修改所有字段(必须含ID）");
		} else if ("updateByPrimaryKeyWithBLOBs".equals(method_name)) {
			sb.append(" 根据ID修改字段（包含二进制大对象）");
		} else if ("updateByExampleWithBLOBs".equals(method_name)) {
			sb.append(" 根据条件修改字段 （包含二进制大对象）");
		} else if ("selectByExampleWithBLOBs".equals(method_name)) {
			sb.append(" 根据条件查询（包含二进制大对象）");
		}

		final List<Parameter> parameterList = method.getParameters();
		if (!parameterList.isEmpty()) {
			if ("or".equals(method_name)) {
				sb.append(" 增加或者的查询条件,用于构建或者查询");
			}
		} else if ("or".equals(method_name)) {
			sb.append(" 创建一个新的或者查询条件");
		}

		method.addJavaDocLine("/** ");
		method.addJavaDocLine(sb.toString());

		String paramterName;
		for (Parameter parameter : parameterList) {
			sb.setLength(0);
			sb.append(" * @param "); //$NON-NLS-1$
			paramterName = parameter.getName();
			sb.append(paramterName);

			if ("orderByClause".equals(paramterName)) {
				sb.append(" 排序字段"); //$NON-NLS-1$
			} else if ("distinct".equals(paramterName)) {
				sb.append(" 是否过滤重复数据");
			} else if ("criteria".equals(paramterName)) {
				sb.append(" 过滤条件实例");
			} else if ("record".equals(paramterName)) {
				if ("insert".equals(method_name) || "insertSelective".equals(method_name)) {
					sb.append(" 插入字段对象(必须含ID）");
				} else if ("insertBatch".equals(method_name) || "insertBatchSelective".equals(method_name)) {
					sb.append(" 批量插入字段对象(必须含ID）");
				} else if ("updateByExample".equals(method_name) || "updateByExampleSelective".equals(method_name)) {
					sb.append(" 修改字段对象 (JOPO)");
				} else {
					sb.append(" 修改字段对象(必须含ID）");
				}
			} else if ("example".equals(paramterName)) {
				sb.append(" 条件对象");
			} else if (paramterName.toLowerCase().indexOf("id") > -1) {
				sb.append(" 主键ID");
			}
			method.addJavaDocLine(sb.toString());
		}

		method.addJavaDocLine(" */"); //$NON-NLS-1$

	}

	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComment(XmlElement xmlElement) {

	}

	@Override
	public void addRootComment(XmlElement rootElement) {

	}

}
