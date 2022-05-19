Feature: Cart
  Scenario Outline: Add and remove product
    Given I am on homepage
    When I click buy button
    Then I go to order page
    And I validate on order page
    And I click "<symbol>" button
    And I validate the "<detail>" detail
    Examples:
    |symbol|detail|
    |+     |add   |
    |-     |remove|
