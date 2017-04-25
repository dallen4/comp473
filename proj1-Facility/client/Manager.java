package client;

import model.UsageVisitor;
import model.Visitable;
import model.facility.Facility;
import model.facility.IFacility;
import model.maintenance.IMaintenance;
import model.maintenance.Maintenance;
import model.use.IFacilityUse;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Manager implements ManagerFacade {
	
	private List<IFacility> Facilities;
	private IFacilityUse FacUse;
	private IMaintenance FacMaint;
//	private Maintenance facMaint;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager getManager() {
		return this;
	}


	@Override
	public String toString() {
		return "Manager{" +
				"Facilities=" + Facilities +
				", FacUse=" + FacUse +
				", FacMaint=" + FacMaint +
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
		this.Facilities = Facilities;
	}

	public List getFacilities() {
		return Facilities;
	}

	public double calculateFacilityUsage() {

		UsageVisitor visitor = new UsageVisitor();

		ArrayList<Visitable> items = new ArrayList<Visitable>();
		items.addAll(FacUse.getEventList());
		items.addAll(FacUse.getInspections());


		for (Visitable v: items) {
			v.accept(visitor);
		}

		double totalUsage = visitor.getTotalUsage();

		return totalUsage;
	}

}
