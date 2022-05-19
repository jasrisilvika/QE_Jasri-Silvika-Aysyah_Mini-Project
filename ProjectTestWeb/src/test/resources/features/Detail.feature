Feature: Detail
  As an user
  I want to know detail product
  So that I can buy product that I want

  Scenario Outline: Open detail product
    Given I am on homepage
    When I get detail in card <product>
    And I click detail button <product>
    Then I validate the the detail product <product>
    Examples:
    |product|
    |11     |
    |24     |
    |35     |
    |1     |