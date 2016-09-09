package com.MeasurementConverterModule.TemperatureUnitConvertor_Service;

import com.orasi.api.soapServices.core.SoapService;

public class ConvertTemp extends SoapService{
	
	public ConvertTemp() {
		setServiceName("ConvertTemp");
		setServiceURL("http://www.webservicex.net/ConvertTemperature.asmx?WSDL");
	}

}
