package com.mercuryTours.flights;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Element;
import com.orasi.core.interfaces.Listbox;
import com.orasi.core.interfaces.RadioGroup;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.Sleeper;

public class FlightFinder {
	OrasiDriver driver = null;
	Map<String, Object> data = new HashMap<String, Object>();
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
	public FlightFinder(OrasiDriver driver, Map<String, Object> data){
		this.driver = driver;		
		this.data = data;
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
	
	public Map<String, Object> populateDetails(String type, String passengers, String departFromCity, String departMonth, String departDay, String arriveInCity, String returnMonth, String returnDay, String classType, String airline){
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

		outputData();
		btnContinue.click();
		return data;
	}

	private void outputData(){
		data.put("FlightType", radType.getSelectedOption()); 
		data.put("NumberPassengers", lstPassengers.getFirstSelectedOption().getText());
		data.put("DepartureCity", lstDepartingFrom.getFirstSelectedOption().getText());
		data.put("DepartureMonth", lstDepartingMonth.getFirstSelectedOption().getText());
		data.put("DepartureDay", lstDepartingDay.getFirstSelectedOption().getText());
		data.put("ArrivalCity", lstArrivingIn.getFirstSelectedOption().getText());
		data.put("ReturnMonth", lstReturnMonth.getFirstSelectedOption().getText()); 
		data.put("ReturnDay", lstReturnDay.getFirstSelectedOption().getText());
		data.put("ServiceClass", radServiceClass.getSelectedOption());
		data.put("AirlineName", lstAirline.getFirstSelectedOption().getText());
	}
}
