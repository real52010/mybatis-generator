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

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
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
public class SelectByExampleElementGenerator extends
        AbstractXmlElementGenerator {

    public SelectByExampleElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute(
                "id", "selectByExample")); //$NON-NLS-1$
        if (introspectedTable.getRules().generateResultMapWithBLOBs()) {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getResultMapWithBLOBsId()));
        } else {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getBaseResultMapId()));
        }

//        String parameterType;
//        if (introspectedTable.getRules().generatePrimaryKeyClass()) {
//            parameterType = introspectedTable.getPrimaryKeyType();
//        } else {
//            // PK fields are in the base class. If more than on PK
//            // field, then they are coming in a map.
//            if (introspectedTable.getPrimaryKeyColumns().size() > 1) {
//                parameterType = "map"; //$NON-NLS-1$
//            } else {
//                parameterType = introspectedTable.getPrimaryKeyColumns().get(0)
//                        .getFullyQualifiedJavaType().toString();
//            }
//        }

        answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
        		introspectedTable.getExampleType()));

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
        sb.append("select "); //$NON-NLS-1$

        if (stringHasValue(introspectedTable
                .getSelectByPrimaryKeyQueryId())) {
            sb.append('\'');
            sb.append(introspectedTable.getSelectByPrimaryKeyQueryId());
            sb.append("' as QUERYID,"); //$NON-NLS-1$
        }
        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getBaseColumnListElement());
//        if (introspectedTable.hasBLOBColumns()) {
//            answer.addElement(new TextElement(",")); //$NON-NLS-1$
//            answer.addElement(getBlobColumnListElement());
//        }

        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable
                .getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getExampleIncludeElement());
        answer.addElement(getOrderByIncludeElement());
        answer.addElement(getPaginIncludeElement());
//        boolean and = false;
//        for (IntrospectedColumn introspectedColumn : introspectedTable
//                .getPrimaryKeyColumns()) {
//            sb.setLength(0);
//            if (and) {
//                sb.append("  and "); //$NON-NLS-1$
//            } else {
//                sb.append("where "); //$NON-NLS-1$
//                and = true;
//            }
//
//            sb.append(MyBatis3FormattingUtilities
//                    .getAliasedEscapedColumnName(introspectedColumn));
//            sb.append(" = "); //$NON-NLS-1$
//            sb.append(MyBatis3FormattingUtilities
//                    .getParameterClause(introspectedColumn));
//            answer.addElement(new TextElement(sb.toString()));
//        }

        if (context.getPlugins()
                .sqlMapSelectByPrimaryKeyElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
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
