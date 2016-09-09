package com.MeasurementConverterModule.ComputerUnitConvertor_Service.operations;

import com.MeasurementConverterModule.ComputerUnitConvertor_Service.ConvertComputer;
import com.orasi.utils.XMLTools;

public class ChangeComputerUnit extends ConvertComputer{
	
	public ChangeComputerUnit() {
		setOperationName("ChangeComputerUnit");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ChangeComputerUnit")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setAndConvertUnit(int value, String fromUnit, String toUnit){
		setRequestNodeValueByXPath("/Envelope/Body/ChangeComputerUnit/ComputerValue", String.valueOf(value));
		setRequestNodeValueByXPath("/Envelope/Body/ChangeComputerUnit/fromComputerUnit", fromUnit);
		setRequestNodeValueByXPath("/Envelope/Body/ChangeComputerUnit/toComputerUnit", toUnit);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/ChangeComputerUnitResponse/ChangeComputerUnitResult/NewDataSet/Table");
	}

}
