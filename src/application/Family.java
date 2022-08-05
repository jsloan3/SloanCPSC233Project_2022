package application;

import java.util.ArrayList;

public class Family {
	
	private ArrayList<Person> peopleList;
	
	public Family() {
		this.clearPeopleList();
	}
	
	/** 
	 * Creates a fresh new ArrayList and uses a setter method to replace the old peopleList.
	 */
	public void clearPeopleList() {
		this.setPeopleList(new ArrayList<Person>());
	}
	
	/**
	 * Adds a new person onto the family, at the end of the ArrayList.
	 * @param currentPerson Person object to be added.
	 */
	
	public void addPersonToFamily(Person currentPerson) {
		this.getPeopleList().add(currentPerson);
	}
	
	/**
	 * peopleList getter method.
	 * @return peopleList
	 */

	public ArrayList<Person> getPeopleList() {
		return peopleList;
	}

	/**
	 * peopleList setter method. Private.
	 * @param peopleList to be set.
	 */
	private void setPeopleList(ArrayList<Person> peopleList) {
		this.peopleList = peopleList;
	}

}
