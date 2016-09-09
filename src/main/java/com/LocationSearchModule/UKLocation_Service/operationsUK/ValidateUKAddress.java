package com.LocationSearchModule.UKLocation_Service.operationsUK;

import com.orasi.api.soapServices.core.SoapService;
import com.orasi.utils.XMLTools;

public class ValidateUKAddress  extends SoapService{
	
	public ValidateUKAddress() {


		setOperationName("ValidateUKAddress");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ValidateUKAddress")));
		removeComments();
		removeWhiteSpace();
	}
	public void setUKAddress(String UKAddresss){
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByCounty/County", UKAddresss);
	}
}