package org.real.generator.codegen;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.BaseColumnListElementGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByExampleSelectiveElementGenerator;
import org.real.generator.codegen.xmlmapper.UpdateByPrimaryKeyWithoutBLOBsElementGenerator;
import org.real.generator.codegen.xmlmapper.UpdateBySelectiveElementGenerator;
import org.real.generator.codegen.xmlmapper.VirtualDeleteByExampleElementGenerator;
import org.real.generator.codegen.xmlmapper.VirtualDeleteByIndexColumnElementGenerator;
import org.real.generator.codegen.xmlmapper.VirtualDeleteByPrimaryKeyElementGenerator;
import org.real.generator.codegen.xmlmapper.InsertBatchElementGenerator;
import org.real.generator.RealInsoIntrospectedTable;
import org.real.generator.codegen.xmlmapper.BaseInsertColumnListElementGenerator;
import org.real.generator.codegen.xmlmapper.BaseUpdateColumnListElementGenerator;
import org.real.generator.codegen.xmlmapper.CountByExampleElementGenerator;
import org.real.generator.codegen.xmlmapper.DeleteByExampleElementGenerator;
import org.real.generator.codegen.xmlmapper.DeleteByIndexColumnElementGenerator;
import org.real.generator.codegen.xmlmapper.DeleteByPrimaryKeyElementGenerator;
import org.real.generator.codegen.xmlmapper.ExampleOrderByClauseElementGenerator;
import org.real.generator.codegen.xmlmapper.ExamplePaginClauseElementGenerator;
import org.real.generator.codegen.xmlmapper.ExampleWhereClauseElementGenerator;
import org.real.generator.codegen.xmlmapper.InsertElementGenerator;
import org.real.generator.codegen.xmlmapper.ResultMapWithoutBLOBsElementGenerator;
import org.real.generator.codegen.xmlmapper.SelectByExampleElementGenerator;
import org.real.generator.codegen.xmlmapper.SelectByIndexColumnElementGenerator;
import org.real.generator.codegen.xmlmapper.SelectByPrimaryKeyElementGenerator;
import org.real.generator.codegen.xmlmapper.UpdateBatchBySelectiveElementGenerator;
import org.real.generator.codegen.xmlmapper.UpdateByExampleElementGenerator;
import org.real.generator.codegen.xmlmapper.UpdateByIndexColumnElementGenerator;
import org.mybatis.generator.exception.InvalidConfigurationException;

import test.RealTest;

/**
 * XML文件成工具类
 * 
 * @author Administrator
 *
 */
public class RealXMLMapperGenerator extends XMLMapperGenerator {
	public RealXMLMapperGenerator() {
		super();
	}

	public static void main(String[] args)
			throws SQLException, IOException, InterruptedException, InvalidConfigurationException {
		RealTest.main(null);
	}

	protected XmlElement getSqlMapElement() {
		FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
		progressCallback.startTask(getString("Progress.12", table.toString())); //$NON-NLS-1$
		XmlElement answer = new XmlElement("mapper"); //$NON-NLS-1$
		String namespace = introspectedTable.getMyBatis3SqlMapNamespace();
		answer.addAttribute(new Attribute("namespace", //$NON-NLS-1$
				namespace));

		context.getCommentGenerator().addRootComment(answer);
		
		addResultMapWithoutBLOBsElement(answer);
		addExampleWhereClauseElement(answer);
		addExampleOrderByClauseElement(answer);
		addExamplePaginClauseElement(answer); 
		addBaseColumnListElement(answer);
		addBaseInsertColumnListElement(answer);
		addBaseUpdateColumnListElement(answer); 

		
		
		addInsertElement(answer);
		addInsertBatchElement(answer);
		addDeleteByPrimaryKeyListElement(answer);
		addDeleteByExampleListElement(answer);
		addDeleteByIndexColumnMethod(answer);
		
		addUpdateByPrimaryKeyWithoutBLOBsElement(answer);
		addUpdateByExampleElement(answer);
		addUpdateBySelectiveElement(answer);
		addUpdateBatchBySelectiveElement(answer);
		addUpdateByIndexColumnMethod(answer);
		
		addSelectByPrimaryKeyElementElement(answer);
		addSelectByExampleElementElement(answer);
		addSelectByIndexColumnMethod(answer);
		
		addCountByExampleElementElement(answer);
		addVirtualDeleteByExampleElement(answer);
		addVirtualDeleteByPrimaryKeyElement(answer);
		addVirtualDeleteIndexColumnMethod(answer);
		// addResultMapWithBLOBsElement(answer);
		// addMyBatis3UpdateByExampleWhereClauseElement(answer);
		// addBaseColumnListElement(answer);
		// addBlobColumnListElement(answer);
		// addSelectByExampleWithBLOBsElement(answer);
		// addSelectByExampleWithoutBLOBsElement(answer);
		// addSelectByPrimaryKeyElement(answer);
		// addDeleteByPrimaryKeyElement(answer);
		// addDeleteByExampleElement(answer);
		// addInsertSelectiveElement(answer);
		// addInsertBatchElement(answer);
		// addInsertBatchSelectiveElement(answer);
		// addCountByExampleElement(answer);
		// addUpdateByExampleSelectiveElement(answer);
		// addUpdateByExampleWithBLOBsElement(answer);
		// addUpdateByExampleWithoutBLOBsElement(answer);
		// addUpdateByPrimaryKeySelectiveElement(answer);
		// addUpdateByPrimaryKeyWithBLOBsElement(answer);
		// addUpdateByPrimaryKeyWithoutBLOBsElement(answer);

		return answer;
	}

	private void addUpdateByIndexColumnMethod(XmlElement parentElement) {
		

		if(!"true".equals(introspectedTable.getTableConfiguration().getProperty("createIndexMethod"))) {
			return;
		}
//		"createIndexMethod"
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			 addUpdateByIndexCloumnElementElement(parentElement, entry.getValue());
		}
	}

	private void addDeleteByIndexColumnMethod(XmlElement parentElement) {
		if(!"true".equals(introspectedTable.getTableConfiguration().getProperty("createIndexMethod"))) {
			return;
		}
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			if (entry.getValue().getIntrospectedColumns().size() == 1) {
				 addDeleteByIndexCloumnElementElement(parentElement, entry.getValue());
			}
		}
	}

	private void addSelectByIndexColumnMethod(XmlElement parentElement) {
		if(!"true".equals(introspectedTable.getTableConfiguration().getProperty("createIndexMethod"))) {
			return;
		}
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			if (entry.getValue().getIntrospectedColumns().size() == 1) {
				addSelectByIndexCloumnElementElement(parentElement, entry.getValue());
			}
		}
	}

	private void addVirtualDeleteIndexColumnMethod(XmlElement parentElement) {
		if (!(introspectedTable instanceof RealInsoIntrospectedTable)) {
			return;
		}
		if(!"true".equals(introspectedTable.getTableConfiguration().getProperty("createIndexMethod"))) {
			return;
		} 
		if (!"true".equals(introspectedTable.getTableConfiguration().getProperty("createVirtualDelete"))) {
			return;
		}
		RealInsoIntrospectedTable realInsoIntrospectedTable = (RealInsoIntrospectedTable) introspectedTable;
		Map<String, TableIndex> indexMap = realInsoIntrospectedTable.getIndexColumns();
		Set<Entry<String, TableIndex>> set = indexMap.entrySet();
		for (Entry<String, TableIndex> entry : set) {
			if (entry.getValue().getIntrospectedColumns().size() == 1) {
				addViatualDeleteByIndexCloumnElementElement(parentElement, entry.getValue());
			}
		}
	}
	protected void addSelectByIndexCloumnElementElement(XmlElement parentElement,TableIndex tableIndex) {
		AbstractXmlElementGenerator elementGenerator = new SelectByIndexColumnElementGenerator(tableIndex);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}
	protected void addDeleteByIndexCloumnElementElement(XmlElement parentElement,TableIndex tableIndex) {
		AbstractXmlElementGenerator elementGenerator = new DeleteByIndexColumnElementGenerator(tableIndex);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}
	protected void addUpdateByIndexCloumnElementElement(XmlElement parentElement,TableIndex tableIndex) {
		AbstractXmlElementGenerator elementGenerator = new UpdateByIndexColumnElementGenerator(tableIndex);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}
	protected void addViatualDeleteByIndexCloumnElementElement(XmlElement parentElement,TableIndex tableIndex) {
		AbstractXmlElementGenerator elementGenerator = new VirtualDeleteByIndexColumnElementGenerator(tableIndex);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	@Override
	protected void addResultMapWithoutBLOBsElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new ResultMapWithoutBLOBsElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	@Override
	protected void addExampleWhereClauseElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new ExampleWhereClauseElementGenerator(true);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addExampleOrderByClauseElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new ExampleOrderByClauseElementGenerator(true);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	@Override
	protected void addInsertElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new InsertElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addInsertBatchElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new InsertBatchElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	@Override
	protected void addBaseColumnListElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new BaseColumnListElementGenerator();
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addBaseInsertColumnListElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new BaseInsertColumnListElementGenerator();
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addBaseUpdateColumnListElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new BaseUpdateColumnListElementGenerator();
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addDeleteByPrimaryKeyListElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new DeleteByPrimaryKeyElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addDeleteByExampleListElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new DeleteByExampleElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addUpdateByPrimaryKeyWithoutBLOBsElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeyWithoutBLOBsElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addUpdateByExampleElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new UpdateByExampleElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addUpdateBySelectiveElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new UpdateBySelectiveElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addUpdateBatchBySelectiveElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new UpdateBatchBySelectiveElementGenerator(false);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addSelectByPrimaryKeyElementElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new SelectByPrimaryKeyElementGenerator();
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addSelectByExampleElementElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new SelectByExampleElementGenerator();
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addCountByExampleElementElement(XmlElement parentElement) {
		AbstractXmlElementGenerator elementGenerator = new CountByExampleElementGenerator();
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addExamplePaginClauseElement(XmlElement parentElement) {
		if("true".equals(introspectedTable.getTableConfiguration().getProperty("offsetLimit"))) {
			AbstractXmlElementGenerator elementGenerator = new ExamplePaginClauseElementGenerator(true);
			initializeAndExecuteGenerator(elementGenerator, parentElement);
		}
	}

	protected void addVirtualDeleteByExampleElement(XmlElement parentElement) {
		if (!"true".equals(introspectedTable.getTableConfiguration().getProperty("createVirtualDelete"))) {
			return;
		}
		AbstractXmlElementGenerator elementGenerator = new VirtualDeleteByExampleElementGenerator(true);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
	}

	protected void addVirtualDeleteByPrimaryKeyElement(XmlElement parentElement) {
		if (!"true".equals(introspectedTable.getTableConfiguration().getProperty("createVirtualDelete"))) {
			return;
		}
		AbstractXmlElementGenerator elementGenerator = new VirtualDeleteByPrimaryKeyElementGenerator(true);
		initializeAndExecuteGenerator(elementGenerator, parentElement);
		
	}

}
