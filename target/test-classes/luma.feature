Feature: Login Feature

  Scenario: User login with valid credentials
    Given user is on login page
    When user enters credentials
      | Email                    | Password      |
      | gowthamluma182@gmail.com | GowPoc@123456 |
      |                          |               |
    Then user should be navigated to the home page
