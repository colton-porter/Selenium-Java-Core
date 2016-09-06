package com.stateInfo.operations;

import com.orasi.utils.XMLTools;
import com.stateInfo.StateInfo;

public class GetInfoByCityName extends StateInfo {

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
