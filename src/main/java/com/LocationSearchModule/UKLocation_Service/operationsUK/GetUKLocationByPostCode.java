package com.LocationSearchModule.UKLocation_Service.operationsUK;
import com.orasi.api.soapServices.core.SoapService;
import com.orasi.utils.XMLTools;


public class GetUKLocationByPostCode extends SoapService{
	
	public GetUKLocationByPostCode() {


		setOperationName("GetUKLocationByPostCode");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetUKLocationByPostCode")));
		removeComments();
		removeWhiteSpace();
	}

	public void setPostCode(String PostCode){
		setRequestNodeValueByXPath("/Envelope/Header/Body/GetUKLocationByPostCode/PostCode", PostCode);
	}
	
	public int getPostNumber(){
		return getNumberOfResponseNodesByXPath(
				"/Envelope/Body/GetUKLocationByPostCodeResponse/GetUKLocationByPostCodeResult");
	}
}
