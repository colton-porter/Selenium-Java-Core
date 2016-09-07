package com.LocationSearchModule.AustralianPostCode_Service;

import com.orasi.api.soapServices.core.SoapService;

public class AustralianPostCode extends SoapService{
	
	public AustralianPostCode() {
		setServiceName("AustralianLocationService");
		setServiceURL("http://www.webservicex.net/AustralianPostCode.asmx?WSDL");
	}

}
