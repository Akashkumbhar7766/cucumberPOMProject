Feature: Login functionality

  Scenario: Login with multiple credentials
    Given user is on the login page
    When user enters credentials
      | username | password   |
      | admin    | admin123   |
      | user1    | pass123    |
      | user2    | pass456    |
    Then user should be logged in successfully