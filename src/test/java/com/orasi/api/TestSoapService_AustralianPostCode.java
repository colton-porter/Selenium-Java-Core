package com.orasi.api;

import org.testng.annotations.Test;

import com.LocationSearchModule.AustralianPostCode_Service.operations.GetLocationByPostCode;
import com.LocationSearchModule.AustralianPostCode_Service.operations.GetPostCodeByLocation;
import com.orasi.utils.TestReporter;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestSoapService_AustralianPostCode {
	
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void postCodeTest() {
		GetLocationByPostCode getInfo = new GetLocationByPostCode();
		getInfo.setPostCode("four");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}

	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void locationTest() {
		GetPostCodeByLocation getInfo = new GetPostCodeByLocation();
		getInfo.setLocation("VIC");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}
	
}
