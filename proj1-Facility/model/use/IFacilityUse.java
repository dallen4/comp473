package model.use;

import java.util.List;
import model.facility.Inspection;

public interface IFacilityUse {
	
	//REQUIRED METHODS
	public boolean isInUseDuringInterval(String eventDate);
	public boolean assignFacilityToUse(String eventDate, String eventName, Integer eventID);
	public boolean vacateFacility();
	public List<Inspection> listInspections();
	public List<Event>  listActualUsage();
	public double calcUsageRate();
}
