package model.use;

import model.facility.Inspection;
import model.facility.Facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lanzer on 3/19/17.
 */
public class FacilityUse implements IFacilityUse {

    private Integer currCapacity;
    private List<Inspection> Inspections;
    private List<Event> eventList;

    public FacilityUse () {
    }

    public FacilityUse getFacilityUse () {
        return this;
    }

    //REQUIRED METHOD
    @Override
    public boolean isInUseDuringInterval(Integer facID, String eventDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i=0; i<eventList.size(); i++){
            if (date.compareTo(eventList.get(i).getDateScheduled()) == 0  && eventList.get(i).getFacID() == facID){
                System.out.println("This date is already booked.");
                return true;
            }
        }
        System.out.println("This date is available for booking");
        return false;
    }


//    FIX SPRING IMPLEMENTATION

    @Override
    public boolean assignFacilityToUse(String dateScheduled, String dateCreated, String eventName, Integer eventID, Integer facID) {
        Event newEvent = new Event(eventName,eventID,facID, dateCreated, dateScheduled);
        eventList.add(newEvent);
        System.out.println("Event with ID " + newEvent.getID() + " has been submitted successfully...");
        return true;
    }

    @Override
    public boolean addInspection(int id, String date, String insp, boolean com, int facID) {
        Inspection newInspection = new Inspection(id,date,insp,com,facID);
        Inspections.add(newInspection);
        System.out.println("Inspection with Details: " + newInspection.getInfo() + "Has been added to inspection list");
        return true;
    }

    @Override
    public boolean vacateFacility(Facility f) {
        return f.setCurrCapacity(0);
    }

    @Override
    public List<Inspection> listInspections(Integer facID) {
        System.out.println("Printing all Inspections for Facility " + facID);

        for (int i = 0; i < Inspections.size(); i++) {
            if(Inspections.get(i).getFacID() == facID) {
                System.out.println(Inspections.get(i).getInfo());
            }
        }

        return Inspections;
    }

    @Override
    public List<Event>  listActualUsage(Integer facID) {
        System.out.println("Printing all Events for Facility " + facID);

        for (int i = 0; i < eventList.size(); i++) {
            if (Inspections.get(i).getFacID() == facID) {
            System.out.println(eventList.get(i).getEventInfo());
        }
        }
        return eventList;
    }

    @Override
    public double calcUsageRate(Integer facID) {
        double use = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (Inspections.get(i).getFacID() == facID) {
                use++;
            }
        }
        double usageRate = use/365;
        System.out.println("The actual usage rate (use/365) for facilityID: " + facID + " is: " + usageRate);
        return usageRate;
    }

    @Override
    public boolean assignFacilityToUse(String eventDate, String eventName, int eventID, int facID, String dateCreated, String dateScheduled) {
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

    public void setInspections(List Inspections) {
        this.Inspections = Inspections;
    }

    public List getInspections() {
        return Inspections;
    }

    public void setEventList(List eventList) {
        this.eventList = eventList;
    }

    public List getEventList() {
        return eventList;
    }
}
