package com.orasi.api;

import org.testng.annotations.Test;

import com.LocationSearchModule.UKLocation_Service.operationsUK.GetUKLocationByCounty;
import com.orasi.utils.TestReporter;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestSoapService_UK {

	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void CountyNameTest() {
		GetUKLocationByCounty getInfo = new GetUKLocationByCounty();
		getInfo.setCountyName("Essex");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getCountyNumber() == 0, "No records returned", getInfo);
	}
}