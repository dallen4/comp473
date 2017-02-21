package model.maintenance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Request {
	
	private int id;
	private String description;
	private boolean completed;
	private boolean scheduled;
	private Calendar dateCreated;
	private Calendar dateScheduled = null;

	//NEED TO IMPLEMENT COST CALCULATION

	public Request(int id, String description) {
		this.id = id;
		this.description = description;
		scheduled = false;
		completed = false;
		dateCreated = Calendar.getInstance();
		dateScheduled = Calendar.getInstance();
	}
	
	// DEFAULT CONSTRUCTOR
	public Request() {
		this.id = 0000;
		this.description = "N/A";
		scheduled = false;
		completed = false;
		dateCreated = Calendar.getInstance();
	}
	
	// GETTERS & SETTERS
	
	public int getID() {
		return id;
	}
	
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
}
