package model.use;

import model.facility.Inspection;
import model.maintenance.Request;
import model.use.IFacilityUse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by Lanzer on 3/19/17.
 */
public class FacilityUse implements IFacilityUse {

    private Integer FacilityID;
    private Integer currCapacity;
    private List<Inspection> Inspections = new Vector<Inspection>();
    private List<Request> maintRequests = new Vector<Request>();
    private List<Event> eventList = new Vector<Event>();


    //REQUIRED METHOD
    @Override
    public boolean isInUseDuringInterval(String eventDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i=0; i<eventList.size(); i++){
            if (date.compareTo(eventList.get(i).getEventDate()) == 0){
                System.out.println("This date is already booked.");
                return true;
            }
        }
        System.out.println("This date is available for booking");
        return false;
    }


    @Override
    public boolean assignFacilityToUse(String eventDate, String eventName, Integer eventID) {
        Event newEvent = new Event(eventDate,eventName,eventID);
        eventList.add(newEvent);
        System.out.println("Event with ID " + newEvent.getEventID() + " has been submitted successfully...");
        return true;
    }

    @Override
    public boolean vacateFacility() {
        return setCurrCapacity(0);
    }

    @Override
    public List<Inspection> listInspections() {
        System.out.println("Printing all Inspections for Facility " + this.FacilityID);

        for (int i = 0; i < Inspections.size(); i++) {
            System.out.println(Inspections.get(i).getInfo());
        }

        return Inspections;
    }

    @Override
    public List<Event>  listActualUsage() {
        System.out.println("Printing all Events for Facility " + this.FacilityID);

        for (int i = 0; i < eventList.size(); i++) {
            System.out.println(eventList.get(i).getEventInfo());
        }
        return eventList;
    }

    @Override
    public double calcUsageRate() {
        double use = eventList.size();
        double usageRate = use/365;
        return usageRate;
    }

    public boolean completeMaintRequest(int maintID){
        for (int i = 0; i<maintRequests.size(); i++){
            if (maintID == maintRequests.get(i).getID()){
                maintRequests.get(i).setCompleted(maintID,true);}
            return true;
        }
        System.out.println("ID not found");
        return false;
    }

    public boolean addNewCost(int maintID, int cost){
        for (int i = 0; i<maintRequests.size(); i++){
            if (maintID == maintRequests.get(i).getID()){
                maintRequests.get(i).setCost(maintID, cost);}
            return true;
        }
        System.out.println("ID not found");
        return false;
    }

    public boolean addWorktime(int maintID, double workTime){
        for (int i = 0; i<maintRequests.size(); i++){
            if (maintID == maintRequests.get(i).getID()){
                maintRequests.get(i).setEstimatedWorkedTime(maintID, workTime);}
            return true;
        }
        System.out.println("ID not found");
        return false;
    }


    public Integer getCurrCapacity() {
        return currCapacity;
    }

    public boolean setCurrCapacity(Integer newCap) {
        this.currCapacity = newCap;

        if (this.currCapacity == newCap) {
            return true;
        } else {
            return false;
        }
    }
}
