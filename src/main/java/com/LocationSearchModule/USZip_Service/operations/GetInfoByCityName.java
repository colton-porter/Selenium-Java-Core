package com.LocationSearchModule.USZip_Service.operations;


import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.XMLTools;

public class GetInfoByCityName extends USZip {

	public GetInfoByCityName() {

		setOperationName("GetInfoByCityName");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetInfoByCity")));
		removeComments();
		removeWhiteSpace();
	}

	public void setCityName(String cityName) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByCity/USCity", cityName);
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetInfoByCityResponse/GetInfoByCityResult/NewDataSet/Table");
	}

}
