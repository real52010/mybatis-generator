package org.real.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

public class GeneratIndexColumnPlugin  extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		
		super.initialized(introspectedTable);
	}
}
