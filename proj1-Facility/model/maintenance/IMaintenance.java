package model.maintenance;

import java.util.Calendar;
import java.util.List;

public interface IMaintenance {
	
	//REQUIRED METHODS
	public Request makeFacilityMaintRequest(int reqID, String reqDesc);
	public Calendar scheduleMaintenance(int maintID, String maintenanceDate);
	public double calcMaintenanceCostForFacility();
	public double calcProblemRateForFacility();
	public double calcDownTimeForFacility();
	public List<Request> listMaintRequests();
	public List<String> listMaintenance();
	public List<String> listFacilityProblems();
	
}
