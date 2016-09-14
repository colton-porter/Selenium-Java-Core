package com.orasi.api.bibleService;

import org.testng.annotations.Test;

import com.BibleWebServiceModule.Bible_Service.operations_Bible.GetBibleWordsByBookTitleAndChapter;
import com.orasi.utils.TestReporter;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class PositiveTest_BibleService {
  @Features("API")
  @Stories("SoapService")
  @Test(groups = {"regression", "interfaces", "textbox"})
  public void getBibleWordsByBookTitleAndChapterTest() {
	  GetBibleWordsByBookTitleAndChapter getInfo = new GetBibleWordsByBookTitleAndChapter("wordsByTitleAndChapter");
	  getInfo.setTitle("Genesis");
	  getInfo.setChapter("1");
	  getInfo.sendRequest();
	  TestReporter.logAPI(getInfo.getNumberOfResults() == 0, "No reults were found", getInfo);
  }
}
