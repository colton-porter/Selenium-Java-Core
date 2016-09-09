package com.MeasurementConverterModule.FrequencyUnitConvertor_Service;

import com.orasi.api.soapServices.core.SoapService;

public class ConvertFrequency extends SoapService {
	
	public ConvertFrequency() {
		setServiceName("ConvertFrequency");
		setServiceURL("http://www.webservicex.net/convertFrequency.asmx?WSDL");
	}

}
