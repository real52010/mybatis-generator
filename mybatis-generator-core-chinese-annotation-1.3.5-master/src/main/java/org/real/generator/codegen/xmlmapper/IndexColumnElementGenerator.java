package org.real.generator.codegen.xmlmapper;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.real.generator.codegen.TableIndex;

public abstract class IndexColumnElementGenerator extends AbstractXmlElementGenerator {

	protected String getTabIndexJavaMethodName(String preix, TableIndex tableIndex) {
		List<IntrospectedColumn> listColumns = tableIndex.getIntrospectedColumns();
		StringBuffer sb = new StringBuffer();
		sb.setLength(0);
		if (listColumns.size() == 1 && (preix == null || preix.equals(""))) {
			return listColumns.get(0).getJavaProperty();
		}
		String colmunName = null;
		for (IntrospectedColumn introspectedColumn : listColumns) {
			if (colmunName != null) {
				sb.append("And");
			}
			colmunName = introspectedColumn.getJavaProperty();
			sb.append(colmunName.replaceFirst(colmunName.substring(0, 1), colmunName.substring(0, 1).toUpperCase()));
		}
		return preix + sb.toString();

	}

}
