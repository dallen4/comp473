package model.use;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.use.Event;
/**
 * Created by Lanzer on 3/19/17.
 */
public interface IEvent {

    public Integer getEventID();
    public String getEventInfo();
    public Date getEventDate();

}
