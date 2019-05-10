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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.config.GeneratedKey;

/**
 *
 * @author Jeff Butler
 *
 */
public class BatchInsertColumnListElementGenerator extends AbstractXmlElementGenerator {

	public BatchInsertColumnListElementGenerator() {
		super();
	}

	@Override
	public void addElements(XmlElement parentElement) {
		XmlElement answer = new XmlElement("sql"); //$NON-NLS-1$

		answer.addAttribute(new Attribute("id", "Batch_Insert_Column_List")); //$NON-NLS-1$
		 

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

//		sb.append("insert into "); //$NON-NLS-1$
//		sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
//		answer.addElement(new TextElement(sb.toString()));

		XmlElement insertTrimElement = new XmlElement("trim"); //$NON-NLS-1$
		insertTrimElement.addAttribute(new Attribute("prefix", "(")); //$NON-NLS-1$ //$NON-NLS-2$
		insertTrimElement.addAttribute(new Attribute("suffix", ")")); //$NON-NLS-1$ //$NON-NLS-2$
		insertTrimElement.addAttribute(new Attribute("suffixOverrides", ",")); //$NON-NLS-1$ //$NON-NLS-2$
		
		
		XmlElement valuesTrimElement = new XmlElement("trim"); //$NON-NLS-1$
		valuesTrimElement.addAttribute(new Attribute("prefix", " (")); //$NON-NLS-1$ //$NON-NLS-2$
		valuesTrimElement.addAttribute(new Attribute("suffix", ")")); //$NON-NLS-1$ //$NON-NLS-2$
		valuesTrimElement.addAttribute(new Attribute("suffixOverrides", ",")); //$NON-NLS-1$ //$NON-NLS-2$
		
		 XmlElement innerForEach = new XmlElement("foreach");
        innerForEach.addAttribute(new Attribute("collection", "list"));
        innerForEach.addAttribute(new Attribute("item", "item"));
        innerForEach.addAttribute(new Attribute("index", "index"));
        innerForEach.addAttribute(new Attribute("separator", ","));
	        
		Iterator<IntrospectedColumn> iter = ListUtilities
				.removeIdentityAndGeneratedAlwaysColumns(introspectedTable.getAllColumns()) .iterator();
		while (iter.hasNext()) {
			
			IntrospectedColumn introspectedColumn= iter.next();
			
			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
			sb.append(',');
			if(sb.length()>80) {
				insertTrimElement.addElement(new TextElement(sb.toString()));
				sb.setLength(0);
			}
			
			
 
			sb2.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn,"record"));
			sb2.append(',');
			if(sb2.length()>80) {
				valuesTrimElement.addElement(new TextElement(sb2.toString()));
				sb2.setLength(0);
			}
			 
		}
		

		if(sb.length()>0) {
			insertTrimElement.addElement(new TextElement(sb.toString()));
			sb.setLength(0);
		}
		
		if(sb2.length()>0) {
			valuesTrimElement.addElement(new TextElement(sb2.toString()));
			sb2.setLength(0);
		}
		
		answer.addElement(insertTrimElement);
		answer.addElement(new TextElement(" values"));
		innerForEach.addElement(valuesTrimElement);
		answer.addElement(innerForEach);
		// if (context.getPlugins().sqlMapInsertSelectiveElementGenerated(answer,
		// introspectedTable)) {
		parentElement.addElement(answer);
		// }
	}
}
