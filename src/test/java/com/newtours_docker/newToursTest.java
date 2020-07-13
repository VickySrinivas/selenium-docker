package com.newtours_docker;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.docker.selenium_docker.ConfirmationPage;
import com.selenium.docker.selenium_docker.FlightDetailsPage;
import com.selenium.docker.selenium_docker.FlightRegistrationPage;
import com.selenium.docker.selenium_docker.findflightsPage;
import com.selenium.docker.selenium_docker.flightConfirmationPage;

import TestPackage.BaseTest;

public class newToursTest extends BaseTest {

private String noOfPassengers;
private String expectedPrice;

@BeforeTest
@Parameters({"noOfPassengers", "expectedPrice"})
public void setParameters(String noOfPassengers, String expectedPrice) {
	
	this.noOfPassengers = noOfPassengers;
	this.expectedPrice = expectedPrice;
	
}

@Test
public void registrationPageTest() {
	
	FlightRegistrationPage regPage = new FlightRegistrationPage(driver);
	regPage.goTo();
	regPage.enterUserDetails("selenium", "docker");
	regPage.enterUserCredentials("selenium", "docker");
	regPage.clickSubmitbtn();
	
}

@Test(dependsOnMethods = "registrationPageTest")
public void registrationConfirmationPage() {
	
	ConfirmationPage confirmPage = new ConfirmationPage(driver);
	confirmPage.confirmation();
	
}

@Test(dependsOnMethods = "registrationConfirmationPage")
public void flightDetailsPage() {
	
	FlightDetailsPage flightDetails = new FlightDetailsPage(driver);
	flightDetails.selectPassengers(noOfPassengers);
	flightDetails.clickContinueBtn();
	
}

@Test(dependsOnMethods = "flightDetailsPage")
public void findFlightsPage() {
	
	findflightsPage findFlights = new findflightsPage(driver);
	findFlights.clickReserveFlights();
	findFlights.securePurchase();
	
}

@Test(dependsOnMethods = "findFlightsPage")
public void flightConfirmationPage() {
	
	flightConfirmationPage flightConfirm = new flightConfirmationPage(driver);
	String actualPrice = flightConfirm.flightConfirmation();
	Assert.assertEquals(actualPrice, expectedPrice);
	
}

@AfterTest
public void close() {
	
	this.driver.quit();
}






}
