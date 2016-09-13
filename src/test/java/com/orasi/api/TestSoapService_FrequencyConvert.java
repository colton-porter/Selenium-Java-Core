package com.orasi.api;

import org.testng.annotations.Test;
import com.MeasurementConverterModule.FrequencyUnitConvertor_Service.operations.ChangeFrequencyUnit;
import com.orasi.utils.Randomness;
import com.orasi.utils.TestReporter;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/*List of Frequency Units:
cyclePersecond, degreePerhour, degreePerminute
degreePersecond, millihertz, hertz
kilohertz, megahertz, gigahertz
terahertz, radianPerhour, radianPerminute
radianPersecond, revolutionPerhour, revolutionPerminute
revolutionPersecond, fresnel*/

public class TestSoapService_FrequencyConvert {
	@Features("API")
	@Stories("SoapService")
	@Test(groups = { "regression", "interfaces", "textbox" }, invocationCount = 5)
	public void FreqConvertTest() {
		ChangeFrequencyUnit getInfo = new ChangeFrequencyUnit("FreqConvertRadPMinToFres");
		getInfo.setFreqValue(Randomness.randomNumber(2));
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No records returned", getInfo);
	}
}
