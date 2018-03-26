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
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.AbstractGenerator;
import org.mybatis.generator.config.GeneratedKey;

/**
 *
 * @author Jeff Butler
 *
 */
public abstract class AbstractXmlElementGenerator extends AbstractGenerator {
    public AbstractXmlElementGenerator() {
        super();
    }

    public abstract void addElements(XmlElement parentElement);

    /**
     * This method should return an XmlElement for the select key used to
     * automatically generate keys.
     *
     * @param introspectedColumn
     *            the column related to the select key statement
     * @param generatedKey
     *            the generated key for the current table
     * @return the selectKey element
     */
    protected XmlElement getSelectKey(IntrospectedColumn introspectedColumn,
                                      GeneratedKey generatedKey) {
        String identityColumnType = introspectedColumn
                .getFullyQualifiedJavaType().getFullyQualifiedName();

        XmlElement answer = new XmlElement("selectKey"); //$NON-NLS-1$
        answer.addAttribute(new Attribute("resultType", identityColumnType)); //$NON-NLS-1$
        answer.addAttribute(new Attribute(
                "keyProperty", introspectedColumn.getJavaProperty())); //$NON-NLS-1$
        answer.addAttribute(new Attribute("order", //$NON-NLS-1$
                generatedKey.getMyBatis3Order()));

        answer.addElement(new TextElement(generatedKey
                .getRuntimeSqlStatement()));

        return answer;
    }

    protected XmlElement getBaseColumnListElement() {
        XmlElement answer = new XmlElement("include"); //$NON-NLS-1$
        answer.addAttribute(new Attribute("refid", //$NON-NLS-1$
                introspectedTable.getBaseColumnListId()));
        return answer;
    }

    protected XmlElement getBlobColumnListElement() {
        XmlElement answer = new XmlElement("include"); //$NON-NLS-1$
        answer.addAttribute(new Attribute("refid", //$NON-NLS-1$
                introspectedTable.getBlobColumnListId()));
        return answer;
    }

 

    protected XmlElement getUpdateByExampleIncludeElement() {
        XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
        ifElement.addAttribute(new Attribute("test", "_parameter != null")); //$NON-NLS-1$ //$NON-NLS-2$

        XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
        includeElement.addAttribute(new Attribute("refid", //$NON-NLS-1$
                introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
        ifElement.addElement(includeElement);

        return ifElement;
    }
    
    protected XmlElement getExampleIncludeElement() {
		XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
		ifElement.addAttribute(new Attribute("test", "_parameter != null")); //$NON-NLS-1$ //$NON-NLS-2$

		XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		includeElement.addAttribute(new Attribute("refid", //$NON-NLS-1$
				"Example_Where_Clause"));
		ifElement.addElement(includeElement);

		return ifElement;
	}

	protected XmlElement getUpdateIncludeElement() {
		XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		includeElement.addAttribute(new Attribute("refid", "Base_Update_Column_List"));

		return includeElement;
	}

	protected XmlElement getOrderByIncludeElement() {
		XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		includeElement.addAttribute(new Attribute("refid", "Example_OrderBy_Clause"));

		return includeElement;
	}

	protected XmlElement getPaginIncludeElement() {
		XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		includeElement.addAttribute(new Attribute("refid", "Example_Pagin_Clause"));

		return includeElement;
	}
}
