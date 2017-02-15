package facility;

import java.util.List;
import java.util.Vector;

public class Facility {
	
	private String name;
	private Integer currCapacity;
	private Integer potentialCapacity;
	private List<String> Details = new Vector<String>();
	
	public Facility() {
		// TODO Auto-generated constructor stub
	}
	
	public Facility(String name) {
		this.name = name;
	}
	
	public Facility (String name, List<String> Details) {
		this.name = name;
		this.Details = Details;
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
	
//	FINISH
	public void getFacilityInformation() {
		return;
	}
	
	public Integer requestAvailableCapacity () {
		return potentialCapacity - currCapacity;
	}
	
	public void addFacilityDetail(String newDetail) {
		Details.add(newDetail);
		return;
	}

}
