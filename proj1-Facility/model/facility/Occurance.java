package model.facility;
import java.util.Date;

/**
 * Created by lanzer on 4/13/17.
 */
public abstract class Occurance {
    private int ID;
    private int facID;
    private boolean completed;
    private Date dateCreated;
    private Date dateScheduled;


    public abstract boolean setCompleted(boolean completed);

    public abstract boolean setDateCreated(Date dateCreated);


    public abstract boolean setDateScheduled(Date dateScheduled);

    public abstract boolean setID(int ID);

    public abstract boolean setFacID(int facID);


}
