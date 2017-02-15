package facility;

import java.util.List;
import java.util.Vector;

import facility.Facility;

public class Facilities {
	
	private List<Facility> Facilities = new Vector<Facility>();

	public Facilities() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean addNewFacility(Facility newFacility) {
		return Facilities.add(newFacility);
	}
	
	public boolean removeFacility (Facility delFacility) {
		return Facilities.remove(delFacility);
	}
}
