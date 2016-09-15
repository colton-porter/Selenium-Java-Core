package com.MeasurementConverterModule.TemperatureUnitConvertor_Service.operations;

import com.MeasurementConverterModule.TemperatureUnitConvertor_Service.ConvertTemp;
import com.orasi.utils.XMLTools;

public class ChangeTemperatureUnit extends ConvertTemp{
	
	
	public ChangeTemperatureUnit(String scenario) {
		setOperationName("ChangeTemperatureUnit");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ConvertTemp")));
		setRequestNodeValueByXPath(getTestScenario("/excelsheets/tempConvert.xls", scenario));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setTemperature(String value){
		setRequestNodeValueByXPath("/Envelope/Body/ConvertTemp/Temperature", value); 

	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/ConvertTempResponse/ConvertTempResult");
	}

}
