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
		// TODO Auto-generated constructor stub
	}
	
	public Facility(int id, String name) {
		// TODO Auto-generated constructor stub
	}
	
	public Facility(int id, String name, Integer potentialCapacity, List<String> Details) {
		// TODO Auto-generated constructor stub
	}
	
	//DEFAULT CONSTRUCTORS
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
		return "";
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

	//REQUIRED METHOD
	@Override
	public void addFacilityDetail() {
		// TODO Auto-generated method stub
		
	}

}
