package com.selenium.docker.selenium_docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class findflightsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "reserveFlights")
	private WebElement reserveFlights;
	
	@FindBy(name = "buyFlights")
	private WebElement buyFlightsBtn;
	
	public findflightsPage(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickReserveFlights() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveFlights));
		this.reserveFlights.click();
		
	}
	
	public void securePurchase() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(this.buyFlightsBtn));
		this.buyFlightsBtn.click();
		
	}
	
	

}
