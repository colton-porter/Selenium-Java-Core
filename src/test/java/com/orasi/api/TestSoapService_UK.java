package com.orasi.api;

import org.testng.annotations.Test;

import com.LocationSearchModule.UKLocation_Service.operationsUK.GetUKLocationByCounty;
import com.LocationSearchModule.UKLocation_Service.operationsUK.GetUKLocationByPostCode;
import com.LocationSearchModule.UKLocation_Service.operationsUK.GetUKLocationByTown;
import com.LocationSearchModule.UKLocation_Service.operationsUK.GetUKbyPostalCode;
import com.LocationSearchModule.UKLocation_Service.operationsUK.ValidateUKAddress;

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
		//TestReporter.logAPI(getInfo.getCountyNumber() == 0, "No records returned", getInfo);
	}
	
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void TownNameTest() {
		GetUKLocationByTown getInfo = new GetUKLocationByTown();
		getInfo.setTownName("Norwich");
		getInfo.sendRequest();
		//TestReporter.logAPI(getInfo.getTownNumber() == 0, "No records returned", getInfo);
	}
	
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void PostCodeTest() {
		GetUKbyPostalCode getInfo = new GetUKbyPostalCode();
		getInfo.setPostCode("OX11");
		getInfo.sendRequest();
		//TestReporter.logAPI(getInfo.getPostNumber() == 0, "No records returned", getInfo);
	}
	
	
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void ValidateUKAddressTest() {
		ValidateUKAddress getInfo = new ValidateUKAddress();
		getInfo.setUKAddressTown("London");
		getInfo.setUKAddressCounty("Oxford");
		getInfo.setUKAddressPost("OX11");
		getInfo.sendRequest();
		//TestReporter.logAPI(getInfo.getPostNumber() == 0, "No records returned", getInfo);
	}
	
}