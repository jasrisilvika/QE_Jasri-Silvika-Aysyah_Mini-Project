Feature: Register
  As a user
  I want to create my account
  So that I can login to AltaShop

  Background:
    Given I am on the register page

  @Register
  Scenario Outline: Register Scenario
    When I input "<fullname>" fullname
    And input "<email>" email
    And input "<password>" password
    And I click register button
    Then I get "<result>"
    Examples:
    |fullname   |email|password   |result |
    |Jasri Vika |new  |Doremi@123 |login  |
    |Jasri Vika |jasrivika@gmail.com|Doremi@123|warning|
    |           |new                |Doremi@123|warning|
    |Jasri Vika |                   |Doremi@123|warning|
    |Jasri Vika | new               |          |warning|

