package com.orasi.api;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.periodicTable.operations.GetAtomicNumber;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestSoapService_PeriodicTable {
	
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void areaCodeTest() {
		GetAtomicNumber getInfo = new GetAtomicNumber();
		getInfo.setElementName("Silver");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}

}
