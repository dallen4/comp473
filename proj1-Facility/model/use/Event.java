package model.use;

import java.util.Date;


public class Event {

    private Date eventDate;
    private String eventName;
    private Integer eventID;


    //CONSTRUCTOR
    public Event(Date eventDate, String eventName, Integer eventID) {
        this.eventID = eventID;
        this.eventDate = eventDate;
        this.eventName = eventName;
    }

    public Integer getEventID() {
        return eventID;
    }


}
