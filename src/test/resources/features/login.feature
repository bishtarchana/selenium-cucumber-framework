Feature: Login Functionality

  Scenario: Login with valid credentials
    Given User is on login page
    When User enters valid username and password
    Then User should be logged in successfully

  Scenario: Login with invalid credentials
    Given User is on login page
    When User enters invalid username and password
    Then User should see error message
