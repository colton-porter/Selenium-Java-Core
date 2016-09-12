package com.LocationSearchModule.UKLocation_Service.operationsUK;
import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.XMLTools;

public class GetUKLocationByCounty extends UKLocation{
	
	public GetUKLocationByCounty() { 

		setOperationName("GetUKLocationByCounty");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetUKLocationByCounty")));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setCountyName(String countyName){
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByCounty/County", countyName);
	}
	
	public int getCountyNumber(){
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetUKLocationByCountyResponse/GetUKLocationByCountyResult");
	}
}
