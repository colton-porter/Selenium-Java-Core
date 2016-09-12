package com.LocationSearchModule.UKLocation_Service.operationsUK;

import com.orasi.api.soapServices.core.SoapService;
import com.orasi.utils.XMLTools;

public class ValidateUKAddress extends SoapService{
	
	public ValidateUKAddress() {
		setOperationName("ValidateUKAddress");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ValidateUKAddress")));
		removeComments();
		removeWhiteSpace();
	}
	public void setUKTownCountyPost(String UKAddressTown, String UKAddressCounty, String UKAddressPost){
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/Town", UKAddressTown);
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/County", UKAddressCounty);
		setRequestNodeValueByXPath("/Envelope/Body/ValidateUKAddress/PostCode", UKAddressPost);
	}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath(
			"/Envelope/Body/ValidateUKAddressResponse/ValidateUKAddressResult");
}
}