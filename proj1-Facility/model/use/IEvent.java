package model.use;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.use.Event;
/**
 * Created by Lanzer on 3/19/17.
 */
public interface IEvent {

    public String getEventInfo();
    public void setEventName(String eventName);
    public boolean setDateCreated(String date);
    public boolean setDateScheduled(String date);
    public boolean setID(int id);
    public boolean setFacID (int id);

}
