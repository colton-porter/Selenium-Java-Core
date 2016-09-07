package com.periodicTable.operations;

import com.orasi.utils.XMLTools;
import com.periodicTable.PeriodicTable;

public class GetAtomicWeight extends PeriodicTable {

	public GetAtomicWeight() {
		setOperationName("GetAtomicWeight");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetAtomicWeight")));
		removeComments();
		removeWhiteSpace();
	}

	public void setElementName(String elementName) {
		setRequestNodeValueByXPath("/Envelope/Body/GetAtomicWeight/ElementName", elementName);
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetAtomicWeightResponse/GetAtomicWeightResult/NewDataSet/Table");
	}
}
