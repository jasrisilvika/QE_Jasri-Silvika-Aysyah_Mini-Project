Feature: Transactions
  As an admin
  I want to get all transactions
  So that I can see all transactions

  Scenario Outline: GET - As an admin I have to be able to get all transactions
    Given I set an endpoint for get all transactions
    When I request get all transactions "<tok>"
    Then I validate the status code <status_code>
    And I validate the "<message>" after get all transactions
    Examples:
    |tok|status_code|message|
    |yes  |200        |success|
    |no   |401        |unauthorized|

#  Scenario Outline: POST - As an admin I have to be able to create transactions
#    Given I set an endpoint fot post create transactions
#    When I request post create transaction with <product> and <quantity>
#    Then I validate the status code <status_code>
#    And I validate the "<message>" with <product> and <quantity>
#    Examples:
#    |product|quantity|status_code|message|
#    |1564   |1       |200        |success|
#    |null   |2       |200        |pNull  |
#    |1744   |null    |200        |qNull  |
#    |8000   |1       |200        |pNull  |
#    |900    |1       |401        |unauthorized|