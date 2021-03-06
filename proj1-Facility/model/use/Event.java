package model.use;

import model.Visitor;
import model.facility.Observer;
import model.facility.Occurrence;
import model.facility.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Event extends Occurrence implements IEvent, Observer {

    private String eventName;
    private int ID;
    private int facID;
    private boolean completed;
    private Date dateCreated;
    private Date dateScheduled;
    private double estimatedDuration;

    private Subject facGrabber;

    //CONSTRUCTOR

    public Event(String eventDate, String eventName, int eventID, int facID, String dateCreated, String dateScheduled, double time){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            this.dateCreated = format.parse(dateCreated);
            this.dateScheduled = format.parse(dateScheduled);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.ID = eventID;
        this.eventName = eventName;
        this.facID = facID;
        completed = false;
        this.estimatedDuration = time;
    }

    public Event (Subject facGrabber) {
        this.facGrabber = facGrabber;
        this.facGrabber.attach(this);
    }

    public Event(String eventName, int ID, int facID, String dateCreated, String dateScheduled) {
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

    public Event() {
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

    public int getID() {
        return ID;
    }

    public int getFacID() { return facID;}

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
    public boolean setDateCreated(Date dateCreated) {
        return false;
    }

    @Override
    public boolean setDateScheduled(Date dateScheduled) {
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

    public Date getDateScheduled () {
        return dateScheduled;
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

    @Override
    public void update(int oldFacID, int newFacID) {
        if (this.facID == oldFacID) {
            this.facID = newFacID;
        } else {
            return;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(double estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }
}
