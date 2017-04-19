package model.facility;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lanzer on 4/18/17.
 */
public interface Observer {

    public void update(int oldFacID, int newFacID);

}
