package com.LocationSearchModule.UKLocation_Service.operationsUK;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.XMLTools;

public class GetUKbyPostalCode extends UKLocation {

	public GetUKbyPostalCode() {

		setOperationName("GetUKLocationByPostCode");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetUKLocationByPostCode")));
		removeComments();
		removeWhiteSpace();
	}

	public void setPostCode(String PostCode) {
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByPostCode/PostCode", PostCode);
	}

	public int getPostNumber() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetUKLocationByPostCodeResponse/GetUKLocationByPostCodeResult");
	}

	public Boolean getstuff() {
		String x = getResponseNodeValueByXPath(
				"/Envelope/Body/GetUKLocationByPostCodeResponse/GetUKLocationByPostCodeResult");
		if (x.contains("Didcot")) {
			return true;

		} else
			return false;
	}
}
