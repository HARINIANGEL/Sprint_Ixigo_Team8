Feature: One Way Flight Booking on Ixigo

  Scenario Outline: Search for one-way flights
    Given user is on the flight booking page
    When user selects "One Way" trip type
    And user enters source as "<source>"
    And user enters destination as "<destination>"
    And user selects travel date "<travelDate>"
    And user clicks on search button
    Then user should see available One-Way flights

    Examples:
      | source  | destination | travelDate |
      | Chennai | Mumbai      | 25-05-2026 |
      | Delhi   |  Mumbai  | 10-06-2026 |