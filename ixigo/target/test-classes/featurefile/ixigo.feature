
Feature: Bus booking in ixigo

  Scenario: User searches and books a bus successfully
    Given user launches the ixigo website
    When user selects Bus option
    And user enters source city 
    And user enters destination city 
    And user selects travel date
    And user clicks on search button
    Then user should see list of available buses

    When user selects a bus
    And user selects seat
    And user clicks on continue

    Then user should be navigated to passenger details page
    When user enters passenger details
    And user enters contact details
    And user clicks on proceed to payment

    Then user should be navigated to payment page