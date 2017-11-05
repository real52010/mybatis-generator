package org.real.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.real.generator.codegen.xmlmapper.UpdateByExampleElementGenerator;

public class VirtualDeletePlugin  extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		super.initialized(introspectedTable);
	}
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
	
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	
	
}
