package com.orasi.mercuryTours.flights;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import com.mercuryTours.LandingPage;
import com.mercuryTours.Navigation;
import com.mercuryTours.flights.FlightFinder;
import com.mercuryTours.signOn.SignOnPage;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;

public class Flights extends TestEnvironment {

    @BeforeTest(alwaysRun=true)
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion", "operatingSystem", "environment" })
    public void setup(@Optional String runLocation, String browserUnderTest, String browserVersion, String operatingSystem, String environment) {
		setApplicationUnderTest("MercuryTours");
		setBrowserUnderTest(browserUnderTest);
		setBrowserVersion(browserVersion);
		setOperatingSystem(operatingSystem);
		setRunLocation(runLocation);
		setTestEnvironment(environment);
	   }

    @AfterMethod(alwaysRun=true)
    public synchronized void closeSession(ITestResult test) {
    	endTest(testName);
    }

    /**
     * Test the ability to login to the main site
     * @author: Justin Phlegar
     * @version: 12/6/2015
     */
    @Features("Flights")
    @Stories("Book a Flight")
    @Severity(SeverityLevel.CRITICAL)
    @Title("Flight - Book a standard flight")
    @Test(groups = { "regression" , "flights" })
    public void testFlights() {	
		testStart("testFlights");
		
		// Login
		Navigation navigation = new Navigation(driver);
		TestReporter.assertTrue(navigation.pageLoaded(),"Verify Navigation pane is displayed");
		navigation.clickSignOn();
	
		SignOnPage signOn = new SignOnPage(driver);
		TestReporter.assertTrue(signOn.pageLoaded(),"Verify Sign-On Page is displayed");
		signOn.login();
		
		FlightFinder flightFinder = new FlightFinder(driver);
		TestReporter.assertTrue(flightFinder.pageLoaded(),"Verify Flight Finder Page is displayed");
		flightFinder.populateDetails("roundtrip", "2", "Paris", "December", "28", "London", "January", "5", "Business","Unified Airlines" );
		System.out.println(flightFinder.output().airline);
		
    }

}