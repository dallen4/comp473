package view;

import model.facility.*;
import model.maintenance.IMaintenance;
import model.maintenance.IRequest;
import model.maintenance.Request;
import model.use.Event;
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

		ISubject subject = new Subject();

		System.out.println("******  Starting Facility Management System  ******");

		System.out.println("Creating Manager object...");

		Manager manager = (Manager)context.getBean("manager");


		List<Facility> facilityList = manager.getFacilities();

		System.out.println("");
		System.out.println("***** Creating Facilities *****");
		System.out.println("");

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

		System.out.println("");
		System.out.println("***** Implementing Maintenance and Request *****");
		System.out.println("");

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

		System.out.println("");
		System.out.println("***** Implementing facilityUse and Event *****");
		System.out.println("");

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

		// Initiating normal implementation of inspection

		System.out.println("");
		System.out.println("***** Implementing Inspection *****");
		System.out.println("");

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



		// Observer Tests
		System.out.println("");
		System.out.println("***** Starting Observer Tests *****");
		System.out.println("");

		IInspection inspection4 = new Inspection((Subject)subject);
		IInspection inspection5 = new Inspection((Subject)subject);
		IInspection inspection6 = new Inspection((Subject)subject);
		inspection4.setFacID(1);
		inspection5.setFacID(2);
		inspection6.setFacID(3);
		System.out.println("inspection 4" + inspection4.toString());
		System.out.println("inspection 5" + inspection5.toString());
		System.out.println("inspection 6" + inspection6.toString());
		subject.setState(inspection4.getFacID(), 4);
		subject.setState(inspection5.getFacID(), 5);
		subject.setState(inspection6.getFacID(), 6);
		System.out.println("inspection 4" + inspection4.toString());
		System.out.println("inspection 5" + inspection5.toString());
		System.out.println("inspection 6" + inspection6.toString());


		IEvent event4 = new Event((Subject)subject);
		IEvent event5 = new Event((Subject)subject);
		IEvent event6 = new Event((Subject)subject);
		event4.setFacID(7);
		event5.setFacID(8);
		event6.setFacID(9);
		System.out.println("event 4" + event4.toString());
		System.out.println("event 5" + event5.toString());
		System.out.println("event 6" + event6.toString());
		subject.setState(event4.getFacID(), 10);
		subject.setState(event5.getFacID(), 11);
		subject.setState(event6.getFacID(), 12);
		System.out.println("event 4" + event4.toString());
		System.out.println("event 5" + event5.toString());
		System.out.println("event 6" + event6.toString());

		IRequest request4 = new Request((Subject)subject);
		IEvent request5 = new Event((Subject)subject);
		IEvent request6 = new Event((Subject)subject);
		request4.setFacID(13);
		request5.setFacID(14);
		request6.setFacID(15);
		System.out.println("request 4 " + request4.toString());
		System.out.println("request 5 " + request5.toString());
		System.out.println("request 6 " + request6.toString());
		subject.setState(request4.getFacID(), 16);
		subject.setState(request5.getFacID(), 17);
		subject.setState(request6.getFacID(), 18);
		System.out.println("request 4 " + request4.toString());
		System.out.println("request 5 " + request5.toString());
		System.out.println("request 6 " + request6.toString());


		System.out.println("To confirm our inspections are still uneffected by later changes these should be 4,5,6 : ");

		System.out.println("inspection 4" + inspection4.toString());
		System.out.println("inspection 5" + inspection5.toString());
		System.out.println("inspection 6" + inspection6.toString());


		System.out.println("");
		System.out.println("***** End of Obeserver Tests  *****");

	}

}
