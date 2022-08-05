package application;

import java.util.ArrayList;

public class Family {
	
	private ArrayList<Person> peopleList;
	
	public Family() {
		this.clearPeopleList();
	}
	
	private void clearPeopleList() {
		this.setPeopleList(new ArrayList<Person>());
	}

	private ArrayList<Person> getPeopleList() {
		return peopleList;
	}

	private void setPeopleList(ArrayList<Person> peopleList) {
		this.peopleList = peopleList;
	}

}
