Feature: Comment
  As an admin
  I want to give a comment to the product
  So that other people will know the comment of the product

  Scenario Outline: GET - As an admin I have to be able to get comment of the product
    Given I set an endpoint for get comment <id>
    When I request get comment of product <id>
    Then I validate the status code <status_code>
    And I validate the "<result>" after get comment
    Examples:
    |id|status_code|result|
    |1564|200       |success|


  Scenario Outline: As an admin I have to be able to give a comment to the product
    Given I set an endpoint for add comment <id>
    When I request add comment "<comment>" <id> "<tok>"
    Then I validate the status code <status_code>
    And I validate the "<result>" after add comment "<comment>"
    Examples:
    |id|comment|tok|status_code|result|
    |1647|keren produknya|yes|200|success|
    |772|               |yes|500|ERROR: new row for relation \"comments\" violates check constraint \"comments_content_check\" (SQLSTATE 23514)|
    |225|good           |no |401|unauthorized                                                                                                  |
