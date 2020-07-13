package com.selenium.docker.selenium_docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightRegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "firstName")
	private WebElement firstNameText;
	
	@FindBy(name = "lastName")
	private WebElement lastNameText;
	
	@FindBy(name = "email")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement passWordText;
	
	@FindBy(name = "confirmPassword")
	private WebElement confirmPwd;
	
	@FindBy(name = "register")
	private WebElement submitBtn;
	
	public FlightRegistrationPage(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	public void goTo() {
		
		this.driver.get("http://www.newtours.demoaut.com/mercuryregister.php");
		this.wait.until(ExpectedConditions.visibilityOf(firstNameText));
		
	}
	
	public void enterUserDetails(String firstName, String lastName) {
		
		this.firstNameText.sendKeys(firstName);
		this.lastNameText.sendKeys(lastName);
		
	}
	
	public void enterUserCredentials(String userName, String passWord) {
		
		this.userName.sendKeys(userName);
		this.passWordText.sendKeys(passWord);
		this.confirmPwd.sendKeys(passWord);
		
	}
	
	public void clickSubmitbtn() {
		
		this.submitBtn.click();
		
	}
	
	
	
	

}
