package com.zzg.mybatis.generator.controller;

import com.zzg.mybatis.generator.bridge.MybatisGeneratorBridge;
import com.zzg.mybatis.generator.model.DatabaseConfig;
import com.zzg.mybatis.generator.model.GeneratorConfig;
import com.zzg.mybatis.generator.model.UITableColumnVO;
import com.zzg.mybatis.generator.util.ConfigHelper;
import com.zzg.mybatis.generator.util.DbUtil;
import com.zzg.mybatis.generator.util.MyStringUtils;
import com.zzg.mybatis.generator.view.AlertUtil;
import com.zzg.mybatis.generator.view.UIProgressCallback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.util.Callback;

import org.apache.commons.collections.set.SynchronizedSet;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.mybatis.generator.config.ColumnOverride;
import org.mybatis.generator.config.IgnoredColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUIController extends BaseFXController {

	private static final Logger _LOG = LoggerFactory.getLogger(MainUIController.class);
	private static final String FOLDER_NO_EXIST = "部分目录不存在，是否创建";
	// tool bar buttons
	@FXML
	private Label connectionLabel;
	@FXML
	private Label configsLabel;
	@FXML
	private TextField modelTargetPackage;
	@FXML
	private TextField mapperTargetPackage;
	@FXML
	private TextField daoTargetPackage;
	@FXML
	private TextField tableNameField;
	@FXML
	private TextField domainObjectNameField;
	@FXML
	private TextField generateKeysField; // 添加输入框
	@FXML
	private TextField modelTargetProject;
	@FXML
	private TextField mappingTargetProject;
	@FXML
	private TextField daoTargetProject;
	@FXML
	private TextField mapperName;
	@FXML
	private TextField projectFolderField;
	@FXML
	private CheckBox offsetLimitCheckBox;
	@FXML
	private CheckBox commentCheckBox;
	@FXML
	private CheckBox needToStringHashcodeEquals;
	@FXML
	private CheckBox annotationCheckBox;
	@FXML
	private CheckBox useActualColumnNamesCheckbox;
	@FXML
	private TreeView<String> leftDBTree;
	@FXML
	private TextField filterTableField;
	@FXML
	private CheckBox createBaseExpCheckBox;
	@FXML
	private CheckBox createIndexMethodCheckBox;
	@FXML
	private CheckBox overwriteExtFilesCheckBox;
	@FXML
	private CheckBox createVirtualDeleteCheckBox;
	@FXML
	private TextField virtualDeleteSqlFeild;
	@FXML
	private TextField exampleNameField;
	@FXML
	private TextField exampleTargetPackage;
	@FXML
	private TextField exampleTargetProject;

	@FXML
	private TextField modelNamePostfix;
	@FXML
	private TextField mapperNamePostfix;
	@FXML
	private TextField mappingFilePostfix;

	@FXML
	private CheckBox supportLombokCheckBox;

	
	// Current selected databaseConfig
	private DatabaseConfig selectedDatabaseConfig;
	// Current selected tableName
	private String tableName;

	private List<IgnoredColumn> ignoredColumns;

	private List<ColumnOverride> columnOverrides;

	private String configName;

	private TreeMap<String, List<String>> tableNameMap = new TreeMap<String, List<String>>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ImageView dbImage = new ImageView("icons/computer.png");
		dbImage.setFitHeight(40);
		dbImage.setFitWidth(40);
		connectionLabel.setGraphic(dbImage);
		connectionLabel.setOnMouseClicked(event -> {
			DbConnectionController controller = (DbConnectionController) loadFXMLPage("新建数据库连接",
					FXMLPage.NEW_CONNECTION, false);
			controller.setMainUIController(this);
			controller.showDialogStage();
		});
		ImageView configImage = new ImageView("icons/config-list.png");
		configImage.setFitHeight(40);
		configImage.setFitWidth(40);
		configsLabel.setGraphic(configImage);
		configsLabel.setOnMouseClicked(event -> {
			GeneratorConfigController controller = (GeneratorConfigController) loadFXMLPage("配置",
					FXMLPage.GENERATOR_CONFIG, false);
			controller.setMainUIController(this);
			controller.showDialogStage();
		});

		leftDBTree.setShowRoot(false);
		leftDBTree.setRoot(new TreeItem<>());
		Callback<TreeView<String>, TreeCell<String>> defaultCellFactory = TextFieldTreeCell.forTreeView();
		leftDBTree.setCellFactory((TreeView<String> tv) -> {
			TreeCell<String> cell = defaultCellFactory.call(tv);
			cell.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				int level = leftDBTree.getTreeItemLevel(cell.getTreeItem());
				TreeCell<String> treeCell = (TreeCell<String>) event.getSource();
				TreeItem<String> treeItem = treeCell.getTreeItem();
				if (level == 1) {
					final ContextMenu contextMenu = new ContextMenu();
					MenuItem item1 = new MenuItem("关闭连接");
					item1.setOnAction(event1 -> treeItem.getChildren().clear());
					MenuItem item2 = new MenuItem("编辑连接");
					item2.setOnAction(event1 -> {
						DatabaseConfig selectedConfig = (DatabaseConfig) treeItem.getGraphic().getUserData();
						DbConnectionController controller = (DbConnectionController) loadFXMLPage("编辑数据库连接",
								FXMLPage.NEW_CONNECTION, false);
						controller.setMainUIController(this);
						controller.setConfig(selectedConfig);
						controller.showDialogStage();
					});
					MenuItem item3 = new MenuItem("删除连接");
					item3.setOnAction(event1 -> {
						DatabaseConfig selectedConfig = (DatabaseConfig) treeItem.getGraphic().getUserData();
						try {
							ConfigHelper.deleteDatabaseConfig(selectedConfig);
							this.loadLeftDBTree();
						} catch (Exception e) {
							AlertUtil.showErrorAlert("Delete connection failed! Reason: " + e.getMessage());
						}
					});
					contextMenu.getItems().addAll(item1, item2, item3);
					cell.setContextMenu(contextMenu);
				}
				if (event.getClickCount() == 2) {
					treeItem.setExpanded(true);
					if (level == 1) {
						System.out.println("index: " + leftDBTree.getSelectionModel().getSelectedIndex());
						DatabaseConfig selectedConfig = (DatabaseConfig) treeItem.getGraphic().getUserData();
						try {
							List<String> tables = DbUtil.getTableNames(selectedConfig);
							tableNameMap.put(selectedConfig.getName(), tables);
							if (tables != null && tables.size() > 0) {
								ObservableList<TreeItem<String>> children = cell.getTreeItem().getChildren();
								initTableTree(children, tables);
							}
						} catch (SQLRecoverableException e) {
							_LOG.error(e.getMessage(), e);
							AlertUtil.showErrorAlert("连接超时");
						} catch (Exception e) {
							_LOG.error(e.getMessage(), e);
							AlertUtil.showErrorAlert(e.getMessage());
						}
					} else if (level == 2) { // left DB tree level3
						String tableName = treeCell.getTreeItem().getValue();
						selectedDatabaseConfig = (DatabaseConfig) treeItem.getParent().getGraphic().getUserData();
						this.tableName = tableName;
						tableNameField.setText(tableName);
						domainObjectNameField.setText(MyStringUtils.dbStringToCamelStyle(tableName));
					}
				}
			});
			return cell;
		});
		loadLeftDBTree();
		loadDisPostConfig();
	}

	void initTableTree(ObservableList<TreeItem<String>> children, List<String> tables) {
		if (tables == null) {
			return;
		}
		children.clear();
		for (String tableName : tables) {
			TreeItem<String> newTreeItem = new TreeItem<>();
			ImageView imageView = new ImageView("icons/table.png");
			imageView.setFitHeight(16);
			imageView.setFitWidth(16);
			newTreeItem.setGraphic(imageView);
			newTreeItem.setValue(tableName);
			children.add(newTreeItem);
		}
	}

	void loadLeftDBTree() {
		TreeItem rootTreeItem = leftDBTree.getRoot();
		rootTreeItem.getChildren().clear();
		try {
			List<DatabaseConfig> dbConfigs = ConfigHelper.loadDatabaseConfig();
			for (DatabaseConfig dbConfig : dbConfigs) {
				TreeItem<String> treeItem = new TreeItem<>();
				treeItem.setValue(dbConfig.getName());
				ImageView dbImage = new ImageView("icons/computer.png");
				dbImage.setFitHeight(16);
				dbImage.setFitWidth(16);
				dbImage.setUserData(dbConfig);
				treeItem.setGraphic(dbImage);
				rootTreeItem.getChildren().add(treeItem);
			}
		} catch (Exception e) {
			_LOG.error("connect db failed, reason: {}", e);
			AlertUtil.showErrorAlert(e.getMessage() + "\n" + ExceptionUtils.getStackTrace(e));
		}
	}

	void loadDisPostConfig() {
		GeneratorConfig generatorConfig;
		try {
			generatorConfig = ConfigHelper.loadSysConfig("DisPostConfig");
			setGeneratorConfigIntoUI(generatorConfig);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AlertUtil.showErrorAlert(e.getMessage() + "\n" + ExceptionUtils.getStackTrace(e));
		}
	}

	@FXML
	public void chooseProjectFolder() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedFolder = directoryChooser.showDialog(getPrimaryStage());
		if (selectedFolder != null) {
			projectFolderField.setText(selectedFolder.getAbsolutePath());
		}
	}

	@FXML
	public void setVirtualEnable() {
		virtualDeleteSqlFeild.setDisable(!createVirtualDeleteCheckBox.isSelected());
	}
	
	@FXML
	public void supporLombokEnable() {
		needToStringHashcodeEquals.setDisable(!supportLombokCheckBox.isSelected());
	}
	@FXML
	public void filterTableName() {
		String filterTab = this.filterTableField.getText().trim();

		TreeItem<String> items = leftDBTree.getTreeItem(2);
		TreeItem rootTreeItem = leftDBTree.getRoot();
		int dbSize = rootTreeItem.getChildren().size();
		for (int i = 0; i < dbSize; i++) {

			ObservableList<TreeItem<String>> childrens = rootTreeItem.getChildren();
			DatabaseConfig selectedConfig = (DatabaseConfig) childrens.get(i).getGraphic().getUserData();
			String dbkey = selectedConfig.getName();
			List<String> tableList = tableNameMap.get(dbkey);
			if (tableList == null) {
				continue;
			}
			ObservableList<TreeItem<String>> childrens2 = childrens.get(i).getChildren();
			if (filterTab.equals("")) {

				initTableTree(childrens2, tableList);
			}
			// else {
			List<String> tableList2 = new ArrayList<>(tableList);
			//// Collections.copy(tableList2, tableList);
			String regEX = "[+%#&=()]";
			Pattern p = Pattern.compile(regEX);
			Matcher m = p.matcher(filterTab);
			String filterStr = m.replaceAll("").trim();

			String pattern = filterStr.replaceAll("\\*", ".\\*");
			pattern = pattern.startsWith(".*") ? pattern : (".*" + pattern);
			pattern = pattern.endsWith(".*") ? pattern : (pattern + ".*");
			final String pattern2 = pattern;
			tableList2.removeIf(new Predicate<String>() {
				@Override
				public boolean test(String t) {
					Pattern p2 = Pattern.compile(pattern2, Pattern.CASE_INSENSITIVE);
					return !p2.matcher(t).matches();
				}
			});
//			
//			childrens2.forEach(new Consumer<TreeItem<String>>() {
//
//				@Override
//				public void accept(TreeItem<String> t) {
//					Pattern p2 = Pattern.compile(pattern2, Pattern.CASE_INSENSITIVE);
//					if(!p2.matcher(t.getValue()).matches()) {
////						t.getGraphic().setVisible(false);
////						t.setValue(null);
//					}
//					
//				}
//				
//			});
//			System.out.println(tableList2.size());
			initTableTree(childrens2, tableList2);
			// }

		}
		// ObservableList<TreeItem<String>> children =
		// leftDBTree.getTreeItem(0).getChildren();
		// System.out.println(children.size());
	}

	@FXML
	public void generateCode() {
		if (tableName == null) {
			AlertUtil.showWarnAlert("请先在左侧选择数据库表");
			return;
		}
		String result = validateConfig();
		if (result != null) {
			AlertUtil.showErrorAlert(result);
			return;
		}
		GeneratorConfig generatorConfig = getGeneratorConfigFromUI();
		if (!checkDirs(generatorConfig)) {
			return;
		}

		MybatisGeneratorBridge bridge = new MybatisGeneratorBridge();
		bridge.setGeneratorConfig(generatorConfig);
		bridge.setDatabaseConfig(selectedDatabaseConfig);
		bridge.setIgnoredColumns(ignoredColumns);
		bridge.setColumnOverrides(columnOverrides);
		UIProgressCallback alert = new UIProgressCallback(Alert.AlertType.INFORMATION);
		bridge.setProgressCallback(alert);
		alert.show();
		try {
			bridge.generate();
		} catch (Exception e) {
			e.printStackTrace();
			AlertUtil.showErrorAlert(e.getMessage());
		}
	}

	private String validateConfig() {
		String projectFolder = projectFolderField.getText();
		if (StringUtils.isEmpty(projectFolder)) {
			return "项目目录不能为空";
		}
		if (StringUtils.isEmpty(domainObjectNameField.getText())) {
			return "类名不能为空";
		}
		if (StringUtils.isAnyEmpty(modelTargetPackage.getText(), mapperTargetPackage.getText(),
				daoTargetPackage.getText())) {
			return "包名不能为空";
		}

		return null;
	}

	@FXML
	public void saveGeneratorConfig() {
		// TextInputDialog dialog = new TextInputDialog("");
		// dialog.setTitle("保存当前配置");
		// dialog.setContentText("请输入配置名称");
		// Optional<String> result = dialog.showAndWait();
		// if (result.isPresent()) {
		// String name = result.get();
		// if (StringUtils.isEmpty(name)) {
		// AlertUtil.showErrorAlert("名称不能为空");
		// return;
		// }
		// _LOG.info("user choose name: {}", name);
		// try {
		// GeneratorConfig generatorConfig = getGeneratorConfigFromUI();
		// generatorConfig.setName(name);
		// ConfigHelper.saveGeneratorConfig(generatorConfig);
		// } catch (Exception e) {
		// e.printStackTrace();
		// AlertUtil.showErrorAlert("删除配置失败");
		// }
		// }

		SaveConfigController controller = (SaveConfigController) loadFXMLPage("保存配置", FXMLPage.SAVE_CONFIG, false);
		controller.setMainUIController(this);
		controller.showDialogStage();
	}

	public GeneratorConfig getGeneratorConfigFromUI() {
		GeneratorConfig generatorConfig = new GeneratorConfig();
		generatorConfig.setName(this.getConfigName());
		generatorConfig.setProjectFolder(projectFolderField.getText());
		generatorConfig.setModelPackage(modelTargetPackage.getText());
		generatorConfig.setGenerateKeys(generateKeysField.getText());
		generatorConfig.setModelPackageTargetFolder(modelTargetProject.getText());
		generatorConfig.setDaoPackage(daoTargetPackage.getText());
		generatorConfig.setDaoTargetFolder(daoTargetProject.getText());
		// generatorConfig.setMapperName(mapperName.getText());
		generatorConfig.setModelNamePostfix(modelNamePostfix.getText());
		generatorConfig.setMapperNamePostfix(mapperNamePostfix.getText());
		generatorConfig.setMappingFilePostfix(mappingFilePostfix.getText());
		generatorConfig.setMappingXMLPackage(mapperTargetPackage.getText());
		generatorConfig.setMappingXMLTargetFolder(mappingTargetProject.getText());
		generatorConfig.setTableName(tableNameField.getText());
		generatorConfig.setDomainObjectName(domainObjectNameField.getText());
		generatorConfig.setOffsetLimit(offsetLimitCheckBox.isSelected());
		generatorConfig.setComment(commentCheckBox.isSelected());
		generatorConfig.setNeedToStringHashcodeEquals(needToStringHashcodeEquals.isSelected());
		generatorConfig.setAnnotation(annotationCheckBox.isSelected());
		generatorConfig.setUseActualColumnNames(useActualColumnNamesCheckbox.isSelected());
		generatorConfig.setCreateBaseExp(createBaseExpCheckBox.isSelected());
		generatorConfig.setCreateIndexMethod(createIndexMethodCheckBox.isSelected());
		generatorConfig.setOverwriteExtFiles(overwriteExtFilesCheckBox.isSelected());
		generatorConfig.setCreateVirtualDelete(createVirtualDeleteCheckBox.isSelected());
		generatorConfig.setVirtualDeleteSql(virtualDeleteSqlFeild.getText());
		generatorConfig.setExampleName(exampleNameField.getText());
		generatorConfig.setExampleTargetPackage(exampleTargetPackage.getText());
		generatorConfig.setExampleTargetProject(exampleTargetProject.getText());
		generatorConfig.setSupportLombok(supportLombokCheckBox.isSelected());
		return generatorConfig;
	}

	public void setGeneratorConfigIntoUI(GeneratorConfig generatorConfig) {
		projectFolderField.setText(generatorConfig.getProjectFolder());
		modelTargetPackage.setText(generatorConfig.getModelPackage());
		generateKeysField.setText(generatorConfig.getGenerateKeys());
		modelTargetProject.setText(generatorConfig.getModelPackageTargetFolder());
		daoTargetPackage.setText(generatorConfig.getDaoPackage());
		daoTargetProject.setText(generatorConfig.getDaoTargetFolder());
		mapperTargetPackage.setText(generatorConfig.getMappingXMLPackage());
		mappingTargetProject.setText(generatorConfig.getMappingXMLTargetFolder());
		offsetLimitCheckBox.setSelected(generatorConfig.isOffsetLimit());
		commentCheckBox.setSelected(generatorConfig.isComment());
		needToStringHashcodeEquals.setSelected(generatorConfig.isNeedToStringHashcodeEquals());
		annotationCheckBox.setSelected(generatorConfig.isAnnotation());
		useActualColumnNamesCheckbox.setSelected(generatorConfig.isUseActualColumnNames());
		createBaseExpCheckBox.setSelected(generatorConfig.isCreateBaseExp());
		createIndexMethodCheckBox.setSelected(generatorConfig.isCreateIndexMethod());
		overwriteExtFilesCheckBox.setSelected(generatorConfig.isOverwriteExtFiles());
		createVirtualDeleteCheckBox.setSelected(generatorConfig.isCreateVirtualDelete());
		virtualDeleteSqlFeild.setText(generatorConfig.getVirtualDeleteSql());
		exampleNameField.setText(generatorConfig.getExampleName());
		exampleTargetPackage.setText(generatorConfig.getExampleTargetPackage());
		exampleTargetProject.setText(generatorConfig.getExampleTargetProject());
		modelNamePostfix.setText(generatorConfig.getModelNamePostfix());
		mapperNamePostfix.setText(generatorConfig.getMapperNamePostfix());
		mappingFilePostfix.setText(generatorConfig.getMappingFilePostfix());
		supportLombokCheckBox.setSelected(generatorConfig.isSupportLombok());
		setConfigName(generatorConfig.getName());
	}

	@FXML
	public void openTableColumnCustomizationPage() {
		if (tableName == null) {
			AlertUtil.showWarnAlert("请先在左侧选择数据库表");
			return;
		}
		SelectTableColumnController controller = (SelectTableColumnController) loadFXMLPage("定制列",
				FXMLPage.SELECT_TABLE_COLUMN, true);
		controller.setMainUIController(this);
		try {
			// If select same schema and another table, update table data
			if (!tableName.equals(controller.getTableName())) {
				List<UITableColumnVO> tableColumns = DbUtil.getTableColumns(selectedDatabaseConfig, tableName);
				controller.setColumnList(FXCollections.observableList(tableColumns));
				controller.setTableName(tableName);
			}
			controller.showDialogStage();
		} catch (Exception e) {
			_LOG.error(e.getMessage(), e);
			AlertUtil.showErrorAlert(e.getMessage());
		}
	}

	public void setIgnoredColumns(List<IgnoredColumn> ignoredColumns) {
		this.ignoredColumns = ignoredColumns;
	}

	public void setColumnOverrides(List<ColumnOverride> columnOverrides) {
		this.columnOverrides = columnOverrides;
	}

	/**
	 * 检查并创建不存在的文件夹
	 *
	 * @return
	 */
	private boolean checkDirs(GeneratorConfig config) {
		List<String> dirs = new ArrayList<>();
		dirs.add(config.getProjectFolder());
		dirs.add(FilenameUtils
				.normalize(config.getProjectFolder().concat("/").concat(config.getModelPackageTargetFolder())));
		dirs.add(FilenameUtils.normalize(config.getProjectFolder().concat("/").concat(config.getDaoTargetFolder())));
		dirs.add(FilenameUtils
				.normalize(config.getProjectFolder().concat("/").concat(config.getMappingXMLTargetFolder())));
		boolean haveNotExistFolder = false;
		for (String dir : dirs) {
			File file = new File(dir);
			if (!file.exists()) {
				haveNotExistFolder = true;
			}
		}
		if (haveNotExistFolder) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setContentText(FOLDER_NO_EXIST);
			Optional<ButtonType> optional = alert.showAndWait();
			if (optional.isPresent()) {
				if (ButtonType.OK == optional.get()) {
					try {
						for (String dir : dirs) {
							FileUtils.forceMkdir(new File(dir));
						}
						return true;
					} catch (Exception e) {
						AlertUtil.showErrorAlert("创建目录失败，请检查目录是否是文件而非目录");
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

}
