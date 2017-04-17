package model.use;


import java.util.List;
import model.facility.Facility;
import model.facility.Inspection;

public interface IFacilityUse {
	
	//REQUIRED METHODS
	public boolean isInUseDuringInterval(Integer facID, String eventDate);
	public boolean assignFacilityToUse(String dateScheduled, String dateCreated, String eventName, Integer eventID,Integer facID);
	public boolean vacateFacility(Facility f);
	public List<Inspection> listInspections(Integer facID);
	public List<Event>  listActualUsage(Integer facID);
	public double calcUsageRate(Integer facID);
	public boolean addInspection(int id, String date, String insp, boolean com, int facID);
	public FacilityUse getFacilityUse ();
}
