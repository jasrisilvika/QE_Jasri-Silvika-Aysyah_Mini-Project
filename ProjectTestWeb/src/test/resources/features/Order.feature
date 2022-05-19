Feature: Order
  Scenario: Order product without login
    Given I am on homepage
    And I click buy button
    And I go to order page
    And I validate on order page
    When I click pay button
    Then I go to login page

  Scenario Outline: Order product with login
    Given I am on the login page
    And I input "<email>" email
    And I input "<password>" password
    And I click login button
    And I get the "<result>"
    And I click buy button
    And I go to order page
    And I validate on order page
    When I click pay button
    Then I go to transaction page
    Examples:
    |email|password|result|
    |jasrivika@gmail.com|Doremi@123|homepage|
