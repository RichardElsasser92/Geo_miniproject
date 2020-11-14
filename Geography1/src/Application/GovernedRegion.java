package Application;

abstract class GovernedRegion {

	private String area;
	private String population;
	public enum formOfGov {Democraty, Dictatorship, Republic};
	private formOfGov gov;
	private String name;
	private String language;
	private String capital;

	//Constructor
	public GovernedRegion(String area, String population, formOfGov gov, String name, String language, String capital) {
		super();
		this.area = area;
		this.population = population;
		this.gov = gov;
		this.name = name;
		this.language = language;
		this.capital = capital;
	}

	//GETTER AND SETTER
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public formOfGov getGov() {
		return gov;
	}

	public void setGov(formOfGov gov) {
		this.gov = gov;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
}
