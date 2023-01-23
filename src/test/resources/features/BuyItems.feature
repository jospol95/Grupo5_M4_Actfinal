@buyItemsTest
Feature: Buy Items
  Login not necessary
  As a concurrent Customer
  I need to get items, add it into the cart and buy it

  Scenario: access to the store
    Given user navigates in the store
    When user is adding items in the store
    Then user buy items into the cart
