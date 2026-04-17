package com.capgemini.sprint.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\java\\com\\capgemini\\sprint\\featurefile\\Flight.feature"},glue = "com.capgemini.sprint.stepdefinition" ,dryRun = false)
public class OneWayFlightRunner extends AbstractTestNGCucumberTests {

}
