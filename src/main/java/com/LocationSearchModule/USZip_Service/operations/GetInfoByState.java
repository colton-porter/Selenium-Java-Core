package com.LocationSearchModule.USZip_Service.operations;


import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.XMLTools;

public class GetInfoByState extends USZip {

	public GetInfoByState() {
		setOperationName("GetInfoByState");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetInfoByState")));
		removeComments();
		removeWhiteSpace();
	}

	public void setStateName(String stateName) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByState/USState", stateName);
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetInfoByStateResponse/GetInfoByStateResult/NewDataSet/Table");
	}

}
