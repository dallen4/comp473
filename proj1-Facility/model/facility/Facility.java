package model.facility;


import java.util.List;

public class Facility implements IFacility {
	
	private int id;
	private String name;
	private int currCapacity = 0;
	private int potentialCapacity;
	private List<String> Details;


	@Override
	public String toString() {
		return "Facility{" +
				"id=" + id +
				", name='" + name + '\'' +
				", currCapacity=" + currCapacity +
				", potentialCapacity=" + potentialCapacity +
				", Details=" + Details +
				'}';
	}

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

	public Facility getFacility() {
		return this;
	}

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

	public Integer getPotentialCapacity() {
		return potentialCapacity;
	}

	public boolean setPotentialCapacity(Integer potCap) {
		this.potentialCapacity = potCap;

		if (this.potentialCapacity == potCap) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getCurrentCapacity() {
		return currCapacity;
	}

	public List<String> getDetails() {
		return Details;
	}

	public boolean setDetails(List<String> details) {
		this.Details = details;

		if (this.Details == details) {
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

	public boolean setCurrCapacity(Integer newCap) {
		this.currCapacity = newCap;

		if (this.currCapacity == newCap) {
			return true;
		} else {
			return false;
		}
	}
	
	//REQUIRED METHOD
	public void addFacilityDetail(String newDetail) {
		Details.add(newDetail);
		System.out.println("A new facility detail has been submitted successfully...");
		return;
	}


	//end IFacility methods
}

