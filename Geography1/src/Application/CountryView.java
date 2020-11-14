package Application;

import java.awt.Insets;

import Application.GovernedRegion.formOfGov;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountryView extends Stage{
	private GeoModel model;

	// Controls used for data processing-- COUNTRY
	TextField txtName = new TextField();
	TextField txtCountry = new TextField();
	TextField txtArea = new TextField();
	TextField txtCapital = new TextField();
	TextField txtPopulation = new TextField();
	TextField txtLanguage = new TextField();
	ComboBox<formOfGov> cmbgovForm = new ComboBox<>();
	Label lblDataID = new Label();
	Label lblDatagovForm = new Label();
	Label lblDataCountry = new Label();
	Label lblDataName = new Label();
	Label lblDataArea = new Label();
	Label lblDataCapital = new Label();
	Label lblDataPop = new Label();
	Label lblDataLang = new Label();



	// Buttons for Country
	Button btnSave = new Button ("Save");
	//Button btnSaveFile = new Button ("Save to File");
	Button btnDelete = new Button ("Delete");
	Button btnEnterState = new Button ("Enter State");


	public CountryView(GeoModel model) {
		this.model = model;

		VBox root1 = new VBox();
		root1.getChildren().add(createDataEntryPane());
		root1.getChildren().add(createControlPane());
		root1.getChildren().add(createDataDisplayPane());

		//Standard stuff for the Scene and Stage
		Scene scene = new Scene(root1, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		setTitle("Geo Miniproject");
		setScene(scene);
		show();
	}


	private Pane createDataEntryPane() {
		GridPane pane = new GridPane();
		pane.setId("dataEntry");
		//Declare the individual controls in the GUI
		Label lblGovForm = new Label ("Form of Goverment");
		Label lblName = new Label("Country Name");
		Label lblArea = new Label("Area");
		Label lblCapital = new Label("Capital");
		Label lblPop = new Label("Population");
		Label lblLang = new Label("Language");

		//Fill combos
		cmbgovForm.getItems().addAll(GovernedRegion.formOfGov.values());
		cmbgovForm.setValue(formOfGov.Democraty);
		cmbgovForm.setValue(formOfGov.Dictatorship);
		cmbgovForm.setValue(formOfGov.Republic);

		//Organize the layout, add in the controls (col, row)
		pane.add(lblGovForm, 0, 0); pane.add(cmbgovForm, 1, 0);
		pane.add(lblName, 0, 1); pane.add(txtName, 1, 1);
		pane.add(lblArea, 0, 2); pane.add(txtArea, 1, 2);
		pane.add(lblCapital, 0, 3); pane.add(txtCapital, 1, 3);
		pane.add(lblPop, 0, 4); pane.add(txtPopulation, 1, 4);
		pane.add(lblLang, 0, 5); pane.add(txtLanguage, 1, 5);

		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		//pane.setPadding(new Insets(25,25,25,25));

		return pane;
	}

	private Pane createControlPane() {
		GridPane pane = new GridPane();
		pane.setId("ControlArea");
		pane.add(btnSave, 0, 0);
		pane.add(btnDelete, 1, 0);
		pane.add(btnEnterState, 2, 0);

		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);

		return pane;
	}

	private Pane createDataDisplayPane() {
		GridPane pane = new GridPane();
		pane.setId("dataDisplay");
		//Declare the individual controls in the GUI
		Label lblID = new Label("ID");
		Label lblGovForm = new Label ("Form of Goverment");
		Label lblName = new Label("Country Name");
		Label lblArea = new Label("Area");
		Label lblCapital = new Label("Capital");
		Label lblPop = new Label("Population");
		Label lblLang = new Label("Language");

		// Organize the layout, add in the controls (col, now)
		pane.add(lblID, 0, 0);   pane.add(lblDataID, 1,0);
		pane.add(lblGovForm, 0, 1); pane.add(lblDatagovForm, 1, 1);
		pane.add(lblName, 0, 2); pane.add(lblDataName, 1, 2);
		pane.add(lblArea, 0, 3); pane.add(lblDataArea, 1, 3);
		pane.add(lblCapital, 0, 4); pane.add(lblDataCapital, 1, 4);
		pane.add(lblPop, 0, 5); pane.add(lblDataPop, 1, 5);
		pane.add(lblLang, 0, 6); pane.add(lblDataLang, 1, 6);

		pane.setAlignment(Pos.BOTTOM_CENTER);
		pane.setHgap(10);
		pane.setVgap(10);

		return pane;

	}


}
