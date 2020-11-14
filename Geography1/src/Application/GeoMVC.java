package Application;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class GeoMVC extends Application {
	
	private CountryView view;
	private StateView stateV;
	private GeoModel model;
	private GeoController controller;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primary) throws Exception {
		model = new GeoModel();
		view = new CountryView(model);
		stateV = new StateView(model);
		controller = new GeoController(model, view, stateV);
		
		view.btnEnterState.setOnAction(D -> {
			stateV.show();
		});
		
		view.show();
	
	}
	
	
}
