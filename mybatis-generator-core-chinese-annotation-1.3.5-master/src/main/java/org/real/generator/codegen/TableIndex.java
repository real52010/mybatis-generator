package org.real.generator.codegen;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;

public class TableIndex {
	private boolean unique;
	private List<IntrospectedColumn> introspectedColumns;
	public TableIndex() {
		introspectedColumns= new ArrayList<IntrospectedColumn>();
	}
	public boolean isUnique() {
		return unique;
	}
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	public List<IntrospectedColumn> getIntrospectedColumns() {
		return introspectedColumns;
	}
	public void setIntrospectedColumns(List<IntrospectedColumn> introspectedColumns) {
		this.introspectedColumns = introspectedColumns;
	}
	
}
