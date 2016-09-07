package com.periodicTable.operations;

import com.orasi.utils.XMLTools;
import com.periodicTable.PeriodicTable;

public class GetAtomicNumber extends PeriodicTable {

	public GetAtomicNumber() {
		setOperationName("GetAtomicNumber");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetAtomicNumber")));
		removeComments();
		removeWhiteSpace();
	}

	public void setElementName(String elementName) {
		setRequestNodeValueByXPath("/Envelope/Body/GetAtomicNumber/ElementName", elementName);
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetAtomicNumberResponse/GetAtomicNumberResult/NewDataSet/Table");
	}

}
