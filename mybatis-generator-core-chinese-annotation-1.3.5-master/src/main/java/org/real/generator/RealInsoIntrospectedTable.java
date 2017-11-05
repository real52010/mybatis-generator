package org.real.generator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;
import org.mybatis.generator.codegen.mybatis3.model.BaseRecordGenerator;
import org.real.generator.codegen.model.ExampleGenerator;
import org.mybatis.generator.codegen.mybatis3.model.PrimaryKeyGenerator;
import org.mybatis.generator.codegen.mybatis3.model.RecordWithBLOBsGenerator;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.real.generator.codegen.RealJavaMapperGenerator;
import org.real.generator.codegen.TableIndex;

import test.RealTest;

public class RealInsoIntrospectedTable extends IntrospectedTableMyBatis3Impl {

    protected Map<String, TableIndex> indexColumns;
    
	public RealInsoIntrospectedTable() {
		super();
		indexColumns= new HashMap<String, TableIndex>();
	}
	
	public Map<String, TableIndex> getIndexColumns() {
		return indexColumns;
	}

	public void setIndexColumns(Map<String, TableIndex> indexColumns) {
		this.indexColumns = indexColumns;
	}

	public static void main(String[] args) throws SQLException, IOException, InterruptedException, InvalidConfigurationException {
		RealTest.main(null);
	}
	@Override
	protected AbstractJavaClientGenerator createJavaClientGenerator() {
		return new RealJavaMapperGenerator();
	}

	 
	@Override
	public List<GeneratedXmlFile> getGeneratedXmlFiles() {
		List<GeneratedXmlFile> answer = new ArrayList<GeneratedXmlFile>();

		if (xmlMapperGenerator != null) {
			Document document = xmlMapperGenerator.getDocument();
			GeneratedXmlFile gxf = new GeneratedXmlFile(document, getMyBatis3XmlMapperFileName(),
					getMyBatis3XmlMapperPackage(), context.getSqlMapGeneratorConfiguration().getTargetProject(), false,
					context.getXmlFormatter());
			if (context.getPlugins().sqlMapGenerated(gxf, this)) {
				answer.add(gxf);
			}
		}

		return answer;
	}
	 /**
     * Calculate model attributes.
     */
    protected void calculateModelAttributes() {
        String pakkage = calculateJavaModelPackage();

        StringBuilder sb = new StringBuilder();
        sb.append(pakkage);
        sb.append('.');
        sb.append(fullyQualifiedTable.getDomainObjectName());
        sb.append("Key"); //$NON-NLS-1$
        setPrimaryKeyType(sb.toString());

        sb.setLength(0);
        sb.append(pakkage);
        sb.append('.');
        sb.append(fullyQualifiedTable.getDomainObjectName());
        setBaseRecordType(sb.toString());

        sb.setLength(0);
        sb.append(pakkage);
        sb.append('.');
        sb.append(fullyQualifiedTable.getDomainObjectName());
        sb.append("WithBLOBs"); //$NON-NLS-1$
        setRecordWithBLOBsType(sb.toString());

        sb.setLength(0);
        sb.append(pakkage);
        sb.append('.');
        sb.append(fullyQualifiedTable.getDomainObjectName());
        sb.append("Example"); //$NON-NLS-1$
        setExampleType(sb.toString());
    }
	protected void calculateJavaModelGenerators(List<String> warnings, ProgressCallback progressCallback) {
		if (getRules().generateExampleClass()) {
			AbstractJavaGenerator javaGenerator = new ExampleGenerator();
			initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
			javaModelGenerators.add(javaGenerator);
		}

		if (getRules().generatePrimaryKeyClass()) {
			AbstractJavaGenerator javaGenerator = new PrimaryKeyGenerator();
			initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
			javaModelGenerators.add(javaGenerator);
		}

		if (getRules().generateBaseRecordClass()) {
			AbstractJavaGenerator javaGenerator = new BaseRecordGenerator();
			initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
			javaModelGenerators.add(javaGenerator);
		}

		if (getRules().generateRecordWithBLOBsClass()) {
			AbstractJavaGenerator javaGenerator = new RecordWithBLOBsGenerator();
			initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
			javaModelGenerators.add(javaGenerator);
		}
	}
}
