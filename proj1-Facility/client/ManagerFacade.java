package client;

import model.facility.Facility;
import model.maintenance.IMaintenance;
import model.maintenance.Maintenance;
import model.use.IFacilityUse;

import java.util.List;

/**
 * Created by dominiqueallen on 4/24/17.
 */
public interface ManagerFacade {
    public Manager getManager();
    public boolean addNewFacility(Facility newFacility);
    public boolean removeFacility (Facility delFacility);
    public void listFacilities();
    public boolean setFacilityUse(IFacilityUse newUse);
    public boolean setFacilityMaintenance(IMaintenance newMaint);
    public Maintenance getFacilityMaintenance ();
    public void setFacilities(List Facilities);
    public List getFacilities();
    public double calculateFacilityUsage();
}
