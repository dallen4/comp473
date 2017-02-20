package model.maintenance;

import java.util.List;

public interface IMaintenance {
	
	//REQUIRED METHODS
	public Request makeFacilityMaintRequest();
	public Schedule scheduleMaintenance();
	public double calcMaintenanceCostForFacility();
	public double calcProblemRateForFacility();
	public double calcDownTimeForFacility();
	public List<String> listMaintRequests();
	public List<String> listMaintenance();
	public List<String> listFacilityProblems();
	
}
