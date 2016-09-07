package com.periodicTable.operations;

import com.orasi.utils.XMLTools;
import com.periodicTable.PeriodicTable;

public class GetAtoms extends PeriodicTable {

	public GetAtoms() {
		setOperationName("GetAtoms");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetAtoms")));
		removeComments();
		removeWhiteSpace();
	}

	public int GetNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetAtomsResponse/GetAtomsResult/NewDataSet/Table");
	}
}
