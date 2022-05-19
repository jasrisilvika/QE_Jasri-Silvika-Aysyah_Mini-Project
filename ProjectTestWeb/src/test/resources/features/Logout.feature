Feature: Logout

  Scenario Outline: Logout
    Given I am on the login page
    And I input "<email>" email
    And I input "<password>" password
    And I click login button
    And I get the "<result>"
    When I click profile icon
    And I click logout button
    Then I go to login page
    Examples:
    |email|password|result|
    |jasrivika@gmail.com|Doremi@123|homepage|