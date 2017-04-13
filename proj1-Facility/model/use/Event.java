package model.use;

import model.facility.Occurance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Event extends Occurance implements IEvent  {

    private String eventName;
    private int ID;
    private int facID;
    private boolean completed;
    private Date dateCreated;
    private Date dateScheduled;

    //CONSTRUCTOR

    public Event(){

    }

    public Event(String eventName, int ID, Integer facID, String dateCreated, String dateScheduled) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            this.dateCreated = format.parse(dateCreated);
            this.dateScheduled = format.parse(dateScheduled);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.ID = ID;
        this.eventName = eventName;
        this.facID = facID;
    }

    @Override
    public String toString() {
        return "Event{" +
                "dateCreated=" + dateCreated +
                "dateScheduled=" + dateScheduled +
                "completed" + completed +
                ", eventName='" + eventName + '\'' +
                ", eventID=" + ID +
                ", facID=" + facID +
                '}';
    }

    public Integer getFacID() { return facID;}

    public String getEventInfo() {
        return "Event ID: " + ID + "\nCreated Date: " + dateCreated + "\nScheduled Date: " + dateScheduled +
                "\nEvent Completed: " + completed + "\nEvent Name: " + eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }



    /// NEED TO IMPLEMENT THESE
    @Override
    public boolean setCompleted(boolean completed) {
        this.completed = completed;

        if (this.completed == completed)
            return true;
        else
            return false;
    }

    @Override
    public boolean setDateCreated(String dateCreated) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(dateCreated);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.dateCreated = date;

        if (this.dateCreated == date)
            return true;
        else
            return false;
    }

    @Override
    public boolean setDateScheduled(String dateScheduled) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(dateScheduled);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.dateScheduled = date;

        if (this.dateScheduled == date)
            return true;
        else
            return false;
    }

    @Override
    public boolean setID(int ID) {
        this.ID = ID;

        if (this.ID == ID)
            return true;
        else
            return false;
    }

    @Override
    public boolean setFacID(int facID) {
        this.facID = facID;

        if (this.facID == facID)
            return true;
        else
            return false;
    }
}
