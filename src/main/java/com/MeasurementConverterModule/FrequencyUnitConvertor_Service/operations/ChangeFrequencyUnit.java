package com.MeasurementConverterModule.FrequencyUnitConvertor_Service.operations;

import com.MeasurementConverterModule.FrequencyUnitConvertor_Service.ConvertFrequency;
import com.orasi.utils.XMLTools;

public class ChangeFrequencyUnit extends ConvertFrequency{
	
	public ChangeFrequencyUnit() {
		setOperationName("ChangeFrequencyUnit");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("ChangeFrequencyUnit")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setAndConvertFreq(int value,String fromUnit,String toUnit){
		setRequestNodeValueByXPath("/Envelope/Body/ChangeFrequencyUnit/FrequencyValue", String.valueOf(value));
		setRequestNodeValueByXPath("/Envelope/Body/ChangeFrequencyUnit/fromFrequencyUnit", fromUnit);
		setRequestNodeValueByXPath("/Envelope/Body/ChangeFrequencyUnit/toFrequencyUnit", toUnit);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/ChangeFrequencyUnitResponse/ChangeFrequencyUnitResult/NewDataSet/Table");
	}

}
