package com.orasi.mercuryTours.login;

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
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;

public class LoginFromLandingPage extends TestEnvironment {

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
    @Features("Login")
    @Stories("Logging in from Landing Page")
    @Severity(SeverityLevel.BLOCKER)
    @Title("Login - Login from Landing Page with correct information")
    @Test(groups = { "regression" , "login" })
    public void testLogin() {	
		testStart("testLogin");
		
		// Login
		LandingPage landingPage = new LandingPage(driver);
		TestReporter.assertTrue(landingPage.pageLoaded(),"Verify Landing page is displayed");
		landingPage.login();
	
		// Verify user is logged in
		TestReporter.assertTrue(landingPage.validateLoginStatus(), "Validate the user logged in successfully");
    }
    
    /**
     * Test the ability to login to the main site
     * @author: Justin Phlegar
     * @version: 12/6/2015
     */
    @Features("Login")
    @Stories("Logging in from Landing Page")
    @Severity(SeverityLevel.BLOCKER)
    @Title("Login - Login from Landing Page with incorrect information")
    @Test(groups = { "regression" , "login" })
    public void testLoginNegative() {	
		testStart("testLoginNegative");
		
		// Login
		LandingPage landingPage = new LandingPage(driver);
		TestReporter.assertTrue(landingPage.pageLoaded(),"Verify Landing page is displayed");
		landingPage.loginNegative();
	
		// Verify user is not logged in
		TestReporter.assertFalse(landingPage.validateLoginStatus(), "Validate the user did not log in");
    }
}