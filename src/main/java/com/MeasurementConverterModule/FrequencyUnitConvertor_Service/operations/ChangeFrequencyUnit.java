package com.MeasurementConverterModule.FrequencyUnitConvertor_Service.operations;

import com.MeasurementConverterModule.FrequencyUnitConvertor_Service.ConvertFrequency;
import com.orasi.utils.XMLTools;

public class ChangeFrequencyUnit extends ConvertFrequency{
	
	public ChangeFrequencyUnit(String scenario) {
		setOperationName("ChangeFrequencyUnit");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ChangeFrequencyUnit")));
		setRequestNodeValueByXPath(getTestScenario("/excelsheets/freqConvert.xls", scenario));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setFreqValue(String value){
		setRequestNodeValueByXPath("/Envelope/Body/ChangeFrequencyUnit/FrequencyValue", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/ChangeFrequencyUnitResponse/ChangeFrequencyUnitResult");
	}

}
