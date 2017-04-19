package model.facility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lanzer on 4/18/17.
 */

public interface ISubject {

    public int getState();

    public void setState(int state, int newState);

    public void attach(Observer observer);

    public void notifyAllObservers();
}
