package com.ixigo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ixigo.testingPages.HotelBookingPage;


public class Pages {
	public static HotelBookingPage HBP;
	
	
	public static void loadAllPages(WebDriver driver) {
		HBP = PageFactory.initElements(driver, HotelBookingPage.class);
	}
}
