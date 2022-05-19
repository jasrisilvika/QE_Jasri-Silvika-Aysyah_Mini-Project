Feature: Buy
  As an user
  I want to see all product
  So that I can buy the product

  Scenario Outline: Buy
    Given I am on the homepage
    When I click the buy button <value>
    Then I validate the cart <value>
    Examples:
    |value|
    |1    |
    |2    |
    |3    |
    |4    |