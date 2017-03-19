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

    private String name;
    private List<Request> maintRequests = new Vector<Request>();


    //REQUIRED METHOD
    @Override
    public Request makeFacilityMaintRequest(int reqID, String reqDesc) {
        Request newRequest = new Request (reqID, reqDesc);
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
                return cal;
            }
        }
        System.out.println("ID not found");
        return null;
    }

    //REQUIRED METHOD
    @Override
    public double calcMaintenanceCostForFacility() {
        double totalCost = 0;
        for(int i=0;i<maintRequests.size();i++){
            double cost = maintRequests.get(i).getCost();
            totalCost = totalCost + cost;
        }
        return totalCost;
    }

    //REQUIRED METHOD
    //Calculates ratio of problems/requests completed versus
    @Override
    public double calcProblemRateForFacility() {
        double complete = 0;
        double incomplete = 0;
        double scheduled = 0;
        double ratio;

        for (int i = 0; i < maintRequests.size(); i++) {
            if (maintRequests.get(i).getCompleted()) {
                complete++;
            } else {
                incomplete++;
                if (maintRequests.get(i).getScheduled()) {
                    scheduled++;
                }
            }
        }

        ratio = complete/maintRequests.size();

        System.out.println("Problem Rate (ratio of completed to problems/requests submitted: " + ratio + "\nOf " + incomplete + " incompleted requests, " + scheduled + " have been scheduled.");
        return ratio;
    }

    //REQUIRED METHOD
    @Override
    public double calcDownTimeForFacility() {
        double downtime = 0.0;
        for(int i=0; i<maintRequests.size(); i++){
            downtime = downtime + maintRequests.get(i).getEstimatedWorktime();
        }
        return downtime;
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
    public List<String> listMaintenance() {
        System.out.println("Listing all completed maintenance for Facility " + this.name + "...");

        for (int i = 0; i < maintRequests.size(); i++) {
            if (maintRequests.get(i).getCompleted()) {
                System.out.println("ID: " + maintRequests.get(i).getID());
                System.out.println("Description: " + maintRequests.get(i).getDesc());
            }
        }
        return null;
    }

    //REQUIRED METHOD
    @Override
    public List<String> listFacilityProblems() {
        List<String> problems = new Vector<String>();

        for (int i = 0; i < maintRequests.size(); i++) {
            String temp = maintRequests.get(i).getDesc();
            System.out.println(temp);
            problems.add(temp);
        }
        return problems;
    }

    //end IMaintenance methods
}
