package com.BibleWebServiceModule.Bible_Service;

import com.orasi.api.soapServices.core.SoapService;

public class BibleService extends SoapService{
	
	public BibleService() {
		setServiceName("BibleWebService");
		setServiceURL("http://www.webservicex.net/BibleWebservice.asmx?WSDL");
	}

}
