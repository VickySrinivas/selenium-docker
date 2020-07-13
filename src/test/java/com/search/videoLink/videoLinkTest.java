package com.search.videoLink;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.duckduckgo.selenium.searchPage;

import TestPackage.BaseTest;
import junit.framework.Assert;

public class videoLinkTest extends BaseTest{


@Test
@Parameters({"keyvalue"})
public void getVideosCount(String testValue) {
	
	searchPage searchPage = new searchPage(driver);
	searchPage.goTo();
	searchPage.enterData(testValue);
	searchPage.goToVideos();
	int resultCount = searchPage.getResultCount();
	System.out.println(resultCount);
	Assert.assertTrue(resultCount >0);
	
}



}
