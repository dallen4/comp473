package model.use;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Event {

    private Date eventDate;
    private String eventName;
    private Integer eventID;

    //CONSTRUCTOR
    public Event(String eventDate, String eventName, Integer eventID) {
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
    }

    public Integer getEventID() {
        return eventID;
    }

    public String getEventInfo() {
        return "Event ID: " + eventID + "\nEvent Date: " + eventDate + "\nEvent Name: " + eventName;
    }
}
