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
public class ExamplePaginClauseElementGenerator extends
        AbstractXmlElementGenerator {

    private boolean isForUpdateByExample;

    public ExamplePaginClauseElementGenerator(boolean isForUpdateByExample) {
        super();
        this.isForUpdateByExample = isForUpdateByExample;
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("sql"); //$NON-NLS-1$

//      if (isForUpdateByExample) {
          answer
                  .addAttribute(new Attribute(
                          "id", "Example_Pagin_Clause")); //$NON-NLS-1$
//      } else {
//          answer.addAttribute(new Attribute(
//                  "id","Example_Where_Clause")); //$NON-NLS-1$
//      }

      context.getCommentGenerator().addComment(answer);
//
      XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
      ifElement.addAttribute(new Attribute("test", "example.paginLimit != null"));
     
      XmlElement offsetNotNullElement = new XmlElement("if"); //$NON-NLS-1$
      offsetNotNullElement.addAttribute(new Attribute("test", "model.paginOffset != null"));
      offsetNotNullElement.addElement(new TextElement( "limit ${model.paginOffset}, ${model.paginLimit}"));
      XmlElement offsetNullElement = new XmlElement("if"); //$NON-NLS-1$
      offsetNullElement.addAttribute(new Attribute("test", "model.paginOffset == null"));
      offsetNullElement.addElement(new TextElement( "limit ${model.paginLimit}"));
      ifElement.addElement(offsetNotNullElement);
      ifElement.addElement(offsetNullElement);
      answer.addElement(ifElement);

      if (context.getPlugins()
              .sqlMapExampleWhereClauseElementGenerated(answer,
                      introspectedTable)) {
          parentElement.addElement(answer);
      }
  }

    private XmlElement getMiddleForEachElement(
            IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        String criteriaAttribute;
        boolean typeHandled;
        String typeHandlerString;
        if (introspectedColumn == null) {
            criteriaAttribute = "criteria.criteria"; //$NON-NLS-1$
            typeHandled = false;
            typeHandlerString = null;
        } else {
            sb.setLength(0);
            sb.append("criteria."); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.append("Criteria"); //$NON-NLS-1$
            criteriaAttribute = sb.toString();

            typeHandled = true;

            sb.setLength(0);
            sb.append(",typeHandler="); //$NON-NLS-1$
            sb.append(introspectedColumn.getTypeHandler());
            typeHandlerString = sb.toString();
        }

        XmlElement middleForEachElement = new XmlElement("foreach"); //$NON-NLS-1$
        middleForEachElement.addAttribute(new Attribute(
                "collection", criteriaAttribute)); //$NON-NLS-1$
        middleForEachElement.addAttribute(new Attribute("item", "criterion")); //$NON-NLS-1$ //$NON-NLS-2$

        XmlElement chooseElement = new XmlElement("choose"); //$NON-NLS-1$
        middleForEachElement.addElement(chooseElement);

        XmlElement when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "criterion.noValue")); //$NON-NLS-1$ //$NON-NLS-2$
        when.addElement(new TextElement("and ${criterion.condition}")); //$NON-NLS-1$
        chooseElement.addElement(when);

        when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "criterion.singleValue")); //$NON-NLS-1$ //$NON-NLS-2$
        sb.setLength(0);
        sb.append("and ${criterion.condition} #{criterion.value"); //$NON-NLS-1$
        if (typeHandled) {
            sb.append(typeHandlerString);
        }
        sb.append('}');
        when.addElement(new TextElement(sb.toString()));
        chooseElement.addElement(when);

        when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "criterion.betweenValue")); //$NON-NLS-1$ //$NON-NLS-2$
        sb.setLength(0);
        sb.append("and ${criterion.condition} #{criterion.value"); //$NON-NLS-1$
        if (typeHandled) {
            sb.append(typeHandlerString);
        }
        sb.append("} and #{criterion.secondValue"); //$NON-NLS-1$
        if (typeHandled) {
            sb.append(typeHandlerString);
        }
        sb.append('}');
        when.addElement(new TextElement(sb.toString()));
        chooseElement.addElement(when);

        when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "criterion.listValue")); //$NON-NLS-1$ //$NON-NLS-2$
        when.addElement(new TextElement("and ${criterion.condition}")); //$NON-NLS-1$
        XmlElement innerForEach = new XmlElement("foreach"); //$NON-NLS-1$
        innerForEach.addAttribute(new Attribute("collection", "criterion.value")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("item", "listItem")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("open", "(")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("close", ")")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("separator", ",")); //$NON-NLS-1$ //$NON-NLS-2$
        sb.setLength(0);
        sb.append("#{listItem"); //$NON-NLS-1$
        if (typeHandled) {
            sb.append(typeHandlerString);
        }
        sb.append('}');
        innerForEach.addElement(new TextElement(sb.toString()));
        when.addElement(innerForEach);
        chooseElement.addElement(when);

        return middleForEachElement;
    }
}
