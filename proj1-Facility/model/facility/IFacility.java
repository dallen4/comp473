package model.facility;

public interface IFacility {
	
	//REQUIRED METHODS
	public String getFacilityInformation();
	public int requestAvailableCapacity();
	public void addFacilityDetail(String newDetail);
	public Facility getFacility();
	public boolean setCurrCapacity(Integer newCap);
}
