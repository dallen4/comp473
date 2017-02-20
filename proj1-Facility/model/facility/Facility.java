package model.facility;

import java.util.List;
import java.util.Vector;
import java.util.Calendar;

import model.maintenance.*;
import model.use.IFacilityUse;

public class Facility implements IFacility, IMaintenance, IFacilityUse {
	
	private int id;
	private String name;
	private int currCapacity = 0;
	private int potentialCapacity;
	private Schedule facilityEvents = new Schedule(Calendar.getInstance());
	private List<String> Details = new Vector<String>();
	private List<Inspection> Inspections = new Vector<Inspection>();
	private List<Request> maintRequests = new Vector<Request>();
	
	//CONSTRUCTORS
	public Facility(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Facility(int id, String name, int potentialCapacity) {
		this.id = id;
		this.name = name;
		this.potentialCapacity = potentialCapacity;
	}
	
	public Facility(int id, String name, int potentialCapacity, List<String> Details) {
		this.id = id;
		this.name = name;
		this.potentialCapacity = potentialCapacity;
		this.Details = Details;
	}
	
	//DEFAULT CONSTRUCTOR
	public Facility() {
		// TODO Auto-generated constructor stub
	}
	
	
	//GETTERS & SETTERS
	
	public int getID() {
		return id;
	}
	
	public boolean setID (int id) {
		this.id = id;
		
		if (this.id == id) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setName(String newName) {
		this.name = newName;
		
		if (this.name == newName) {
			return true;
		} else {
			return false;
		}
	}
	
	public Integer getCurrCapacity() {
		return currCapacity;
	}
	
	public boolean setCurrCapacity(Integer newCap) {
		this.currCapacity = newCap;
		
		if (this.currCapacity == newCap) {
			return true;
		} else {
			return false;
		}
	}
	
	//REQUIRED METHOD
	public String getFacilityInformation() {
		String info = "ID: " + id + "\nName: " + name  + "\nCapacity: " + potentialCapacity + "\nAvailable Capacity: " + requestAvailableCapacity() + "\nDetails: " + Details;
		System.out.println(info);
		return info;
	}
	
	//REQUIRED METHOD
	public int requestAvailableCapacity () {
		return potentialCapacity - currCapacity;
	}
	
	//REQUIRED METHOD
	public void addFacilityDetail(String newDetail) {
		Details.add(newDetail);
		System.out.println("A new facility detail has been submitted successfully...");
		return;
	}
	
	//end IFacility methods
	
	
	//begin IMaintenance methods

	//REQUIRED METHOD
	@Override
	public Request makeFacilityMaintRequest(int reqID, String reqDesc) {
		Request newRequest = new Request (reqID, reqDesc);
		maintRequests.add(newRequest);
		System.out.println("Request with ID " + newRequest.getID() + " has been submitted successfully...");
		return newRequest;
	}

	//REQUIRED METHOD
	@Override
	public Schedule scheduleMaintenance() {
		// TODO Auto-generated method stub
		return null;
	}

	//REQUIRED METHOD
	@Override
	public double calcMaintenanceCostForFacility() {
		// TODO Auto-generated method stub
		return 0;
	}

	//REQUIRED METHOD
	//Calculates ratio of problems/requests completed versus 
	@Override
	public double calcProblemRateForFacility() {
		double complete = 0;
		double incomplete = 0;
		double scheduled = 0;
		double ratio;
		
		for (int i = 0; i < maintRequests.size(); i++) {
			if (maintRequests.get(i).getCompleted()) {
				complete++;
			} else {				
				incomplete++;
				if (maintRequests.get(i).getScheduled()) {
					scheduled++;
				}
			}
		}
		
		ratio = complete/maintRequests.size();
		
		System.out.println("Problem Rate (ratio of completed to problems/requests submitted: " + ratio + "\nOf " + incomplete + " incompleted requests, " + scheduled + " have been scheduled.");
	}

	//REQUIRED METHOD
	@Override
	public double calcDownTimeForFacility() {
		// TODO Auto-generated method stub
		return 0;
	}

	//REQUIRED METHOD
	@Override
	public List<Request> listMaintRequests() {
		for (int i = 0; i < maintRequests.size(); i++) {
			Request temp = maintRequests.get(i);
			System.out.println(temp.getID());
			System.out.println(temp.getDesc());
		}
		return maintRequests;
	}

	//REQUIRED METHOD
	@Override
	public List<String> listMaintenance() {
		// TODO Auto-generated method stub
		return null;
	}

	//REQUIRED METHOD
	@Override
	public List<String> listFacilityProblems() {
		List<String> problems = new Vector<String> ();
		
		for (int i = 0; i < maintRequests.size(); i++) {
			String temp = maintRequests.get(i).getDesc();
			System.out.println(temp);
			problems.add(temp);
		}
		return problems;
	}
	
	//end IMaintenance methods
	
	
	//begin IFacilityUse methods

	//REQUIRED METHOD
	@Override
	public boolean isInUseDuringInterval() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean assignFacilityToUse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vacateFacility() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Inspection> listInspections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listActualUsage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcUsageRate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
