Feature: Rating
  As an admin
  I want to give a rating to the product
  So that other people will know the rating of the product

  Scenario Outline: As an admin I have to be able to get rating of the product
    Given I set an endpoint for get rating <id>
    When I request get rating of product <id>
    Then I validate the status code <status_code>
    And I validate the "<result>" after get rating
    Examples:
    |id|status_code|result|
    |1799|200       |success|
    |221|200       |failed |

  Scenario Outline: As an admin I have to be able to give a rating to the product
    Given I set an endpoint for add rating <id>
    When I request add rating <star> <id> "<tok>"
    Then I validate the status code <status_code>
    And I validate the "<result>" after add rating <star>
    Examples:
    |id|star|tok|status_code|result|
    |1789|1  |yes|200        |success|
    |1655|2  |yes|200        |success|
    |1677|3  |yes|200        |success|
    |1587|4  |yes|200        |success|
    |1598|5  |yes|200        |success|
    |1578|9  |yes|500        |ERROR: new row for relation \"ratings\" violates check constraint \"ratings_count_check\" (SQLSTATE 23514)|
    |165|5  |yes|500        |record not found                                                                                          |
    |868|1  |no |401        |unauthorized                                                                                              |


