package com.LocationSearchModule.UKLocation_Service;

import com.orasi.api.soapServices.core.SoapService;

public class UKLocation extends SoapService{
	
	public UKLocation() {
		// TODO Auto-generated constructor stub

	    setServiceName("UKInfoService");
	    setServiceURL("http://www.webservicex.net/uklocation.asmx?wsdl");
	}
}
