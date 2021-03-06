package model.use;


import java.util.List;
import model.facility.Facility;

public interface IFacilityUse {
	
	//REQUIRED METHODS
	public boolean isInUseDuringInterval(Integer facID, String eventDate);
	public boolean assignFacilityToUse(String dateScheduled, String dateCreated, String eventName, Integer eventID,Integer facID);
	public boolean vacateFacility(Facility f);
	public List<Inspection> listInspections(Integer facID);
	public List<Event>  listActualUsage(Integer facID);
	public double calcUsageRate(Integer facID);

    boolean assignFacilityToUse(String eventDate, String eventName, int eventID, int facID, String dateCreated, String dateScheduled);

    public boolean addInspection(int id, String date, String insp, boolean com, int facID, double time);
	public FacilityUse getFacilityUse ();
	public List<Event> getEventList();
	public List<Inspection> getInspections();
}
