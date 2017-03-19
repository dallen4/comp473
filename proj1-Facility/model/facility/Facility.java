package model.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

import model.maintenance.*;
import model.use.Event;
import model.use.IFacilityUse;
import model.use.Event;

public class Facility implements IFacility {
	
	private int id;
	private String name;
	private int currCapacity = 0;
	private int potentialCapacity;
	private List<String> Details = new Vector<String>();
	private List<Inspection> Inspections = new Vector<Inspection>();
	private List<Request> maintRequests = new Vector<Request>();
	private List<Event> eventList = new Vector<Event>();
	
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
}

