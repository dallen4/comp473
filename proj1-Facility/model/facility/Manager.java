package model.facility;

import model.maintenance.IMaintenance;
import model.maintenance.Maintenance;
import model.use.FacilityUse;
import model.use.IFacilityUse;

import java.util.List;
import java.util.Vector;

public class Manager {
	
	private List<IFacility> Facilities = new Vector<IFacility>();
	private IFacilityUse FacUse = new FacilityUse();
	private IMaintenance FacMaint = new Maintenance();

	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public List<IFacility> getFacilities () {
		return Facilities;
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

	public FacilityUse getFacilityUse () {
		return (FacilityUse) FacUse;
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
}
