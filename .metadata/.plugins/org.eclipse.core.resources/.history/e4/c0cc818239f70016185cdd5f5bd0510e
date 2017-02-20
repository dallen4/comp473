package model.facility;

import java.util.List;
import java.util.Vector;

public class Facilities {
	
	private List<Facility> Facilities = new Vector<Facility>();

	public Facilities() {
		// TODO Auto-generated constructor stub
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
	public List<Facility> listFacilities() {
		List<Facility> facList = new Vector<Facility>();
		System.out.print("The facilities you have are: ");
		for (int i = 0; i < Facilities.size(); i++) {
			facList.add(Facilities.get(i));
			System.out.println(facList.get(i).getName());
		}
		return facList;
	}
}
