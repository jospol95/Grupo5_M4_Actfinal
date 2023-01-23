@loginTest
Feature: Login
  In order to login
  As a concurrent Customer
  I need to Enter a User and Password combination

  Scenario: login on the online store
    Given user navigates to the user login page
    When user enters username and password
    Then user login in the website
