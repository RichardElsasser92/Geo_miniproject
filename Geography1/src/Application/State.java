package Application;


public class State extends Country {
	
	//country Combobox
	//name
	//Kapital
	//Area
	//population
	//GetCountry
	
	private Country country;
	
	public State(formOfGov gov, String country, String name, String area, String population, String capital, String language) {
		super(gov, name, area, population, capital, language);
		this.country = getCountry();
	}

	public Country getCountry() {
		return country;
	}

	//public void setCountry(Country country) {
		//this.country = country;
	}

	
	

