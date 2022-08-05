package application;

import java.util.ArrayList;

public class Family {
	
	private ArrayList<Person> peopleList;
	
	public Family() {
		this.clearPeopleList();
	}
	
	public void clearPeopleList() {
		this.setPeopleList(new ArrayList<Person>());
	}
	
	public void addPersonToFamily(Person currentPerson) {
		this.getPeopleList().add(currentPerson);
	}

	ArrayList<Person> getPeopleList() {
		return peopleList;
	}

	private void setPeopleList(ArrayList<Person> peopleList) {
		this.peopleList = peopleList;
	}

}
