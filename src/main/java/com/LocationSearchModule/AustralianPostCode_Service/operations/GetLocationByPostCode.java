package com.LocationSearchModule.AustralianPostCode_Service.operations;

import com.LocationSearchModule.AustralianPostCode_Service.AustralianPostCode;
import com.orasi.utils.XMLTools;

public class GetLocationByPostCode extends AustralianPostCode {

	public GetLocationByPostCode() {
		setOperationName("GetLocationByPostCode");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetAustralianLocationByPostCode")));
		removeComments();
		removeWhiteSpace();
	}

	public void setPostCode(int postCode) {
		setRequestNodeValueByXPath("/Envelope/Body/GetAustralianLocationByPostCode/PostCode", String.valueOf(postCode));
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetAustralianLocationByPostCodeResponse/GetAustralianLocationByPostCodeResult/NewDataSet/Table");
	}
}
