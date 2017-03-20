package model.maintenance;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Lanzer on 3/19/17.
 */
public interface IRequest {

    public int getID();
    public boolean setID (int newID);
    public String getDesc ();
    public boolean setDesc (String newDesc);
    public boolean getCompleted ();
    public boolean setCompleted (int ID, boolean newState);
    public boolean getScheduled ();
    public boolean setScheduled (boolean newState);
    public Calendar getDateCreated ();
    public boolean setDateCreated (Calendar newDate);
    public String getDateScheduled ();
    public boolean setDateScheduled (Calendar scheduledDate);
    public boolean setCost(int id, double cost);
    public boolean setEstimatedWorkedTime (int id, double estimatedWorktime);
    public double getEstimatedWorktime();
    public double getCost();
    public String toString();

}