Feature: Register
  Scenario Outline: POST - As an admin I have to be able to register new account
    Given I set an endpoint for post create account
    When I request post create account with "<full_name>" and "<email>" and "<password>"
    Then I validate the status code <status_code>
    And I validate the "<message>" after create account "<full_name>"
    Examples:
    |full_name  |email|password   |status_code|message|
    |Jasri Vika |new  |Doremi@123 |200        |success|
    |           |new  |Doremi@123 |400        |fullname is required |
    |Jasri Vika |     |Doremi@123 |400        |email is required |
    |Jasri Vika |new  |           |400        |password is required |
    |Jasri Vika |same |Doremi@123 |400        |required|