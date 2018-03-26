package com.zzg.mybatis.generator.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.zzg.mybatis.generator.model.GeneratorConfig;
import com.zzg.mybatis.generator.util.ConfigHelper;
import com.zzg.mybatis.generator.view.AlertUtil;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class SaveConfigController extends BaseFXController {

	private MainUIController mainUIController;

	private SaveConfigController controller;

	@FXML
	private ComboBox<GeneratorConfig> configNameComboBox;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = this;

		configNameComboBox.setCellFactory(combox -> {
			return new ListCell<GeneratorConfig>() {
				@Override
				protected void updateItem(GeneratorConfig item, boolean empty) {
					super.updateItem(item, empty);
//					System.out.println("updateItem:" + configNameComboBox.getValue());
					if (empty) {
						setText("");
					} else {
						setText(item.getName());
					}
				}

			};
		});
		configNameComboBox.setConverter(new StringConverter<GeneratorConfig>() {

			@Override
			public String toString(GeneratorConfig object) {
				return object == null ? "" : object.getName();
			}

			@Override
			public GeneratorConfig fromString(String string) {
				return null;
			}

		});

		refreshTableView();
	}

	public void refreshTableView() {
		try {
			List<GeneratorConfig> configs = ConfigHelper.loadUserConfigs();
			configs.sort(new Comparator<GeneratorConfig>() {

				@Override
				public int compare(GeneratorConfig o1, GeneratorConfig o2) {
					
					return o1.getName().compareTo(o2.getName());
				}
				
			}); 
			configNameComboBox.setItems(FXCollections.observableList(configs));

		} catch (Exception e) {
			AlertUtil.showErrorAlert(e.getMessage());
		}
	}

	void setMainUIController(MainUIController mainUIController) {
		this.mainUIController = mainUIController;
		configNameComboBox.getEditor().setText(mainUIController.getConfigName());
	}

	@FXML
	void cancel() {
		getDialogStage().close();
	}

	@FXML
	void saveConfirm() {
	
		// System.out.println("saveConfirm:"+configNameComboBox.getItems());
		GeneratorConfig generatorConfig = mainUIController.getGeneratorConfigFromUI();

		// System.out.println(configNameComboBox.getValue());
//		this.setConfigName(configNameComboBox.getEditor().getText().trim());
//		generatorConfig.setName(getConfigName());
		String configName=configNameComboBox.getEditor().getText().trim();
		generatorConfig.setName(configName);
		try {
			ConfigHelper.saveUserConfig(generatorConfig,true);
			refreshTableView();
			mainUIController.setConfigName(configName);
		} catch (Exception e) {
			AlertUtil.showErrorAlert(e.getMessage());
		}
		getDialogStage().close();
	}

	@FXML
	void selectConfigName() {
//		System.out.println("selectConfigName:" + configNameComboBox.getValue().getName());
	}


	
}
