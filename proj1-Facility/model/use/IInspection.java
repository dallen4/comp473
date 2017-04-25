package model.use;


/**
 * Created by Lanzer on 3/19/17.
 */
public interface IInspection {

    public int getID();
    public boolean setID(int newID);
    public int getFacID();
    public String getInspector ();
    public boolean setInspector (String insp);
    public String getInfo ();
    public String toString();
    public boolean setDateCreated(String date);
    public boolean setDateScheduled(String date);
    public boolean setFacID (int id);
    public boolean setCompleted (boolean status);
    public double getEstimatedInspectionTime();
    public void setEstimatedInspectionTime(double estimatedInspectionTime);

}
