package model.facility;

import java.util.Date;

/**
 * Created by Lanzer on 3/19/17.
 */
public interface IInspection {

    public int getID();
    public boolean setID(int newID);
    public int getFacID();
    public boolean setFacID(Integer facID);
    public String getDate ();
    public boolean setDate (String newD);
    public String getInspector ();
    public boolean setInspector (String insp);
    public boolean getCompleted ();
    public boolean setCompleted (boolean newState);
    public String getInfo ();
    public String toString();

}
