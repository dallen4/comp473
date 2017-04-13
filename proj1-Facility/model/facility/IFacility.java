package model.facility;

import java.util.List;

public interface IFacility {

	public int getID();
	public boolean setID (int id);
	public String getName();
	public boolean setName(String newName);
	public List<String> getDetails();
	public boolean setDetails(List<String> details);
	public Integer getCurrentCapacity();
	public Integer getPotentialCapacity();
	public boolean setPotentialCapacity(Integer potCap);

	//REQUIRED METHODS
	public String getFacilityInformation();
	public int requestAvailableCapacity();
	public void addFacilityDetail(String newDetail);
	public Facility getFacility();
	public boolean setCurrCapacity(Integer newCap);
	public String toString();
}
