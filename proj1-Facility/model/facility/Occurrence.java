package model.facility;
import java.util.Date;
import model.Visitable;

/**
 * Created by lanzer on 4/13/17.
 */
public abstract class Occurrence implements Visitable {

    public abstract boolean setCompleted(boolean completed);

    public abstract boolean setDateCreated(Date dateCreated);

    public abstract boolean setDateScheduled(Date dateScheduled);

    public abstract boolean setDateCreated(String dateCreated);

    public abstract boolean setDateScheduled(String dateScheduled);

    public abstract boolean setID(int ID);

    public abstract boolean setFacID(int ID);

    public abstract int getFacID();

}
