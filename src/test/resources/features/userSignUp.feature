Feature: signUp
  In order to sign up
  As a new Customer
  I need to Enter a User and Password combination

  Scenario: sign up on the online store
    Given user navigates to the user sign up page
    When user enters a correct username and password
    Then user signs up in the website
