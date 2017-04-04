package model.facility;

import model.maintenance.IMaintenance;
import model.maintenance.Maintenance;
import model.use.FacilityUse;
import model.use.IFacilityUse;

import java.util.List;
import java.util.Vector;

public class Manager {
	
	private List<IFacility> Facilities;
	private IFacilityUse FacUse;
	private IMaintenance FacMaint;
	private List facilities;
	private Maintenance facMaint;
	private FacilityUse facilityUse;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Manager{" +
				"Facilities=" + Facilities +
				", FacUse=" + FacUse +
				", FacMaint=" + FacMaint +
				", facilities=" + facilities +
				", facMaint=" + facMaint +
				", facilityUse=" + facilityUse +
				'}';
	}

	//REQUIRED METHOD
	public boolean addNewFacility(Facility newFacility) {
		return Facilities.add(newFacility);
	}
	
	//REQUIRED METHOD
	public boolean removeFacility (Facility delFacility) {
		return Facilities.remove(delFacility);
	}
	
	//REQUIRED METHOD
	public void listFacilities() {
		List<Facility> facList = new Vector<Facility>();
		System.out.print("The facilities you have are: \n");
		for (int i = 0; i < Facilities.size(); i++) {
			facList.add(Facilities.get(i).getFacility());
			System.out.println(facList.get(i).getFacility().getName());
		}
		return;
	}

	public boolean setFacilityUse(IFacilityUse newUse) {
		this.FacUse = newUse;

		if (FacUse == newUse) {
			return true;
		} else {
			return false;
		}
	}


	public boolean setFacilityMaintenance(IMaintenance newMaint) {
		this.FacMaint = newMaint;

		if (FacMaint == newMaint) {
			return true;
		} else {
			return false;
		}
	}

	public Maintenance getFacilityMaintenance () {
		return (Maintenance) FacMaint;
	}

	public void setFacilities(List Facilities) {
		facilities = Facilities;
	}

	public List getFacilities() {
		return facilities;
	}

	public void setFacMaint(Maintenance facMaint) {
		this.facMaint = facMaint;
	}

	public Maintenance getFacMaint() {
		return facMaint;
	}

	public void setFacilityUse(FacilityUse facilityUse) {
		this.facilityUse = facilityUse;
	}

	public FacilityUse getFacilityUse() {
		return facilityUse;
	}
}
