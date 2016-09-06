package com.stateInfo.operations;

import com.orasi.utils.XMLTools;
import com.stateInfo.StateInfo;

public class GetInfoByAreaCode extends StateInfo {
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
