package model.facility;
import java.util.Date;

/**
 * Created by lanzer on 4/13/17.
 */
public abstract class Occurrence {

    public abstract boolean setCompleted(boolean completed);

    public abstract boolean setDateCreated(Date dateCreated);

    public abstract boolean setDateScheduled(Date dateScheduled);

    public abstract boolean setDateCreated(String dateCreated);

    public abstract boolean setDateScheduled(String dateScheduled);

    public abstract boolean setID(int ID);

}
