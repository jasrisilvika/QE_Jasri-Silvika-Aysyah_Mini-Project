Feature: categories
  As an admin
  I want to get all categories
  So that I can choose the categories for products

  Scenario: GET - As an admin I have to be able to get all categories
    Given I set an endpoint for GET all categories
    When I request GET all categories
    Then I validate the status code is 200
    And I validate the body is not null

  Scenario Outline: POST - As an admin I have to be able to create a new category
    Given I set an endpoint for POST category
    When I request POST create "<category>"
    Then I validate the status code "<status_code>"
    And I validate the data detail "<categoryEqual>"
    Examples:
    |category|status_code|categoryEqual|
    |gadget  |200        |gadget|
    |        |500        |ERROR: new row for relation \"categories\" violates check constraint \"categories_name_check\" (SQLSTATE 23514)|