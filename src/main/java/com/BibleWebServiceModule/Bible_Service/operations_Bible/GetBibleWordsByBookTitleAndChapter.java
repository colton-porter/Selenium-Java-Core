package com.BibleWebServiceModule.Bible_Service.operations_Bible;

import com.BibleWebServiceModule.Bible_Service.BibleService;
import com.orasi.utils.XMLTools;

public class GetBibleWordsByBookTitleAndChapter extends BibleService{
	
	public GetBibleWordsByBookTitleAndChapter(String scenario) {
		setOperationName("GetBibleWordsByBookTitleAndChapter");
		setRequestDocument(XMLTools.loadXML(buildRequestFromWSDL("GetBibleWordsByBookTitleAndChapter")));
		setRequestNodeValueByXPath(getTestScenario("/excelsheets/bibleWordsByBookTitleAndChapter", scenario));
		removeComments();
		removeWhiteSpace();
	}
	
	public void setTitle(String title){
		setRequestNodeValueByXPath("/Envelope/Body/GetBibleWordsByBookTitleAndChapter/BookTitle", title);
	}
	
	public void setChapter(String chpt){
		setRequestNodeValueByXPath("/Envelope/Body/GetBibleWordsByBookTitleAndChapter/chapter", chpt);
	}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Evelope/Body/GetBibleWordsByBookTitleAndChapterResponse/GetBibleWordsByBookTitleAndChapterResult");
	}

}
