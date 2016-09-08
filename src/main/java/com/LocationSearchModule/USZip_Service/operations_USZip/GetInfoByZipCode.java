package com.LocationSearchModule.USZip_Service.operations_USZip;


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
		// Used to clean up the data being displayed
		removeComments();
		removeWhiteSpace();
	}
	
	// Takes in a zipCode and sets the request value by xpath
	public void setZipCode(int zipCode) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByZIP/USZip", String.valueOf(zipCode));
	}
	// Calls getNumberOfResponseNodesByXPath which takes an xpath and returns the node list length
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetInfoByZIPResponse/GetInfoByZIPResult/NewDataSet/Table");
	}

}
