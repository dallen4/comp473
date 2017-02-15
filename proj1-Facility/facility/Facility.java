package facility;

import java.util.List;
import java.util.Vector;
import facility.Detail;

public class Facility {
	
	private String name;
	private Integer capacity;
	private Integer availableCapacity;
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
	
	public Integer getAvailableCapacity () {
		return availableCapacity;
	}
	
	public void addFacilityDetail(String newDetail) {
		Details.add(newDetail);
		return;
	}

}