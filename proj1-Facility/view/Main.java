package view;

import model.facility.Facility;
import model.facility.IFacility;
import model.facility.IInspection;
import model.facility.Manager;
import model.maintenance.IMaintenance;
import model.maintenance.IRequest;
import model.maintenance.Request;
import model.use.IEvent;
import model.use.IFacilityUse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext context;
		context = new ClassPathXmlApplicationContext("app-context.xml");

		System.out.println("******  Starting Facility Management System  ******");

		System.out.println("Creating Manager object...");

		Manager manager = (Manager)context.getBean("manager");

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
		event1.setID(0);
		event1.setDateScheduled("20170408");
		event1.setEventName("Big Party");

		System.out.println("Adding event 1 to the event list...\n");

		facilityUse.getFacilityUse().getEventList().add(event1);

		IEvent event2 = (IEvent) context.getBean("event");
		event2.setFacID(1);
		event2.setID(1);
		event2.setDateScheduled("20170610");
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
		inspection1.setDateScheduled("20170804");
		inspection1.setInspector("Inspector Gadget");

		IInspection inspection2 = (IInspection) context.getBean("inspection");
		inspection2.setID(1);
		inspection2.setFacID(2);
		inspection2.setCompleted(true);
		inspection2.setDateScheduled("20170809");
		inspection2.setInspector("Inspector Man");

		facilityUse.getFacilityUse().getInspections().add(inspection1);
		facilityUse.getFacilityUse().getInspections().add(inspection2);

		System.out.println(facilityUse.getFacilityUse().getInspections().get(1).toString());
		System.out.println(facilityUse.getFacilityUse().getInspections().get(2).toString());


	}

}
