package view;

import model.facility.Facilities;
import model.facility.Facility;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating our facilities 'Loyola'
		Facilities Loyola = new Facilities();

		// Creating our first facility 'Damen'
		Facility Damen = new Facility(1, "Damen", 100);
		Facility Corboy = new Facility(2, "Corboy", 800);

		// Adding Damen to the Loyola facilities list
		Loyola.addNewFacility(Damen);
		Loyola.addNewFacility(Corboy);

		// Testing out some of our methods
		Loyola.listFacilities();
		Damen.getFacilityInformation();
		Corboy.getFacilityInformation();


	}

}
