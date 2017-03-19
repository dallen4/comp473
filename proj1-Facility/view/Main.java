package view;

import model.facility.Facilities;
import model.facility.Facility;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {

		Calendar calendar = new GregorianCalendar();

		System.out.println("Starting Facility Management System... \n");

		// Creating our facilities 'Loyola'
		System.out.println("Creating Facilities object to manage Facility list...\n");
		Facilities Loyola = new Facilities();

		// Creating our first facilities 'Damen'
		System.out.println("Creating facilities... \n");

		
		
		//END TESTS OF USE INTERFACE REQUIREMENTS
		System.out.println("ending program....");
	}

}
