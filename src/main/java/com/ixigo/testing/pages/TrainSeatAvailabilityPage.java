package com.ixigo.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ixigo.testing.utilities.AllUtilityFunctions;
import com.ixigo.testing.utilities.BaseClass;

public class TrainSeatAvailabilityPage {

	//webelement locator
	@FindBy(xpath="(//input[@data-testid='autocompleter-input'])[1]")
	private WebElement FromStation;

	
	@FindBy(xpath="(//input[@data-testid='autocompleter-input'])[2]")
	private WebElement ToStation;
	
	@FindBy(xpath="//button[.='›']")
	private WebElement arrow;
	
	@FindBy(css="[data-testid='tomorrow']")
	private WebElement DepartureDate;
	
    
	
	@FindBy(xpath="//button[.='Check Availability']")
	private WebElement checkseat;

	@FindBy(xpath="//h1[.='Check Seat Availability']")
	private WebElement seatpage;
	
	//getter method
	public WebElement getFromStation() {
		return FromStation;
	}

	public WebElement getToStation() {
		return ToStation;
	}

	public WebElement getDepartureDate() {
		return DepartureDate;
	}

	public WebElement getCheckseat() {
		return checkseat;
	}
	
	//bussiness logic
	public void enterstation(String from,String To)  {
		AllUtilityFunctions.waitForVisibility(BaseClass.driver, seatpage, 20);

		AllUtilityFunctions.waitForClickable(BaseClass.driver, FromStation, 30);
	    getFromStation().click();
	    //getFromStation().sendKeys(from,Keys.ENTER);
	    AllUtilityFunctions.waitForClickable(BaseClass.driver, FromStation, 30);
	    WebElement dropdownfrom=BaseClass.driver.findElement(By.xpath ("/html/body/main/div[4]/div/div[2]/div[3]/div/div[2]/div/div[3]/div[1]")); 
		AllUtilityFunctions.waitForVisibility(BaseClass.driver, dropdownfrom, 30);
		AllUtilityFunctions.doubleClick(BaseClass.driver, dropdownfrom);
		AllUtilityFunctions.waitForClickable(BaseClass.driver, ToStation, 30);
		AllUtilityFunctions.waitForClickable(BaseClass.driver, ToStation, 30);
		getToStation().click();
		//getToStation().sendKeys(To,Keys.ENTER);
		
		WebElement dropdownTo=BaseClass.driver.findElement(By.xpath ("/html/body/main/div[4]/div/div[2]/div[3]/div/div[2]/div/div[3]/div[1]/svg"));
		AllUtilityFunctions.waitForVisibility(BaseClass.driver, dropdownTo, 30);
		AllUtilityFunctions.doubleClick(BaseClass.driver, dropdownTo);
		
		
		AllUtilityFunctions.waitForClickable(BaseClass.driver, checkseat, 20);
		getDepartureDate().click();
		
		
	}

	public void clickseatcheck() {
		AllUtilityFunctions.waitForClickable(BaseClass.driver, checkseat, 20);
		getCheckseat().click();
	}
}
