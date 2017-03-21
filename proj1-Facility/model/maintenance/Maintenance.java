package model.maintenance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by Lanzer on 3/19/17.
 */
public class Maintenance implements IMaintenance {

    private List<Request> maintRequests = new Vector<Request>();
    //private List maintRequests;


    public Maintenance () {

    }

    public Maintenance (List<Request> listReq) {
        this.maintRequests = listReq;
    }

    public List<Request> getRequests (){
        return maintRequests;
    }

    //REQUIRED METHOD
    @Override
    public Request makeFacilityMaintRequest(int facID, int reqID, String reqDesc) {
        Request newRequest = new Request (facID, reqID, reqDesc);
        maintRequests.add(newRequest);
        System.out.println("Request with ID " + newRequest.getID() + " has been submitted successfully...");
        return newRequest;
    }

    //REQUIRED METHOD
    @Override
    public Calendar scheduleMaintenance(int maintID, String maintenanceDate) {
        for (int i = 0; i < maintRequests.size(); i++) {
            if (maintID == maintRequests.get(i).getID()) {
                String dateString = maintenanceDate;

// format for year and month
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddkkmm");
// parse the date
                Date date = null;
                try {
                    date = format.parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                System.out.println(cal.getTime());
                maintRequests.get(i).setDateScheduled(cal);
                maintRequests.get(i).setScheduled(true);
                return cal;
            }
        }
        System.out.println("ID not found");
        return null;
    }

    //REQUIRED METHOD
    @Override
    public double calcMaintenanceCostForFacility(Integer facID) {
        double totalCost = 0;
        for(int i=0;i<maintRequests.size();i++){
            if(maintRequests.get(i).getFacID() == facID) {
                double cost = maintRequests.get(i).getCost();
                totalCost = totalCost + cost;
            }
        }
        System.out.println("The Total Cost is " + totalCost);
        return totalCost;
    }

    //REQUIRED METHOD
    //Calculates ratio of problems/requests completed versus
    @Override
    public double calcProblemRateForFacility(Integer facId) {
        double complete = 0;
        double incomplete = 0;
        double scheduled = 0;
        double ratio;

        for (int i = 0; i < maintRequests.size(); i++) {
            if(maintRequests.get(i).getFacID() == facId) {
                if (maintRequests.get(i).getCompleted()) {
                    complete++;
                } else {
                    incomplete++;
                    if (maintRequests.get(i).getScheduled()) {
                        scheduled++;
                    }
                }
            }
        }

        ratio = complete/maintRequests.size();

        System.out.println("Problem Rate (ratio of completed to problems/requests submitted: " + ratio + "\nOf " + incomplete + " incompleted requests, " + scheduled + " have been scheduled.");
        return ratio;
    }

    //REQUIRED METHOD
    @Override
    public double calcDownTimeForFacility(Integer facID) {
        double downtime = 0.0;
        for(int i=0; i<maintRequests.size(); i++){
            if(maintRequests.get(i).getFacID() == facID) {
                downtime = downtime + maintRequests.get(i).getEstimatedWorktime();
            }
        }
        System.out.println("The Downtime is " + downtime);
        return downtime;
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

    //REQUIRED METHOD
    @Override
    public List<Request> listMaintRequests() {

        for (int i = 0; i < maintRequests.size(); i++) {
            Request temp = maintRequests.get(i);
            System.out.println("ID: " + temp.getID());
            System.out.println("Description: " + temp.getDesc());
            System.out.println("Complete: " + temp.getCompleted());
            System.out.println("Scheduled for: " + temp.getDateScheduled());
            System.out.println("The maintenance cost is: " + temp.getCost() + "$");
            System.out.println("The estimated worktime is: " + temp.getEstimatedWorktime() + "hrs");
        }
        return maintRequests;
    }

    //REQUIRED METHOD
    //lists COMPLETED maintenance
    @Override
    public List<String> listMaintenance(Integer facID) {
        Integer facilityID = facID;
        System.out.println("Listing all completed maintenance for Facility " + facilityID + "...");

        for (int i = 0; i < maintRequests.size(); i++) {
            if (maintRequests.get(i).getCompleted() && maintRequests.get(i).getFacID() == facilityID) {
                System.out.println("ID: " + maintRequests.get(i).getID());
                System.out.println("Description: " + maintRequests.get(i).getDesc());
            }
        }
        return null;
    }

    //REQUIRED METHOD
    @Override
    public List<String> listFacilityProblems(Integer facID) {
        List<String> problems = new Vector<String>();
        for (int i = 0; i < maintRequests.size(); i++) {
            if (maintRequests.get(i).getFacID() == facID) {
                String temp = maintRequests.get(i).getDesc();
                System.out.println(temp);
                problems.add(temp);
            }
        }
        return problems;
    }

    public void setMaintRequests(List maintRequests) {
        this.maintRequests = maintRequests;
    }

    public List getMaintRequests() {
        return maintRequests;
    }

    //end IMaintenance methods
}
