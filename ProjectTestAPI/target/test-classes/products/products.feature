Feature: Products
  As an Admin
  I want to create new product
  So that the product will be added

  Scenario: GET - As an Admin I have to be able to get all products
    Given I set an endpoint for get all products
    When I request get all products
    Then I validate the status code is 200
    And I validate the body is not null

#  Scenario Outline: GET - As an Admin I have to be able to get a product by id
#    Given I set an endpoint for get product by id <id>
#    When I request get product by id
#    Then I validate the status code <status_code>
#    And I validate the "<message>"
#    Examples:
#    |id | status_code | message |

  Scenario Outline: GET - As an Admin I have to be able to get a product by id
    Given I set an endpoint for get product by <id>
    When I request get product by <id>
    Then I validate the status code <status_code>
    And I validate the "<message>" after get product by <id>
    Examples:
    |id |status_code|message|
    |300|404        |failed |
    |1744|200        | success|

#coba benerin lagi

  Scenario Outline:POST - As an Admin I have to be able to create a new product
    Given I set an endpoint for post create product
    When I request post create product with "<name>" and <price> and <categories[]>
    Then I validate the status code <status_code>
    And I validate the "<message>"
    Examples:
      |name        |price   | categories[] | status_code| message |
      |Flare Skirt | 250000 | 565          |200         |success  |
      |            | 150000 | 565          |500         |ERROR: new row for relation \"products\" violates check constraint \"products_name_check\" (SQLSTATE 23514)|




#ga kepake

# Scenario: As an Admin I have to be able to create product
#   Given I set an endpoint for post create product
#   When I request post create product
#   Then I validate the status code is 200
#   And I validate the data detail after create product

#  Scenario Outline: As an Admin I have to be able to create new product
#    Given I set an endpoint for post create product
#    When I request post create product with "<name>" <price> <categories>
#    Then I validate the status code <status_code>
#    And I validate the data detail "<message>" after create product
#    Examples:
#    |name         |price    | categories  | status_code | message |
#    |Flare Skirt  | 250000  | 565         | 200         | success |
#    |             | 150000  |555          |500          |ERROR: new row for relation \"products\" violates check constraint \"products_name_check\" (SQLSTATE 23514)|



#Scenario: Create product with null name
#  Given I set an endpoint for post create product
#  When I request post create product with null name
#  Then I validate the status code is {int}
#  And I validate the message
