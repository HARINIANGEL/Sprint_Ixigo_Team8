package com.capgemini.sprint.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.capgemini.sprint.Utility.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseClass{


	    private WebDriver driver;

	    @Before
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }
	}


