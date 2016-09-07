package com.orasi.api;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.USZip.operations.GetInfoByAreaCode;
import com.USZip.operations.GetInfoByCityName;
import com.USZip.operations.GetInfoByState;
import com.USZip.operations.GetInfoByZipCode;
import com.orasi.utils.AlertHandler;
import com.orasi.utils.TestReporter;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class TestSoapService_StateInfo {
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void areaCodeTest() {
		GetInfoByAreaCode getInfo = new GetInfoByAreaCode();
		getInfo.setAreaCode("901");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}

	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void cityNameTest() {
		GetInfoByCityName getInfo = new GetInfoByCityName();
		getInfo.setCityName("New York");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}

	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void stateNameTest() {
		GetInfoByState getInfo = new GetInfoByState();
		getInfo.setStateName("CO");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}

	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void zipCodeTest() {
		GetInfoByZipCode getInfo = new GetInfoByZipCode();
		getInfo.setZipCode(27310);
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}

}
