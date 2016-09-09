package com.MeasurementConverterModule.TemperatureUnitConvertor_Service.operations;

import com.MeasurementConverterModule.TemperatureUnitConvertor_Service.ConvertTemp;
import com.orasi.utils.XMLTools;

public class ChangeTemperatureUnit extends ConvertTemp{
	
	public ChangeTemperatureUnit() {
		setOperationName("ChangeTemperatureUnit");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ConvertTemp")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setAndConvertUnit(int value, String fromUnit, String toUnit){
		setRequestNodeValueByXPath("/Envelope/Body/ConvertTemp/Temperature", String.valueOf(value));
		setRequestNodeValueByXPath("/Envelope/Body/ConvertTemp/FromUnit", fromUnit);
		setRequestNodeValueByXPath("/Envelope/Body/ConvertTemp/ToUnit", toUnit);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/ConvertTempResponse/ConvertTempResult");
	}

}
