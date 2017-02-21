package view;

import model.facility.Facilities;
import model.facility.Facility;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {

		Calendar calendar = new GregorianCalendar();

		System.out.println("Starting Facility Management System... \n");

		// Creating our facilities 'Loyola'
		Facilities Loyola = new Facilities();

		// Creating our first facilities 'Damen'
		System.out.println("Creating facilities... \n");
		Facility Damen = new Facility(1, "Damen", 100);
		Facility Corboy = new Facility(2, "Corboy", 800);
		
		
		
		//BEGIN TESTS OF FACILITY INTERFACE REQUIREMENTS
		System.out.println("Beginning tests for Facility interface functionality... \n");

		// Adding Damen to the Loyola facilities list
		System.out.println("Adding facilities to Facilities List...");
		if (Loyola.addNewFacility(Damen)) {
			System.out.println("Damen facility added successfully.");
		}
		
		if (Loyola.addNewFacility(Corboy)) {
			System.out.println("Corboy facility added successfully. \n");
		}

		// Testing listFacilities() method
		System.out.println("Listing Facility names...");
		Loyola.listFacilities();
		System.out.println("");
		
		// Testing getFacilityInformation method
		System.out.println("Retrieving Facility Information...");
		Damen.getFacilityInformation();
		System.out.println("");
		Corboy.getFacilityInformation();
		System.out.println("");
		
		
		//END TESTS OF FACILITY INTERFACE REQUIREMENTS
		
		
		
		
		//BEGIN TESTS OF MAINTENANCE INTERFACE REQUIREMENTS
		System.out.println("Beginning tests for Facility Maintenance interface functionality...");
		
//		TODO REDO
		// Adding a facility request and printing it
		Damen.makeFacilityMaintRequest(1,"Broken Sink");
		Damen.makeFacilityMaintRequest(2,"Speakers not working");
		System.out.println("Creating Facility Maintenance Request...");

		System.out.println("");
		
		//TEST listFacilityProblems()
		System.out.println("Displaying problems submitted via Maintenance Requests by Facility...");
		for (int i = 0; i < Loyola.getFacilities().size(); i++) {
			Facility temp = Loyola.getFacilities().get(i);
			System.out.println("Facility " + temp.getID() + ":");
			temp.listFacilityProblems();
		}
		
		System.out.println("");
		
				
		System.out.println("Listing Facility Maintenance Requests for Facility " + Damen.getID() + " " + Damen.getName() + ":");
		System.out.println(Damen.listMaintRequests());

		System.out.println("");

		// Schedule a maintenance request
		Damen.scheduleMaintenance(1, "201705031830");
		System.out.println(Damen.listMaintRequests());

		// Adding the cost of maintenance
		Damen.addNewCost(1,100);
		System.out.println(Damen.listMaintRequests());

		// Find total Cost
		System.out.println(Damen.calcMaintenanceCostForFacility());
		
		
		//TEST calcProblemRateForFacility()
		System.out.println("Calculating problem rate by Facility (ratio of problems & requests solved versus total...");
		for (int i = 0; i < Loyola.getFacilities().size(); i++) {
			Facility temp = Loyola.getFacilities().get(i);
			System.out.println("Facility " + temp.getID() + ":");
			temp.calcProblemRateForFacility();
		}
		
		//TEST calcDownTimeForFacility()
		
		
		//TEST listMaintenance()
		System.out.println("Listing all completed Maintenance by Facility...");
		for (int i = 0; i < Loyola.getFacilities().size(); i++) {
			Facility temp = Loyola.getFacilities().get(i);
			System.out.println("Facility " + temp.getID() + ":");
			temp.listMaintenance();
		}
		
		
		
		//END TESTS OF MAINTENANCE INTERFACE REQUIREMENTS
		
		
		
		
		//BEGIN TESTS OF USE INTERFACE REQUIREMENTS
		System.out.println("Beginning tests for Facility Use interface functionality...");
		
		//test isInUseDuringInterval()
		
		
		
		//test assignFacilityToUse()
		
		
		
		//test vacateFacility()
		System.out.println("Vacating all available facilities...");
		for (int i = 0; i < Loyola.getFacilities().size(); i++) {
			Facility temp = Loyola.getFacilities().get(i);
			System.out.println("Vacated Facility " + temp.getID());
			System.out.println("Current capacity: " + temp.getCurrCapacity());
		}
		
		//test listInspections()
		System.out.println("Printing all Inspections by Facility...");
		for (int i = 0; i < Loyola.getFacilities().size(); i++) {
			System.out.println("Facility " + Loyola.getFacilities().get(i).getID());
			Loyola.getFacilities().get(i).listInspections();
		}
		
		
		//test listActualUsage()
		
		
		
		//test calcUsageRate()
		
		
		
		//test completeMaintRequest()
		// Complete a maintenance request
		Damen.completeMaintRequest(1);
		System.out.println(Damen.listMaintRequests());
		
		//test addNewCost()
		
		
		
		//END TESTS OF USE INTERFACE REQUIREMENTS
	}

}
