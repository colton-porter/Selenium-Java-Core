package com.mercuryTours.flights;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Element;
import com.orasi.core.interfaces.Listbox;
import com.orasi.core.interfaces.RadioGroup;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;

public class FlightFinder {
	OrasiDriver driver = null;
	FlightFinderOutputDetails output = null;
	/**
	 * Flight Details Area
	 */
	@FindBy(xpath="//img[@src='/images/masts/mast_flightfinder.gif']") private Element eleFlightFinderImage;
	@FindBy(name="tripType") private RadioGroup radType;
	@FindBy(name="passCount") private Listbox lstPassengers;
	@FindBy(name="fromPort") private Listbox lstDepartingFrom;
	@FindBy(name="fromMonth") private Listbox lstDepartingMonth;
	@FindBy(name="fromDay") private Listbox lstDepartingDay;
	@FindBy(name="toPort") private Listbox lstArrivingIn;
	@FindBy(name="toMonth") private Listbox lstReturnMonth;
	@FindBy(name="toDay") private Listbox lstReturnDay;
	
	/**
	 * Preferences Area
	 */
	@FindBy(name="servClass") private RadioGroup radServiceClass;
	@FindBy(name="airline") private Listbox lstAirline;
	@FindBy(name="findFlights") private Button btnContinue;

	// *********************
	// ** Build page area **
	// *********************
	public FlightFinder(OrasiDriver driver){
		this.driver = driver;		
		ElementFactory.initElements(driver, this);
		
	}

	public boolean pageLoaded(){
		driver.page().isDomComplete();
	    return eleFlightFinderImage.syncVisible();
	}
	
	// *****************************************
	// ***Page Interactions ***
	// *****************************************
/*	public void populateWithRandomDetails(){
		populateDetails(radType.getAllOptions().get(Randomness.))
	}*/
	
	public void populateDetails(String type, String passengers, String departFromCity, String departMonth, String departDay, String arriveInCity, String returnMonth, String returnDay, String classType, String airline){
		lstPassengers.syncVisible();
		radType.selectByOption(type);
		lstPassengers.select(passengers);
		lstDepartingFrom.select(departFromCity);
		lstDepartingMonth.select(departMonth);
		lstDepartingDay.select(departDay);
		lstArrivingIn.select(arriveInCity);
		lstReturnMonth.select(returnMonth);
		lstReturnDay.select(returnDay);
		
		radServiceClass.selectByOption(classType);
		lstAirline.select(airline);

		output = new FlightFinderOutputDetails(radType.getSelectedOption(), 
				lstPassengers.getFirstSelectedOption().getText(),
				lstDepartingFrom.getFirstSelectedOption().getText(),
				lstDepartingMonth.getFirstSelectedOption().getText(),
				lstDepartingDay.getFirstSelectedOption().getText(),
				lstArrivingIn.getFirstSelectedOption().getText(),
				lstReturnMonth.getFirstSelectedOption().getText(), 
				lstReturnDay.getFirstSelectedOption().getText(), 
				radServiceClass.getSelectedOption(), 
				lstAirline.getFirstSelectedOption().getText());
		
		btnContinue.click();
		
	}

	public FlightFinderOutputDetails output(){
		return output;
	}
	
	public class FlightFinderOutputDetails{
		public String type = ""; 
		public String passengers = ""; 
		public String departFromCity = ""; 
		public String departMonth = ""; 
		public String departDay = ""; 
		public String arriveInCity = ""; 
		public String returnMonth = ""; 
		public String returnDay = ""; 
		public String classType = ""; 
		public String airline = "";
		
		public FlightFinderOutputDetails(String type, String passengers, String departFromCity, String departMonth, String departDay, String arriveInCity, String returnMonth, String returnDay, String classType, String airline){
			this.type = type; 
			this.passengers = passengers;
			this.departFromCity = departFromCity; 
			this.departMonth = departMonth; 
			this.departDay = departDay; 
			this.arriveInCity = arriveInCity; 
			this.returnMonth = returnMonth; 
			this.returnDay = returnDay; 
			this.classType = classType; 
			this.airline = airline;
		}
	}
}
