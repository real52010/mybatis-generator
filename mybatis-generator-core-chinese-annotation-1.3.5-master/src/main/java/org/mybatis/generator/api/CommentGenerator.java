/**
 * Copyright 2006-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mybatis.generator.api;

import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Properties;

/**
 * Implementations of this interface are used to generate comments for the
 * various artifacts.
 *
 * @author Jeff Butler
 */
public interface CommentGenerator {

	/**
	 * Adds properties for this instance from any properties configured in the
	 * CommentGenerator configuration.
	 *
	 * This method will be called before any of the other methods.
	 *
	 * @param properties
	 *            All properties from the configuration
	 */
	void addConfigurationProperties(Properties properties);

	/**
	 * 添加java类文件注释 	
	 * <p>
	 *
	 * The default implementation does nothing.
	 *
	 * @param compilationUnit
	 *            the compilation unit
	 */
	void addJavaFileComment(CompilationUnit compilationUnit);
	
	/**
	 * 添加查询条件内部类注解
	 *
	 * @param innerClass
	 *            the inner class
	 * @param introspectedTable
	 *            the introspected table
	 */
	void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable);
	
	/**
	 * 添加entity属性注释
	 *
	 * @param field
	 *            the field
	 * @param introspectedTable
	 *            the introspected table
	 */
	void addFieldComment(Field field, IntrospectedTable introspectedTable);
	/**
	 * 添加entity属性注释
	 *
	 * @param field
	 *            the field
	 * @param introspectedTable
	 *            the introspected table
	 * @param introspectedColumn
	 *            the introspected column
	 */
	void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn); 
	
	/**
	 * 添加get方法注释
	 *
	 * @param method
	 *            the method
	 * @param introspectedTable
	 *            the introspected table
	 * @param introspectedColumn
	 *            the introspected column
	 */
	void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn);

	/**
	 * 添加set方法注释
	 *
	 * @param method
	 *            the method
	 * @param introspectedTable
	 *            the introspected table
	 * @param introspectedColumn
	 *            the introspected column
	 */
	void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn);

	/**
	 * 添加DAO类注解
	 *
	 * @param topLevelClass
	 *            the top level class
	 * @param introspectedTable
	 *            the introspected table
	 */
	void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable);


	/**
	 * 添加DAO方法注解
	 *
	 * @param method
	 *            the method
	 * @param introspectedTable
	 *            the introspected table
	 */
	void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable);

	
	/**
	 * 添加Example类的注释
	 * 
	 * @param javaElement
	 */
	void addExampleClassComment(JavaElement javaElement, IntrospectedTable introspectedTable);

	

	/**
	 * 暂未使用
	 *
	 * @param innerEnum
	 *            the inner enum
	 * @param introspectedTable
	 *            the introspected table
	 */
	void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable);

	



	/**
	 * 添加xml节点注释
	 * @param xmlElement
	 *            the xml element
	 */
	void addComment(XmlElement xmlElement);
	/**
	 *
	 * 根节点注释 
	 * The default implementation does nothing.
	 *
	 * @param rootElement
	 *            the root element
	 */
	void addRootComment(XmlElement rootElement);
}
