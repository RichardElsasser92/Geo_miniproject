package Application;
import java.util.ArrayList;

public class Country extends GovernedRegion{
	
	private static int highestID = -1;
	private final int countryID;
	private ArrayList<State> states = new ArrayList<State>();
	
	public Country(formOfGov gov, String name, String area, String population, String capital, String language) {
		super(area, population, gov, name, language, capital);
		this.countryID = getNextID();
		
	}
	
	// Method to get next available ID
	private int getNextID() {
		return ++highestID;
	}

	public State getStates(State states) {
		for(State s : this.states) {
			return s;
		}
		return states;
	}
	
	public void addState(String area, String country, String population, formOfGov gov, String name, String language, String capital) {
		State s = new State(gov, country,  name, area, population, capital, language);
		states.add(s);
		
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public int getCountryID() {
		return countryID;
	}
	


	
	
	
}
