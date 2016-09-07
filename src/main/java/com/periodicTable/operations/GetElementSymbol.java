package com.periodicTable.operations;

import com.orasi.utils.XMLTools;
import com.periodicTable.PeriodicTable;

public class GetElementSymbol extends PeriodicTable {

	public GetElementSymbol() {
		setOperationName("GetElementSymbol");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetElementSymbol")));
		removeComments();
		removeWhiteSpace();
	}

	public void setElementName(String elementName) {
		setRequestNodeValueByXPath("/Envelope/Body/GetElementSymbol/ElementName", elementName);
	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetElementSymbolResponse/GetElementSymbolResult/NewDataSet/Table");
	}
}
