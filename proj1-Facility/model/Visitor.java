package model;

import model.use.*;
import model.maintenance.*;

/**
 * Created by dominiqueallen on 4/24/17.
 */
public interface Visitor {
    public void visit(Inspection i);
    public void visit(Event e);
    public void visit(Request r);

}
