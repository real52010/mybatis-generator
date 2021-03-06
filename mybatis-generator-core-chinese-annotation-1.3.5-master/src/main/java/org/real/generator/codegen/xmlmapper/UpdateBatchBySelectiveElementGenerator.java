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
package org.real.generator.codegen.xmlmapper;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 *
 * @author Jeff Butler
 *
 */
public class UpdateBatchBySelectiveElementGenerator extends AbstractXmlElementGenerator {

	private boolean isSimple;

	public UpdateBatchBySelectiveElementGenerator(boolean isSimple) {
		super();
		this.isSimple = isSimple;
	}

	@Override
	public void addElements(XmlElement parentElement) {
	
		parentElement.addElement(new TextElement(" <!--该方法不推荐使用，可能会导致阻塞，如要使用请打开数据库连接配置allowMutiQueries -->"));
		XmlElement answer = new XmlElement("update"); //$NON-NLS-1$
 
		FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType("java.util.List");
		answer.addAttribute(new Attribute("id", "updateBatchBySelective")); //$NON-NLS-1$
		answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName())); //$NON-NLS-1$
		StringBuilder sb = new StringBuilder();
		
		context.getCommentGenerator().addComment(answer);
		
		XmlElement listElement = new XmlElement("foreach");
		listElement.addAttribute(new Attribute("collection", "list"));
		listElement.addAttribute(new Attribute("item", "record"));
		listElement.addAttribute(new Attribute("index", "index"));
		listElement.addAttribute(new Attribute("open", ""));
		listElement.addAttribute(new Attribute("separator", ";"));
		// StringBuilder sb = new StringBuilder();
		// sb.append("delete from "); //$NON-NLS-1$
		// sb.append(introspectedTable
		// .getAliasedFullyQualifiedTableNameAtRuntime());
		// answer.addElement(new TextElement(sb.toString()));
		// XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		// includeElement.addAttribute(new Attribute("refid",
		// "Base_Update_Column_List"));
		// answer.addElement(includeElement)
		// answer.addElement(getExampleIncludeElement());;
		sb.append("update "); //$NON-NLS-1$
		sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
		listElement.addElement(new TextElement(sb.toString()));
		
		listElement.addElement(getUpdateIncludeElement());

		sb.setLength(0);
		boolean and = false;
		for (IntrospectedColumn introspectedColumn : introspectedTable.getPrimaryKeyColumns()) {
			sb.setLength(0);
			if (and) {
				sb.append("  and "); //$NON-NLS-1$
			} else {
				sb.append("where "); //$NON-NLS-1$
				and = true;
			}

			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
			sb.append(" = "); //$NON-NLS-1$
			sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "record"));
			listElement.addElement(new TextElement(sb.toString()));
		}

		answer.addElement(listElement);
//		if (context.getPlugins().sqlMapDeleteByExampleElementGenerated(answer, introspectedTable)) {
			parentElement.addElement(answer);
//		}
	}

 

	protected XmlElement getUpdateIncludeElement() {
		XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		includeElement.addAttribute(new Attribute("refid", "Base_Update_Column_List"));

		return includeElement;
	}
}
