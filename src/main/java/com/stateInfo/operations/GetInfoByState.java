package com.stateInfo.operations;

import com.orasi.utils.XMLTools;
import com.stateInfo.StateInfo;

import jxl.read.biff.SharedStringFormulaRecord;

public class GetInfoByState extends StateInfo {

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
