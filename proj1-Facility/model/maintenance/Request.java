package model.maintenance;

import model.facility.Occurance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.facility.Observer;
import model.facility.*;

public class Request extends Occurance implements IRequest, Observer {
	
	private int id;
	private int facID;
	private String description;
	private boolean completed;
	private boolean scheduled;
	private Date dateCreated;
	private Date dateScheduled;
	private double cost = 20.0;
	private double estimatedWorktime;
	private Subject subject;

	//NEED TO IMPLEMENT COST CALCULATION

	public Request(int facID, int id, String description, String dateCreated, String dateScheduled) {
		this.facID = facID;
		this.id = id;
		this.description = description;
		scheduled = false;
		completed = false;

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		try {
			this.dateCreated = format.parse(dateCreated);
			this.dateScheduled = format.parse(dateScheduled);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Request(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}

	public Request(int facID, int reqID, String description) {
		this.facID = facID;
		this.id = reqID;
		this.description = description;

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

	@Override
	public boolean setFacID(int facID) {
		this.facID = facID;
		if (this.facID == facID) {
			return true;
		} else {
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
	
	public boolean setCompleted (boolean newState) {
		this.completed = newState;
		
		if (completed == newState) {
			System.out.println("Completion status for Request " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Completion for Request " + getID() + " was NOT updated successfully...");
			return false;
		}
	}

	@Override
	public boolean setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
		return true;
	}

	@Override
	public boolean setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
		return true;
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
	
	public String getDateCreated () {
		return dateCreated.toString();
	}

	@Override
	public boolean setDateCreated (String newDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse(newDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.dateCreated = date;

		if (this.dateCreated == date)
			return true;
		else
			return false;
	}

	
	public String getDateScheduled () {
		if (dateScheduled != null) {
			return dateScheduled.toString();
		}
		else {
			return "Not Scheduled";
		}
	}

	@Override
	public boolean setDateScheduled (String scheduledDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse(scheduledDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.dateCreated = date;

		if (this.dateCreated == date)
			return true;
		else
			return false;
	}

	// Sets the vector of all the costs
	public boolean setCost(double cost) {
		this.cost = cost;

		if (cost == cost) {
			System.out.println("Completion status for Cost Update " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Completion for Cost Update " + getID() + " was NOT updated successfully...");
			return false;
		}
	}

	public boolean setEstimatedWorkedTime (double estimatedWorktime) {
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
		return "ID: " + getID() + "\nDescription: " + getDesc() + "\nComplete: " + getCompleted() + "\nScheduled for: " + getDateScheduled() + "\nThe maintenance cost is: " + getCost() + "$" + "\nFac ID: " + facID;
	}

	@Override
	public void update(int oldFacID, int newFacID) {
		if (this.facID == oldFacID) {
			this.facID = newFacID;
		} else {
			return;
		}
	}
}
