@addToCartTest
Feature: Add To cart
  Login not necessary
  As a concurrent Customer
  I need to get items and add it into the cart

  Scenario: access to the store
    Given user enter in the store
    When user add items in the store
    Then user check the cart
