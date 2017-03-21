package view;

import model.facility.Manager;
import model.facility.Facility;
import model.facility.IFacility;
import model.maintenance.IMaintenance;
import model.maintenance.Maintenance;
import model.use.FacilityUse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;

import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {

//		Calendar calendar = new GregorianCalendar();
//
//		System.out.println("Starting Facility Management System... \n");
//
//		// Creating our first Manager 'Damen'
//		System.out.println("Creating Manager... \n");
//
//		Manager Manager = new Manager();
//		Manager.setFacilityUse(new FacilityUse());
//		Manager.setFacilityMaintenance(new Maintenance());
//
//		IFacility Damen = new Facility(0,"Damen",200);
//		IFacility Corboy = new Facility(1,"Corboy", 150);
//		IFacility Cuneo = new Facility(2, "Cuneo", 175);
//
//		if (Manager.addNewFacility(new Facility(0,"Damen",200))) {
//			System.out.println(Damen.getFacility().getName() + " added successfully.");
//		}
//		if (Manager.addNewFacility(Corboy.getFacility())) {
//			System.out.println(Corboy.getFacility().getName() + " added successfully.");
//		}
//		if (Manager.addNewFacility(Cuneo.getFacility())) {
//			System.out.println(Cuneo.getFacility().getName() + " added successfully.");
//		}
//		Manager.listFacilities();
//
//		// Maintenence tests
//
//
//		Manager.getFacilityMaintenance().makeFacilityMaintRequest(0,0,"broken sink");
//
//		System.out.println("The current Maintenance requests are: \n");
//		Manager.getFacilityMaintenance().listMaintRequests();
//
//		System.out.println("Scheduling Maintenance Request\n");
//		Manager.getFacilityMaintenance().scheduleMaintenance(0,"201404030303");
//
//		System.out.println("The Maintenance Requests for facility 0 are:\n");
//		Manager.getFacilityMaintenance().listFacilityProblems(0);
//
//		Manager.getFacilityMaintenance().getRequests().get(0).setCompleted(0, true);
//
//		Manager.getFacilityMaintenance().calcProblemRateForFacility(0);
//
//		Manager.getFacilityMaintenance().calcDownTimeForFacility(0);
//
//		Manager.getFacilityMaintenance().calcMaintenanceCostForFacility(0);
//
//		System.out.println("Beginning tests of FacilityUse interface...");
//
//		//test assignFacilityToUse()
//		Manager.getFacilityUse().assignFacilityToUse("20170509", "Big Party", 1, 0);
//
//		//test isInUseDuringInterval()
//		System.out.println("Testing if facility is in use during assigned interval...");
//		Manager.getFacilityUse().isInUseDuringInterval(0,"20170509");
//
//		//test vacateFacility()
//
//		Manager.getFacilityUse().vacateFacility((Facility)Manager.getFacilities().get(0));
//
//		//test listInspections()
//		Manager.getFacilityUse().addInspection(0,"2017050","Charlie Jones",false,0);
//		Manager.getFacilityUse().listInspections(0);
//
//		//test listActualUsage()
//
//		Manager.getFacilityUse().listActualUsage(0);
//
//		//test calcUsageRate()
//
//		Manager.getFacilityUse().calcUsageRate(0);
//
//		//END TESTS OF USE INTERFACE REQUIREMENTS
//		System.out.println("ending program....");





		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

		Facility facility10 = (Facility) context.getBean("facility");
		System.out.println(facility10);

		Manager manager = (Manager)context.getBean("manager");

		System.out.println(manager);

		List<Facility> facilityList = manager.getFacilities();

		IFacility facility1 = (IFacility) context.getBean("facility");
		facility1.setID(0);
		facility1.setName("Damen");
		facility1.setCurrCapacity(250);
		facility1.setPotentialCapacity(500);
		List<String> Details = Arrays.asList("Hello","Damen Details of this building");
		facility1.setDetails(Details);

		System.out.println(facility1);

		IFacility facility2 = (IFacility) context.getBean("facility");
		facility2.setID(1);
		facility2.setName("Corboy");
		facility2.setCurrCapacity(150);
		facility2.setPotentialCapacity(1000);
		List<String> Details2 = Arrays.asList("goodbye","Corboy Details of this building");
		facility2.setDetails(Details2);

		IMaintenance maintenance = (IMaintenance) context.getBean("maintenance");

		System.out.println(maintenance);



	}

}
