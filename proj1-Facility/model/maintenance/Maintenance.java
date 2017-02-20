package model.maintenance;

import java.util.List;
import java.util.Vector;

public class Maintenance {
	
	private List<Request> Requests = new Vector<Request>();
	private List<String> Problems = new Vector<String>();
	private Integer facilityID;
	private String facilityName;
	private String problemDetails;

	
	public Maintenance(int facilityID, String facilityName) {
		this.facilityID = facilityID;
		this.facilityName = facilityName;
	}
	
	public Request makeFacilityMaintRequest(String problemDetails) {
		Problems.add(problemDetails);
		return new Request();
	}
	
	//creates new Maintenance Schedule
	public Schedule scheduleMaintenance() {
		return new Schedule();
	}
	
	public double calcProblemRateForFacility() {
		return 0;
	}
	
	public double calcDowntimeForFacility() {
		return 0;
	}
	
	public List<Request> listMaintRequests() {
		for (int i = 0; i < Requests.size(); i++) {
			Request temp = Requests.get(i);
			System.out.println(temp.getID());
		}
		return Requests;
	}
	
	public List<String> listFacilityProblems() {
		for (int i = 0; i < Problems.size(); i++) {
			String temp = Problems.get(i);
			System.out.println(temp);
		}
		return Problems;
	}
}

