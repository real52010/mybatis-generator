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

import java.util.Iterator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.real.generator.codegen.TableIndex;

/**
 *
 * @author Jeff Butler
 *
 */
public class UpdateByIndexColumnElementGenerator extends IndexColumnElementGenerator {

	private boolean isSimple;

	private TableIndex tableIndex;

	public UpdateByIndexColumnElementGenerator(TableIndex tableIndex) {
		super();
		this.tableIndex = tableIndex;
	}

	@Override
	public void addElements(XmlElement parentElement) {
		XmlElement answer = new XmlElement("update"); //$NON-NLS-1$

		answer.addAttribute(new Attribute("id", getTabIndexJavaMethodName("updateBy", tableIndex))); ///$NON-NLS-1$
		answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
				"map"));

		context.getCommentGenerator().addComment(answer);
		StringBuilder sb = new StringBuilder();
		sb.append("update "); //$NON-NLS-1$
		sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
		answer.addElement(new TextElement(sb.toString()));
		XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		includeElement.addAttribute(new Attribute("refid", "Base_Update_Column_List"));
		answer.addElement(includeElement);
		sb.setLength(0);
		// sb.append("update "); //$NON-NLS-1$
		// sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
		// answer.addElement(new TextElement(sb.toString()));
		//
		// // set up for first column
		// sb.setLength(0);
		// sb.append("set "); //$NON-NLS-1$
		//
		// Iterator<IntrospectedColumn> iter;
		// if (isSimple) {
		// iter =
		// ListUtilities.removeGeneratedAlwaysColumns(introspectedTable.getNonPrimaryKeyColumns()).iterator();
		// } else {
		// iter =
		// ListUtilities.removeGeneratedAlwaysColumns(introspectedTable.getBaseColumns()).iterator();
		// }
		// while (iter.hasNext()) {
		// IntrospectedColumn introspectedColumn = iter.next();
		//
		// sb.append(MyBatis3FormattingUtilities
		// .getEscapedColumnName(introspectedColumn));
		// sb.append(" = "); //$NON-NLS-1$
		// sb.append(MyBatis3FormattingUtilities
		// .getParameterClause(introspectedColumn));
		//
		// if (iter.hasNext()) {
		// sb.append(',');
		// }
		//
		// answer.addElement(new TextElement(sb.toString()));
		//
		// // set up for the next column
		// if (iter.hasNext()) {
		// sb.setLength(0);
		// OutputUtilities.xmlIndent(sb, 1);
		// }
		// }
		//
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

		// if (context.getPlugins()
		// .sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(answer,
		// introspectedTable)) {
		parentElement.addElement(answer);
		// }
	}
}
