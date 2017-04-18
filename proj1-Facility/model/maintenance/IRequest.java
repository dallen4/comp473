package model.maintenance;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Lanzer on 3/19/17.
 */
public interface IRequest {

    public int getID();
    public boolean setID (int newID);
    public int getFacID();
    public boolean setFacID (int newID);
    public String getDesc ();
    public boolean setDesc (String newDesc);
    public boolean getCompleted ();
    public boolean setCompleted (boolean newState);
    public boolean getScheduled ();
    public boolean setScheduled (boolean newState);
    public String getDateCreated ();
    public String getDateScheduled ();
    public boolean setDateCreated(String date);
    public boolean setDateScheduled(String date);
    public boolean setCost(double cost);
    public boolean setEstimatedWorkedTime (double estimatedWorktime);
    public double getEstimatedWorktime();
    public double getCost();
    public String toString();

}
