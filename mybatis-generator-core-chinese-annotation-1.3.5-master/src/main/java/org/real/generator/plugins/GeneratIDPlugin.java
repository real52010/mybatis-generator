package org.real.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.TableConfiguration;

public class GeneratIDPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		TableConfiguration tableConfig = introspectedTable.getTableConfiguration();
		List<IntrospectedColumn> listColumns = introspectedTable.getPrimaryKeyColumns();
		for (IntrospectedColumn introspectedColumn : listColumns) {
			
			if (introspectedColumn.isAutoIncrement()) {
				introspectedColumn.setIdentity(true);
				GeneratedKey gkey=new GeneratedKey(introspectedColumn.getActualColumnName(), "Mysql", true, null);
//				GeneratedKey gkey=new GeneratedKey(introspectedColumn.getActualColumnName(), "JDBC", true, null);

				tableConfig.setGeneratedKey(gkey);

			}

		}
	}
}
