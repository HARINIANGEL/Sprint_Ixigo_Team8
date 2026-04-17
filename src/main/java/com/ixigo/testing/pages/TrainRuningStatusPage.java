package com.ixigo.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ixigo.testing.utilities.AllUtilityFunctions;
import com.ixigo.testing.utilities.BaseClass;
import com.ixigo.testing.utilities.Pages;

public class TrainRuningStatusPage {

	
	
	@FindBy(xpath="//input[@data-testid='autocompleter-input']")
	private WebElement searchTrain;
	
	@FindBy(xpath="//h1[.='Train Running Status']")
	private WebElement page;
	
	@FindBy(xpath="//button[.='Check Live Status']")
	private WebElement check;
	
	@FindBy(xpath = "//p[contains(text(), '19037')]")
	private WebElement dropdown;
	
	//getter method 
	public WebElement getSearchTrain() {
		return searchTrain;
	}
	public WebElement getdropdown() {
		return dropdown;
	}
	public WebElement getCheck() {
		return check;
	}
	
	
	
	//bussiness logic
	public void clickcheck() {
		AllUtilityFunctions.waitForClickable(BaseClass.driver, check, 20);
		getCheck().click();
	}
	public void searchtrainfield() {
	    // We use a local wait with a 'By' locator to avoid StaleElement issues

	    AllUtilityFunctions.waitForVisibility(BaseClass.driver, page, 20);
	    AllUtilityFunctions.waitForClickable(BaseClass.driver, searchTrain, 20);
	    getSearchTrain().click();
	}

	public void entertrainname(String s, WebDriver driver) throws InterruptedException {
	    // 1. Wait for page header
	    AllUtilityFunctions.waitForVisibility(driver, page, 10);

	    // 2. Re-locate the input field to ensure it's fresh after the previous click
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    AllUtilityFunctions.waitForClickable(BaseClass.driver, searchTrain, 20);
	    
	    getSearchTrain().sendKeys(s);

	    // 3. Wait for the specific dropdown item
	    // Use the updated XPath we discussed earlier for 19037
	    AllUtilityFunctions.waitForVisibility(driver, getdropdown(), 20);
	    
	    // 4. Double click the result
	    AllUtilityFunctions.doubleClick(driver, getdropdown());
	}
	
	public void recentSearches(String name,WebDriver driver) {
	 driver.findElement(By.xpath("//p[@class='body-md text-primary truncate font-medium' and text()='"+name+"']")).click();
	}
	
	
}
