package com.orasi.api;

import org.testng.annotations.Test;

import com.MeasurementConverterModule.TemperatureUnitConvertor_Service.operations.ChangeTemperatureUnit;
import com.orasi.utils.TestReporter;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestSoapService_TemperatureConvert {
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" })
	public void TempConvertTest() {
		ChangeTemperatureUnit getInfo = new ChangeTemperatureUnit();
		getInfo.setAndConvertUnit(105, "degreeCelsius", "degreeFahrenheit");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}
	
}
