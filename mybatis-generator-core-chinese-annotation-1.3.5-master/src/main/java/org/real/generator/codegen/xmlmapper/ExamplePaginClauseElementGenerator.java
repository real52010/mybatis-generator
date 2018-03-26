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
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 *
 * @author Jeff Butler
 *
 */
public class ExamplePaginClauseElementGenerator extends AbstractXmlElementGenerator {

	private boolean isForUpdateByExample;

	public ExamplePaginClauseElementGenerator(boolean isForUpdateByExample) {
		super();
		this.isForUpdateByExample = isForUpdateByExample;
	}

	@Override
	public void addElements(XmlElement parentElement) {
		XmlElement answer = new XmlElement("sql"); //$NON-NLS-1$

		answer.addAttribute(new Attribute("id", "Example_Pagin_Clause")); //$NON-NLS-1$

		context.getCommentGenerator().addComment(answer);
		XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
		ifElement.addAttribute(new Attribute("test", "example.paginLimit != null"));

		XmlElement offsetNotNullElement = new XmlElement("if"); //$NON-NLS-1$
		offsetNotNullElement.addAttribute(new Attribute("test", "model.paginOffset != null"));
		offsetNotNullElement.addElement(new TextElement("limit ${model.paginOffset}, ${model.paginLimit}"));
		XmlElement offsetNullElement = new XmlElement("if"); //$NON-NLS-1$
		offsetNullElement.addAttribute(new Attribute("test", "model.paginOffset == null"));
		offsetNullElement.addElement(new TextElement("limit ${model.paginLimit}"));
		ifElement.addElement(offsetNotNullElement);
		ifElement.addElement(offsetNullElement);
		answer.addElement(ifElement);

//		if (context.getPlugins().sqlMapExamplePaginClauseElementGenerated(answer, introspectedTable)) {
			parentElement.addElement(answer);
//		}
	}
}
