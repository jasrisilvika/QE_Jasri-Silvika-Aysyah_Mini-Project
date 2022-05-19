Feature: Register
  As a user
  I want to create my account
  So that I can login to AltaShop

  Scenario Outline: Register scenario
    Given I am on the homepage
    And I click login icon
    And I click register menu
    When I input fullname "<fullname>"
    And I input email "<email>"
    And I input password "<password>"
    And I click register button
    Then I validate the "<result>" after register
    Examples:
    |fullname   |email|password   |result |
    |Vika Jasri |new|Doremi@123 |success|
    |Vika Jasri |jasrivika@gmail.com|Doremi@123|Gagal :(|
    |           |new                |Doremi@123|fullname can not empty|
    |Vika Jasri |                   |Doremi@123|email can not empty|
    |Vika Jasri |new                |          |password can not empty|
    |           |                   |          |reqAll                |