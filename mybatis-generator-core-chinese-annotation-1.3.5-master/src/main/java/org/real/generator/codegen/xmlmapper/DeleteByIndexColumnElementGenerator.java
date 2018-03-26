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
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.real.generator.codegen.TableIndex;

/**
 *
 * @author Jeff Butler
 *
 */
public class DeleteByIndexColumnElementGenerator extends IndexColumnElementGenerator {

	private boolean isSimple;
	private TableIndex tableIndex;

	public DeleteByIndexColumnElementGenerator(TableIndex tableIndex) {
		super();
		this.tableIndex = tableIndex;
	}

	@Override
	public void addElements(XmlElement parentElement) {
		XmlElement answer = new XmlElement("delete"); //$NON-NLS-1$

		answer.addAttribute(new Attribute("id", getTabIndexJavaMethodName("deleteBy", tableIndex))); //$NON-NLS-1$
		String parameterClass;
		// if (!isSimple && introspectedTable.getRules().generatePrimaryKeyClass()) {
		// parameterClass = introspectedTable.getPrimaryKeyType();
		// } else {
		// PK fields are in the base class. If more than on PK
		// field, then they are coming in a map.
		if (tableIndex.getIntrospectedColumns().size() > 1) {
			parameterClass = "map"; //$NON-NLS-1$
		} else {
			parameterClass = introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().toString();
		}
		// }
		answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
				parameterClass));

		context.getCommentGenerator().addComment(answer);

		StringBuilder sb = new StringBuilder();
		sb.append("delete from "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
		answer.addElement(new TextElement(sb.toString()));

		boolean and = false;
		for (IntrospectedColumn introspectedColumn : tableIndex.getIntrospectedColumns()) {
			sb.setLength(0);
			if (and) {
				sb.append("  and "); //$NON-NLS-1$
			} else {
				sb.append("where "); //$NON-NLS-1$
				and = true;
			}

			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
			sb.append(" = "); //$NON-NLS-1$
			sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
			answer.addElement(new TextElement(sb.toString()));
		}

//		if (context.getPlugins().sqlMapDeleteByPrimaryKeyElementGenerated(answer, introspectedTable)) {
			parentElement.addElement(answer);
//		}
	}
}
