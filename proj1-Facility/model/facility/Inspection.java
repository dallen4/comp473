package model.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inspection extends Occurance implements IInspection, Observer {
	
	private int id;
	private Date dateScheduled;
	private Date dateCreated;
	private String inspector;
	private boolean completed = false;
	private int facID;
	private Subject subject;

	//CONSTRUCTOR
	public Inspection(int id, String dateCreated, String insp, boolean com, int facID) {
		this.id = id;

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			this.dateCreated = format.parse(dateCreated);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.inspector = insp;
		this.completed = com;
		this.facID = facID;
	}

	public Inspection (Subject s) {
		this.subject = s;
		subject.attach(this);
	}

	@Override
	public String toString() {
		return "Inspection{" +
				"id=" + id +
				", dateScheduled='" + dateScheduled + '\'' +
				", inspector='" + inspector + '\'' +
				", completed=" + completed +
				", facID=" + facID +
				'}';
	}

	//DEFAULT CONSTRUCTOR
	public Inspection() {
		id = 0000;
		dateScheduled = null;
	}

	public int getFacID() { return facID;}

	@Override
	public boolean setFacID(int facID) {
		this.facID = facID;

		if (this.facID == facID) {
			System.out.println("Facility ID for Inspection " + getID() + " updated successfully...");
			return true;
		} else {
			System.out.println("Facility ID for Inspection " + getID() + " was NOT updated successfully...");
			return false;
		}

	}

	//GETTERS & SETTERS
	public int getID() {
		return id;
	}

	@Override
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

	public Date getDateScheduled () {
		return dateScheduled;
	}

	public Date getDateCreated () {
		return dateCreated;
	}
	
	public String getInspector () {
		return inspector;
	}
	
	public boolean setInspector (String insp) {
		this.inspector = insp;

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

	@Override
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

	@Override
	public boolean setDateCreated(Date dateCreated) {
		return false;
	}

	@Override
	public boolean setDateScheduled(Date dateScheduled) {
		return false;
	}

	@Override
	public boolean setDateCreated(String dateCreated) {
		return true;
	}

	@Override
	public boolean setDateScheduled(String dateScheduled) {
		return true;
	}

	public String getInfo () {
		return "Inspection ID: " + getID() + "\nDate created: " + getDateCreated() + "\nDate scheduled: " + getDateScheduled() + "\nInspector: " + getInspector() + "\nCompleted: " + getCompleted();
	}

	@Override
	public void update(int newFacID) {
		this.facID = newFacID;
	}
}
