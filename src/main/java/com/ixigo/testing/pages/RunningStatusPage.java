package com.ixigo.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ixigo.testing.utilities.AllUtilityFunctions;
import com.ixigo.testing.utilities.BaseClass;

public class RunningStatusPage {

	//webelement locator
	@FindBy(xpath="//h2[.='Frequently Asked Questions (FAQs)']")
	private WebElement trainname;

	
	
	//getter methods
	public WebElement getTrainname() {
		return trainname;
	}
	
	
	//bussiness logic 
	public String verifyrunningStatusPage() {
		AllUtilityFunctions.waitForVisibility(BaseClass.driver, trainname, 20);
			return getTrainname().getText();
		
	}
}
