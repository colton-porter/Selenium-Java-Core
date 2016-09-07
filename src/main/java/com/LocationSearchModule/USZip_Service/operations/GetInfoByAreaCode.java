package com.LocationSearchModule.USZip_Service.operations;


import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.XMLTools;

public class GetInfoByAreaCode extends USZip {
	public GetInfoByAreaCode() {

		// Generate a request from a project xml file
		setOperationName("GetInfoByAreaCode");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetInfoByAreaCode")));
		removeComments();
		removeWhiteSpace();
	}

	public void setAreaCode(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByAreaCode/USAreaCode", value);
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetInfoByAreaCodeResponse/GetInfoByAreaCodeResult/NewDataSet/Table");
	}
}
