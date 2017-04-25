package model;

import model.use.Inspection;
import model.maintenance.Request;
import model.use.Event;

/**
 * Created by dominiqueallen on 4/24/17.
 */
public class UsageVisitor implements Visitor {

    private double totalUsage;

    @Override
    public void visit(Inspection i) {
        totalUsage += i.getEstimatedInspectionTime();
    }

    @Override
    public void visit(Event e) {
        totalUsage += e.getEstimatedDuration();
    }

    @Override
    public void visit(Request r) {
        totalUsage += r.getEstimatedWorktime();
    }

    public double getTotalUsage() {
        return totalUsage;
    }
}
