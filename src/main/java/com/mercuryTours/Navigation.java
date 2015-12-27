package com.mercuryTours;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Link;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;

public class Navigation {
	OrasiDriver driver = null;
	/**
	 * Top Navigation Bar
	 */
	@FindBy(xpath="//a[text()='SIGN-ON']") private Link lnkSignOn;
	@FindBy(xpath="//a[text()='REGISTER']") private Link lnkRegister;
	@FindBy(xpath="//a[text()='SUPPORT']") private Link lnkSupport;
	@FindBy(partialLinkText="mercuryunderconst") private Link lnkContact;

	
	/**
	 * Left Navigation Bar
	 */
	@FindBy(partialLinkText="mercurywelcome") private Link lnkHome;
	@FindBy(partialLinkText="mercuryreservation") private Link lnkFlights;
	@FindBy(xpath="//a[text()='Hotels']") private Link lnkHotels;
	@FindBy(xpath="//a[text()='Car Rentals']") private Link lnkCarRentals;
	@FindBy(xpath="//a[text()='Cruises']") private Link lnkCruises;
	@FindBy(xpath="//a[text()='Destinations']") private Link lnkDestinations;
	@FindBy(xpath="//a[text()='Vacations']") private Link lnkVacations;
	
	// *********************
	// ** Build page area **
	// *********************
	public Navigation(OrasiDriver driver){
		this.driver = driver;		
		ElementFactory.initElements(driver, this);
	}

	public boolean pageLoaded(){
		driver.page().isDomComplete();
	    return lnkSignOn.syncVisible();
	}
	
	// *****************************************
	// ***Page Interactions ***
	// *****************************************
	
	/**
	 * Interactions for Top Navigation
	 */
	public void clickSignOn(){
		lnkSignOn.syncVisible();
		lnkSignOn.click();
	}
	
	public void clickRegister(){
		lnkRegister.syncVisible();
		lnkRegister.click();
	}
	
	public void clickSupport(){
		lnkSupport.syncVisible();
		lnkSupport.click();
	}
	
	public void clickContact(){
		lnkContact.syncVisible();
		lnkContact.click();
	}
	/**
	 * Interactions for Side Navigation
	 */
	public void clickHome(){
		lnkHome.syncVisible();
		lnkHome.click();
	}
	
	public void clickFlights(){
		lnkFlights.syncVisible();
		lnkFlights.click();
	}
	
	public void clickHotels(){
		lnkHotels.syncVisible();
		lnkHotels.click();
	}
	
	public void clickCarRentals(){
		lnkCarRentals.syncVisible();
		lnkCarRentals.click();
	}
	
	public void clickCruises(){
		lnkCruises.syncVisible();
		lnkCruises.click();
	}
	
	public void clickDestinations(){
		lnkDestinations.syncVisible();
		lnkDestinations.click();
	}
	
	public void clickVacations(){
		lnkVacations.syncVisible();
		lnkVacations.click();
	}
}
