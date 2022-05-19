Feature: Login
  As a user
  I want to login
  So that I can see all the product

  Background:
    Given I am on the login page

  @Login
  Scenario Outline: Login Scenario
    When I input "<email>" email
    And I input "<password>" password
    And I click login button
    Then I get the "<result>"

    Examples:
    |email|password|result|
    |jasrivika@gmail.com|Doremi@123|homepage|
    |jasri@gmail.com    |Doremi@123|record not found|
    |jasrivika@gmail.com|hahaha    |email or password is invalid|
    |jasri@gmail.com    |hahaha    |record not found            |
    |                   |Doremi@123|email is required           |
    |jasrivika@gmail.com|          |password is required        |
    |                   |          |email is required           |