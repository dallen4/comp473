package model.facility;

import java.util.Date;
import java.util.Calendar;

public class Inspection implements IInspection {
	
	private int id;
	private Date dateConducted;
	private String inspector;
	private boolean completed = false;

	//CONSTRUCTOR
	public Inspection(int id, Date date, String insp, boolean com) {
		this.id = id;
		this.dateConducted = date;
		this.inspector = insp;
		this.completed = com;
	}
	
	//DEFAULT CONSTRUCTOR
	public Inspection() {
		id = 0000;
		dateConducted = null;
		inspector = "John Doe";
	}
	
	//GETTERS & SETTERS
	public int getID() {
		return id;
	}
	
	public boolean setID(int newID) {
		int temp = getID();
		this.id = newID;
		
		if (id == newID) {
			System.out.println("ID for Inspection previously known as " + temp + " has been updated to ID number " + getID() + " successfully...");
			return true;
		} else {
			System.out.println("ID modification for Inspection " + getID() + " was NOT successful...");
			return false;
		}
	}
	
	public Date getDate () {
		return dateConducted;
	}
	
	public boolean setDate (Date newD) {
		this.dateConducted = newD;
		
		if (this.dateConducted == newD) {
			System.out.println("Date for inspection updated successfully successfully...");
			return true;
		} else {
			System.out.println("Date setting for inspection was NOT successful...");
			return false;
		}
	}
	
	public String getInspector () {
		return inspector;
	}
	
	public boolean setInspector (String insp) {
		
		if (inspector == insp) {
			System.out.println("Inspector for Inspection has been updated successfully...");
			return true;
		} else {
			System.out.println("Inspector set for Request " + getID() + " was NOT successful...");
			return false;
		}
	}
	
	public boolean getCompleted () {
		return completed;
	}
	
	public boolean setCompleted (boolean newState) {
		this.completed = newState;
		
		if (completed == newState) {
			System.out.println("Completion status for Inspection " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Completion for Inspection " + getID() + " was NOT updated successfully...");
			return false;
		}
	}
	
	public String getInfo () {
		return "Inspection ID: " + getID() + "\nDate conducted: " + getDate() + "\nInspector: " + getInspector() + "\nCompleted: " + getCompleted();
	}

}
