package view;

import model.facility.IInspection;
import model.facility.Manager;
import model.facility.Facility;
import model.facility.IFacility;
import model.maintenance.IMaintenance;
import model.maintenance.IRequest;
import model.maintenance.Request;
import model.maintenance.Maintenance;
import model.use.FacilityUse;
import model.use.IEvent;
import model.use.IFacilityUse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import java.util.Arrays;

import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) throws Exception {

         Calendar calendar = new GregorianCalendar();
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



		System.out.println("yo yo");

		ApplicationContext context;
		context = new ClassPathXmlApplicationContext("app-context.xml");

		Facility facility10 = (Facility) context.getBean("facility");
		System.out.println(facility10);

		Manager manager = (Manager)context.getBean("manager");

		System.out.println(manager);

		List<Facility> facilityList = manager.getFacilities();

		IFacility facility1 = (IFacility) context.getBean("facility");
		facility1.setID(1);
		facility1.setName("Damen");
		facility1.setCurrCapacity(250);
		facility1.setPotentialCapacity(500);
		List<String> Details = Arrays.asList("Hello","Damen Details of this building");
		facility1.setDetails(Details);

		System.out.println("Adding facility 1 to list...\n");

		facilityList.add((Facility)facility1);

		IFacility facility2 = (IFacility) context.getBean("facility");
		facility2.setID(2);
		facility2.setName("Corboy");
		facility2.setCurrCapacity(150);
		facility2.setPotentialCapacity(1000);
		List<String> Details2 = Arrays.asList("goodbye","Corboy Details of this building");
		facility2.setDetails(Details2);

		System.out.println("Adding facility 2 to list...\n");

		facilityList.add((Facility) facility2);

		System.out.println();
		facilityList.get(0).getFacilityInformation();
		System.out.println();
		facilityList.get(1).getFacilityInformation();
		System.out.println();
		facilityList.get(2).getFacilityInformation();
		System.out.println();

		System.out.println("\n\nBuilding Facility Maintenance objects...");

		//Instantiating Maintenance
		IMaintenance maintenance = (IMaintenance) context.getBean("maintenance");

		IRequest request1 = (IRequest) context.getBean("request");
		request1.setID(0);
		request1.setCompleted(false);
		request1.setCost(100);
		request1.setDateCreated("201404030303");
		request1.setDateScheduled("201404030303");
		request1.setDesc("Broken Sink");
		request1.setEstimatedWorkedTime(5);
		request1.setScheduled(true);

		System.out.println("Adding maintenance request 1 to request list...\n");

		maintenance.getMaintenance().getRequests().add((Request)request1);

		IRequest request2 = (IRequest) context.getBean("request");
		request2.setID(1);
		request2.setCompleted(true);
		request2.setCost(150);
		request2.setDateCreated("201708090406");
		request2.setDateScheduled("201708090406");
		request2.setDesc("Lightbuld out");
		request2.setEstimatedWorkedTime(6);
		request2.setScheduled(true);

		System.out.println("Adding maintenance request 2 to request list...\n");

		maintenance.getMaintenance().getRequests().add((Request)request2);

		maintenance.getMaintenance().listMaintRequests();
		System.out.println("\n\nBuilding Facility Use objects...");


		//Instantiating FacilityUse
		IFacilityUse facilityUse = (IFacilityUse) context.getBean("facilityUse");

		IEvent event1 = (IEvent) context.getBean("event");
		event1.setFacID(0);
		event1.setEventID(0);
		event1.setEventDate("20170408");
		event1.setEventName("Big Party");

		System.out.println("Adding event 1 to the event list...\n");

		facilityUse.getFacilityUse().getEventList().add(event1);

		IEvent event2 = (IEvent) context.getBean("event");
		event2.setFacID(1);
		event2.setEventID(1);
		event2.setEventDate("20170610");
		event2.setEventName("Engagement Party");

		System.out.println("Adding event 2 to the event list...\n");

		facilityUse.getFacilityUse().getEventList().add(event2);

		System.out.println(facilityUse.getFacilityUse().getEventList().get(1).toString());
		System.out.println(facilityUse.getFacilityUse().getEventList().get(2).toString());

		// Inspection Tests

		IInspection inspection1 = (IInspection) context.getBean("inspection");
		inspection1.setID(0);
		inspection1.setFacID(1);
		inspection1.setCompleted(false);
		inspection1.setDate("20170804");
		inspection1.setInspector("Inspector Gadget");

		IInspection inspection2 = (IInspection) context.getBean("inspection");
		inspection2.setID(1);
		inspection2.setFacID(2);
		inspection2.setCompleted(true);
		inspection2.setDate("20170809");
		inspection2.setInspector("Inspector Man");

		facilityUse.getFacilityUse().getInspections().add(inspection1);
		facilityUse.getFacilityUse().getInspections().add(inspection2);

		System.out.println(facilityUse.getFacilityUse().getInspections().get(1).toString());
		System.out.println(facilityUse.getFacilityUse().getInspections().get(2).toString());


	}

}
