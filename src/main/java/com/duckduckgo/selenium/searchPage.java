package com.duckduckgo.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id = "search_form_input_homepage")
	private WebElement searchBox;
	
	@FindBy(id = "search_button_homepage")
	private WebElement searchBtn;
	
	@FindBy(linkText = "Videos")
	private WebElement videoLink;
	
	@FindBy(className = "tile--vid")
	private List<WebElement> videoLinkCount;
	
	
	public searchPage(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	public void goTo() {
		
		this.driver.get("https://duckduckgo.com/");
		this.wait.until(ExpectedConditions.visibilityOf(searchBox));
		
	}
	
	public void enterData(String value) {
		
		this.searchBox.sendKeys(value);
		this.searchBtn.click();
		
	}
	
	public void goToVideos() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(videoLink));
		this.videoLink.click();
		
	}
	
	public int getResultCount() {
		
		By by = By.className("tile--vid");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		int count = this.videoLinkCount.size();
		return count;
		
	}
	

}
