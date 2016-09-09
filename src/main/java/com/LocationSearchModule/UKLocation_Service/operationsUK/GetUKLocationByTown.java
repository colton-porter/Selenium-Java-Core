package com.LocationSearchModule.UKLocation_Service.operationsUK;
import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.XMLTools;

public class GetUKLocationByTown extends UKLocation{
	
	public GetUKLocationByTown() {


		setOperationName("GetUKLocationByTown");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetUKLocationByTown")));
		removeComments();
		removeWhiteSpace();
	}
	public void setTownName(String townName){
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByTown/Town", townName);
	}


	public int getTownNumber(){
		return getNumberOfResponseNodesByXPath(
			"/Envelope/Body/GetUKLocationByTownResponse/GetUKLocationByTownResult/NewDataSet/Table");
}
}
