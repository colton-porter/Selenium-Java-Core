package com.LocationSearchModule.UKLocation_Service.operationsUK;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.XMLTools;

public class ValidateUKAddress extends UKLocation{
	
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