package model.facility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lanzer on 4/18/17.
 */
public class Subject implements ISubject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int newFacID;
    private int facID;

    public int getState() {
        return facID;
    }

    public void setState(int state, int newState) {
        this.newFacID = newState;
        this.facID = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(facID, newFacID);
        }
    }
}
