package model.facility;

import java.util.List;
import java.util.Vector;

public class Facility implements IFacility {
	
	private int id;
	private String name;
	private Integer currCapacity;
	private Integer potentialCapacity;
	private List<String> Details = new Vector<String>();
	private List<Inspection> Inspections = new Vector<Inspection>();
	
	//CONSTRUCTORS
	public Facility(int id, String name, Integer potentialCapacity) {
		this.id = id;
		this.name = name;
		this.potentialCapacity = potentialCapacity;
	}
	
	public Facility(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Facility(int id, String name, Integer potentialCapacity, List<String> Details) {
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
		String info = id + "\n" + name  + "\n" + potentialCapacity + "\n" + Details;
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
		return;
	}

}
