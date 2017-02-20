package model.maintenance;


import java.util.List;
import java.util.Vector;

public class Cost {

	private List<Integer> allCosts = new Vector<Integer>();

	// Gets the vector of all the costs
	public List<Integer> getCost() { return allCosts;}

	// Sets the vector of all the costs
	public void setCost(int cost){ allCosts.add(cost);}

	// Sums up all costs
	public double calcMaintenanceCostForFacility(List<Integer> Cost) {
		int totalCost = 0;
		for (int i=0; i < Cost.size(); i++){
			totalCost = totalCost + Cost.get(i);
		}
		return totalCost;
	}

	public Cost() {
		// TODO Auto-generated constructor stub
	}

}
