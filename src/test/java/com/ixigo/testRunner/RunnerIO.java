package com.ixigo.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"./src/test/java/com/ixigo/featureFile/HotelBooking.feature"},glue = "com.ixigo.stepdefinition" ,dryRun = true)
public class RunnerIO extends AbstractTestNGCucumberTests{

}