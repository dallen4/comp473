package model.use;

import model.facility.Inspection;
import model.maintenance.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Event implements IEvent {

    private Date eventDate;
    private String eventName;
    private Integer eventID;
    private Integer facID;

    //CONSTRUCTOR

    public Event(){

    }

    public Event(String eventDate, String eventName, Integer eventID, Integer facID) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.eventID = eventID;
        this.eventDate = date;
        this.eventName = eventName;
        this.facID = facID;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventDate=" + eventDate +
                ", eventName='" + eventName + '\'' +
                ", eventID=" + eventID +
                ", facID=" + facID +
                '}';
    }

    public Integer getFacID() { return facID;}

    public Integer getEventID() {
        return eventID;
    }

    public String getEventInfo() {
        return "Event ID: " + eventID + "\nEvent Date: " + eventDate + "\nEvent Name: " + eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.eventDate = date;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public void setFacID(Integer facID) {
        this.facID = facID;
    }
}
