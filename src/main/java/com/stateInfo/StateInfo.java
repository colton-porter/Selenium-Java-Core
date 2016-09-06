package com.stateInfo;

import com.orasi.api.soapServices.core.SoapService;

public class StateInfo extends SoapService{

	public StateInfo() {
	    setServiceName("StateInfoService");
	    setServiceURL("http://www.webservicex.net/uszip.asmx?wsdl");
	}
}
