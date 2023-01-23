@userRemoveFromCartTest
Feature: userRemoveFromCart
  In order to remove from cart
  As a user
  I need to add an item and then remove it

  Scenario: remove an item for cart
    Given user navigates to home page
    When opens a galaxy S6 item and adds it to cart
    Then user removes item from cart
