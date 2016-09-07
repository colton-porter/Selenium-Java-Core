package com.LocationSearchModule.USZip_Service.operations;


import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.XMLTools;

public class GetInfoByZipCode extends USZip {

	public GetInfoByZipCode() {

		// Generate a request from a project xml file
		// Used to store the Service Operation Name Under Test in memory. Can be
		// retrieved using #getOperationName())
		setOperationName("GetInfoByZIP");
		// Used to store the XML file as a Document object in memory. Can be
		// retrieved using getRequestDocument()
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetInfoByZIP")));
		removeComments();
		removeWhiteSpace();
	}

	public void setZipCode(int zipCode) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByZIP/USZip", String.valueOf(zipCode));
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetInfoByZIPResponse/GetInfoByZIPResult/NewDataSet/Table");
	}

}
