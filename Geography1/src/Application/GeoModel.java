package Application;

import javafx.beans.property.SimpleObjectProperty;

public class GeoModel {
	private final SimpleObjectProperty<Country> countryProperty = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<State> stateProperty = new SimpleObjectProperty<>();
	
	//For Country
	public void saveCountry(Country.formOfGov gov, String name, String area, String capital, String population, String language) {
		countryProperty.set(new Country(gov, name, area, population, capital, language));
	}
	
	public void deleteCountry() {
		countryProperty.set(null);
	}
	
	public Country getCountry() {
		return countryProperty.get();
	}
	
	public SimpleObjectProperty<Country> countryProperty() {
		return countryProperty;
	}
	
	//For State
	public void saveState(State.formOfGov gov, String country, String name, String area, String capital, String population, String language) {
		stateProperty.set(new State(gov, country, name, area, population, capital, language));
	}
	
	public void deleteState() {
		stateProperty.set(null);
	}
	
	public State getState() {
		return stateProperty.get();
	}
	
	public SimpleObjectProperty<State> stateProperty() {
		return stateProperty;
	}

}
