Feature: Login
  As an user
  I want to login
  So that I can buy the product

  Scenario Outline: Login
    Given I am on the homepage
    When I click login icon
    And I validate on login page
    And I input "<email>" and "<password>"
    And I click login button
    Then I validate the "<result>"
    Examples:
    |email|password|result|
    |jasrivika@gmail.com|Doremi@123|success|
    |                   |Doremi@123|email can not empty|
    |jasrivika@gmail.com|          |password can not empty|
    |                   |          |req                   |
    |jasrvi@mail.com    |Doremi@123|Email atau password tidak valid.|
    |jasrivika@gmail.com|tes122    |Email atau password tidak valid.|
    |jasrvi@gmail.com   |tes123    |Email atau password tidak valid.|


  Scenario Outline: Logout
    Given I am on the homepage
    And I click login icon
    And I validate on login page
    And I input "<email>" and "<password>"
    And I click login button
    And I validate the "<result>"
    When I click login button logout button
    Then I validate the "<result>"
    Examples:
    |email|password|result|
    |jasrivika@gmail.com|Doremi@123|success|

