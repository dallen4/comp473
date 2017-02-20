package view;

import model.facility.Facilities;
import model.facility.Facility;
import model.maintenance.Maintenance;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting Facility Management System... \n");

		// Creating our facilities 'Loyola'
		Facilities Loyola = new Facilities();

		// Creating our first facility 'Damen'
		Facility Damen = new Facility(1, "Damen", 100);
		Facility Corboy = new Facility(2, "Corboy", 800);

		// Adding Damen to the Loyola facilities list
		Loyola.addNewFacility(Damen);
		Loyola.addNewFacility(Corboy);

		// Testing listFacilities() method
		Loyola.listFacilities();
		System.out.println("");
		
		// Testing getFacilityInformation method
		Damen.getFacilityInformation();
		System.out.println("");
		Corboy.getFacilityInformation();
		System.out.println("");

		// Creating a Maintenance object for Damen
		Maintenance DamenMaint = new Maintenance(1, "Damen");
		// Adding a facility request and printing it
		System.out.println("Creating Facility Maintenance Request...");
		DamenMaint.makeFacilityMaintRequest("Broken Sink");
		System.out.println("");
		
		System.out.println("Listing Facility Problems for Facility " + Damen.getID() + ": \n");
		DamenMaint.listFacilityProblems();


	}

}
