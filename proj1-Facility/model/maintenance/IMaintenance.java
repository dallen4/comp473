package model.maintenance;

import java.util.Calendar;
import java.util.List;

public interface IMaintenance {
	
	//REQUIRED METHODS
	public Request makeFacilityMaintRequest(int facID, int reqID, String reqDesc);
	public Calendar scheduleMaintenance(int maintID, String maintenanceDate);
	public double calcMaintenanceCostForFacility(Integer facID);
	public double calcProblemRateForFacility(Integer facID);
	public double calcDownTimeForFacility(Integer facID);
	public List<Request> listMaintRequests();
	public List<String> listMaintenance(Integer facID);
	public List<String> listFacilityProblems(Integer facID);
	
}
