package com.ixigo.testing.stepdefinition;

import com.ixigo.testing.utilities.BaseClass;
import com.ixigo.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class seatAvailabilityTest {

@Given("click the train module from the home")
public void click_the_train_module_from_the_home() {
    Pages.hp.clickTrains();
}
@Given("click the seat availability module")
public void click_the_seat_availability_module() {
   Pages.tp.clickseat();
}
@When("Enter the station for ticket booking")
public void enter_the_station_for_ticket_booking()  {
    Pages.ts.enterstation("New Delhi (NDLS)", "C Shivaji Mah T (CSMT)");
    
}
@When("click the check availability button")
public void click_the_check_availability_button() {
  
}
@When("click the filter for booking")
public void click_the_filter_for_booking() {
    
}
@When("click the seat to book")
public void click_the_seat_to_book() {
    
}
@When("click the seat person type")
public void click_the_seat_person_type() {
   
}
@When("click the ticket price to book")
public void click_the_ticket_price_to_book() {
    
}
@When("Enter the passenger details")
public void enter_the_passenger_details() {
   
}
@Then("verify the payment page")
public void verify_the_payment_page() {
    
}

}
