package model.maintenance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Request implements IRequest{
	
	private int id;
	private int facID;
	private String description;
	private boolean completed;
	private boolean scheduled;
	private Calendar dateCreated;
	private Calendar dateScheduled = null;
	private double cost = 20.0;
	private double estimatedWorktime;

	//NEED TO IMPLEMENT COST CALCULATION

	public Request(int facID, int id, String description) {
		this.facID = facID;
		this.id = id;
		this.description = description;
		scheduled = false;
		completed = false;
		dateCreated = Calendar.getInstance();
	}
	
	// DEFAULT CONSTRUCTOR
	public Request() {
		this.id = 0000;
		this.description = "N/A";
		scheduled = false;
		completed = false;
	}
	
	// GETTERS & SETTERS
	
	public int getID() {
		return id;
	}

	public int getFacID() { return facID;}
	
	public boolean setID (int newID) {
		int temp = getID();
		this.id = newID;
		
		if (id == newID) {
			System.out.println("ID for Request previously known as " + temp + " has been updated to ID number " + getID() + " successfully...");
			return true;
		} else {
			System.out.println("ID modification for Request " + getID() + " was NOT successful...");
			return false;
		}
	}

	public String getDesc () {
		return description;
	}
	
	public boolean setDesc (String newDesc) {
		this.description = newDesc;
		
		if (description == newDesc) {
			System.out.println("Description for Request " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Description for Request " + getID() + " was NOT updated successfully...");
			return false;
		}
	}
	
	public boolean getCompleted () {
		return completed;
	}
	
	public boolean setCompleted (int ID, boolean newState) {
		this.completed = newState;
		
		if (completed == newState) {
			System.out.println("Completion status for Request " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Completion for Request " + getID() + " was NOT updated successfully...");
			return false;
		}
	}
	
	public boolean getScheduled () {
		return scheduled;
	}
	
	public boolean setScheduled (boolean newState) {
		this.scheduled = newState;
		
		if (scheduled == newState) {
			System.out.println("Scheduled status for Request " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Scheduled status for Request " + getID() + " was NOT updated successfully...");
			return false;
		}
	}
	
	public Calendar getDateCreated () {
		return dateCreated;
	}
	
	public boolean setDateCreated (Calendar newDate) {
		this.dateCreated = newDate;
		
		if (dateCreated == newDate) {
			System.out.println("Creation date for Request " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Creation date for Request " + getID() + " was NOT updated successfully...");
			return false;
		}
	}

	
	public String getDateScheduled () {
		if (dateScheduled != null){
			Calendar cal = dateScheduled;
			Date date = cal.getTime();
			return date.toString();
		}
		else {
			return "Not Scheduled";
		}
	}
	
	public boolean setDateScheduled (Calendar scheduledDate) {
		this.dateScheduled = scheduledDate;
		
		if (dateScheduled == scheduledDate) {
			System.out.println("Scheduled date for Request " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Scheduled date for Request " + getID() + " was NOT updated successfully...");
			return false;
		}
	}
	// Sets the vector of all the costs
	public boolean setCost(int id, double cost) {
		this.cost = cost;

		if (cost == cost) {
			System.out.println("Completion status for Cost Update " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Completion for Cost Update " + getID() + " was NOT updated successfully...");
			return false;
		}
	}

	public boolean setEstimatedWorkedTime (int id, double estimatedWorktime) {
		this.estimatedWorktime = estimatedWorktime;
		if (estimatedWorktime == estimatedWorktime) {
			System.out.println("Updated worktime for Request " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Updated worktime for Request " + getID() + " was NOT updated successfully...");
			return false;
		}
	}

	public double getEstimatedWorktime(){
		return estimatedWorktime;
	}

	public double getCost(){
		return cost;
	}
	
	@Override
	public String toString() {
		return "ID: " + getID() + "\nDescription: " + getDesc() + "\nComplete: " + getCompleted() + "\nScheduled for: " + getDateScheduled() + "\nThe maintenance cost is: " + getCost() + "$";
	}
}
