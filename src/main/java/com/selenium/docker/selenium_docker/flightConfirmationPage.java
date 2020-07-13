package com.selenium.docker.selenium_docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flightConfirmationPage {

	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//font[contains(text(),'Confirmation')]")
	private WebElement confirmText;
	
	@FindBy(xpath = "//font[contains(text(),'Price')]//../../../../..//following-sibling::td//font[contains(text(),'USD')]")
	private WebElement finalPrice;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffBtn;
	
	
	public flightConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	public String flightConfirmation() {
		
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmText));
		System.out.println(this.confirmText.getText());
		System.out.println(this.finalPrice.getText());
		String text = this.finalPrice.getText();
		this.signOffBtn.click();
		return text;
		
	}
	
	
	
	
}
