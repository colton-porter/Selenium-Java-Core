package com.LocationSearchModule.AustralianPostCode_Service.operations;

import com.LocationSearchModule.AustralianPostCode_Service.AustralianPostCode;
import com.orasi.utils.XMLTools;

public class GetPostCodeByLocation extends AustralianPostCode {

	public GetPostCodeByLocation() {
		setOperationName("GetPostCodeByLocation");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetAustralianPostCodeByLocation")));
		removeComments();
		removeWhiteSpace();
	}

	public void setLocation(String location) {
		setRequestNodeValueByXPath("/Envelope/Body/GetAustralianPostCodeByLocation/Location", location);
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetAustralianPostCodeByLocationResponse/GetAustralianPostCodeByLocationResult/NewDataSet/Table");
	}
}
