package Application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.sun.glass.ui.Window;

import Application.GovernedRegion.formOfGov;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GeoController {
	private CountryView view;
	private StateView stateV;
	private GeoModel model;




	public GeoController(GeoModel model, CountryView view, StateView stateV) {
		this.model = model;
		this.view = view;
		this.stateV = stateV;

		//-- For Country --
		view.btnSave.setOnAction(this::save);
		view.btnDelete.setOnAction(this::delete);


		view.btnDelete.disableProperty().bind(model.countryProperty().isNull());
		view.btnSave.disableProperty().bind(view.txtName.textProperty().isEmpty());
		view.btnEnterState.setDisable(true); // disabled Button, because you can only enter State when the form is filled and saved

		//-- For State --
		stateV.btnSaveState.setOnAction(this::saveState);
		stateV.btnDeleteState.setOnAction(this::deleteState);
		stateV.btnSaveFile.setOnAction(this::saveToFile);
	}


	private void save(ActionEvent e) {
		formOfGov gov = view.cmbgovForm.getValue();
		String name = view.txtName.getText();
		String area = view.txtArea.getText();
		String capital = view.txtCapital.getText();
		String population = view.txtPopulation.getText();
		String language = view.txtLanguage.getText();
		if (gov != null && name != null && name.length() > 0 && area != null && area.length() > 0 && capital != null && capital.length() > 0 && 
				population != null && population.length() > 0 && language != null && language.length() > 0) {
			model.saveCountry(gov, name, area, capital, population, language);
			updateView(model.getCountry());
			// Show Button "Enter State" after Country is saved
			view.btnEnterState.setDisable(false);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error!");
			alert.setContentText("Please fill it!");
			alert.showAndWait();
		}
	}

	private void delete(ActionEvent e) {
		model.deleteCountry();
		updateView(model.getCountry());
		view.btnEnterState.setDisable(true);
	}

	private void updateView(Country country) {
		if (country != null) {
			view.lblDataID.setText(Integer.toString(country.getCountryID()));
			view.lblDatagovForm.setText(country.getGov().toString());
			view.lblDataName.setText(country.getName());
			view.lblDataArea.setText(country.getArea());
			view.lblDataCapital.setText(country.getArea());
			view.lblDataCapital.setText(country.getCapital());
			view.lblDataPop.setText(country.getPopulation());
			view.lblDataLang.setText(country.getLanguage());	
		} else {
			view.lblDataID.setText("");
			view.lblDatagovForm.setText("");
			view.lblDataName.setText("");
			view.lblDataArea.setText("");
			view.lblDataCapital.setText("");
			view.lblDataCapital.setText("");
			view.lblDataPop.setText("");
			view.lblDataLang.setText("");	
		}

	}

	//-- For State --

	private void saveState(ActionEvent e) {
		formOfGov govState = view.cmbgovForm.getValue();
		String nameState = stateV.txtNameState.getText();
		String areaState = stateV.txtAreaState.getText();
		String capitalState = stateV.txtCapitalState.getText();
		String populationState = stateV.txtPopulationState.getText();
		String languageState = stateV.txtLanguageState.getText();
		String CountryState = stateV.txtCountryState.getText();
		if (govState != null && nameState != null && nameState.length() > 0 && areaState != null && areaState.length() > 0 && capitalState != null && capitalState.length() > 0 && 
				populationState != null && populationState.length() > 0 && languageState != null && languageState.length() > 0) {
			model.saveState(govState, CountryState, nameState, areaState, capitalState, populationState, languageState);
			updateViewState(model.getState());
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error!");
			alert.setContentText("Please fill it!");
			alert.showAndWait();
		}
	}
	
	private void deleteState(ActionEvent e) {
		stateV.lblDataCountryState.textProperty().unbind();
		model.deleteState();
		updateViewState(model.getState());
	}
	
	private void saveToFile(ActionEvent e) {
		File recordsDir = new File(System.getProperty("states.txt"), "./Geography1");
		if (! recordsDir.exists()) {
			recordsDir.mkdirs();
		}
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(recordsDir);
		
		String nameState = stateV.txtNameState.getText();
		String areaState = stateV.txtAreaState.getText();
		String capitalState = stateV.txtCapitalState.getText();
		String populationState = stateV.txtPopulationState.getText();
		String languageState = stateV.txtLanguageState.getText();
		String CountryState = stateV.txtCountryState.getText();
		
		try {
			fileChooser.setTitle("Save Dialog");
			fileChooser.setInitialFileName("states");
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("states.txt"));
			writer.write(nameState);
			writer.newLine();
			writer.write(areaState);
			writer.newLine();
			writer.write(capitalState);
			writer.newLine();
			writer.write(populationState);
			writer.newLine();
			writer.write(languageState);
			writer.newLine();
			writer.write(CountryState);
			writer.newLine();
			writer.close();
			
			File file = fileChooser.showSaveDialog(stateV);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void updateViewState(State state) {
		if (state != null) {
			stateV.lblDataNameState.setText(state.getName());
			stateV.lblDataAreaState.setText(state.getArea());
			stateV.lblDataCapitalState.setText(state.getCapital());
			stateV.lblDataPopState.setText(state.getPopulation());
			stateV.lblDataLangState.setText(state.getLanguage());
			stateV.lblDataCountryState.textProperty().bind(view.txtName.textProperty());
		} else {
			//view.lblDatagovForm.setText(state.getGov().toString());
			stateV.lblDataNameState.setText("");
			stateV.lblDataAreaState.setText("");
			stateV.lblDataCapitalState.setText("");
			stateV.lblDataPopState.setText("");
			stateV.lblDataLangState.setText("");
			stateV.lblDataCountryState.setText("");
		}

	}
}
