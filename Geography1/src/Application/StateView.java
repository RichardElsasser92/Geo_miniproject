package Application;

import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Application.GovernedRegion.formOfGov;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class StateView extends Stage {
	private GeoModel model;
	public CountryView view;

	// Conrols used for data processing
	TextField txtNameState = new TextField();
	TextField txtAreaState = new TextField();
	TextField txtCapitalState = new TextField();
	TextField txtPopulationState = new TextField();
	TextField txtLanguageState = new TextField();
	TextField txtCountryState = new TextField();

	Label lblDataNameState = new Label();
	Label lblDataAreaState = new Label();
	Label lblDataCapitalState = new Label();
	Label lblDataPopState = new Label();
	Label lblDataLangState = new Label();
	Label lblDataCountryState = new Label();

	// Buttons
	Button btnSaveState = new Button ("Save");
	Button btnSaveFile = new Button ("Save to File");
	Button btnDeleteState = new Button ("Delete");

	public StateView(GeoModel model) {
		this.model = model;

		VBox root1 = new VBox();
		root1.getChildren().add(createDataEntryPaneState());
		root1.getChildren().add(createControlPaneState());
		root1.getChildren().add(createDataDisplayPaneState());

		//Standard stuff for the first Scene and Stage
		Scene scene = new Scene(root1, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		setTitle("Geo Miniproject");
		setScene(scene);
		setX(60);
		setY(20);
	}

	public Pane createDataEntryPaneState() {
		GridPane pane = new GridPane();
		pane.setId("dataEntry");
		//Declare the individual controls in the GUI
		Label lblNameState = new Label("State Name");
		Label lblAreaState = new Label("Area");
		Label lblCapitalState = new Label("Capital");
		Label lblPopState = new Label("Population");
		Label lblLangState = new Label("Language");

		//Organize the layout, add in the controls (col, row)
		pane.add(lblNameState, 0, 0); pane.add(txtNameState, 1, 0);
		pane.add(lblAreaState, 0, 1); pane.add(txtAreaState, 1, 1);
		pane.add(lblCapitalState, 0, 2); pane.add(txtCapitalState, 1, 2);
		pane.add(lblPopState, 0, 3); pane.add(txtPopulationState, 1, 3);
		pane.add(lblLangState, 0, 4); pane.add(txtLanguageState, 1, 4);


		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		//pane.setPadding(new Insets(25,25,25,25));

		return pane;
	}

	private Pane createControlPaneState() {
		GridPane pane = new GridPane();
		pane.setId("ControlArea");
		pane.add(btnSaveState, 0, 0);
		pane.add(btnDeleteState, 1, 0);
		pane.add(btnSaveFile, 2, 0);


		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);

		return pane;
	}

	private Pane createDataDisplayPaneState() {
		GridPane pane = new GridPane();
		pane.setId("dataDisplay");
		//Declare the individual controls in the GUI
		Label lblNameState = new Label("State Name");
		Label lblAreaState = new Label("Area");
		Label lblCapitalState = new Label("Capital");
		Label lblPopState = new Label("Population");
		Label lblLangState = new Label("Language");
		Label lblCountryState = new Label("Country");

		// Organize the layout, add in the controls (col, now)
		pane.add(lblNameState, 0, 0); pane.add(lblDataNameState, 1, 0);
		pane.add(lblAreaState, 0, 1); pane.add(lblDataAreaState, 1, 1);
		pane.add(lblCapitalState, 0, 2); pane.add(lblDataCapitalState, 1, 2);
		pane.add(lblPopState, 0, 3); pane.add(lblDataPopState, 1, 3);
		pane.add(lblLangState, 0, 4); pane.add(lblDataLangState, 1, 4);
		pane.add(lblCountryState, 0, 5); pane.add(lblDataCountryState, 1, 5);

		pane.setAlignment(Pos.BOTTOM_CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		return pane;
	}


	








}
