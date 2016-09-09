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
	public void setUKAddressTown(String UKAddressTown){
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/Town", UKAddressTown);
	}
	public void setUKAddressCounty(String UKAddressCounty){
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/County", UKAddressCounty);
	}
	public void setUKAddressPost(String UKAddressPost){
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/PostCode", UKAddressPost);
	}
}