Feature: Login
  As an Admin
  I want to login
  So that I can buy the product

  Scenario Outline: POST - As an admin i have to be able to login
    Given I set an endpoint for login
    When I request login with "<email>" and "<password>"
    Then I validate the status code <status_code>
    And I validate the "<result>" after login
    And I get the token if "<result>" for other request
    Examples:
    |email              | password |status_code|result |
    |jasrivika@gmail.com|Doremi@123|200        |success|
    |jasvik@mail.com    |Doremi@123|400        |record not found|
    |jasrivika@gmail.com|testes    |400        |email or password is invalid|
    |jasvik@mail.com    |testes    |400        |record not found            |
    |                   |Doremi@123|400        |email is required           |
    |jasriika@gmail.com |          |400        |password is required        |
    |                   |          |400        |email is required           |