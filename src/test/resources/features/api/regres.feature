Feature: Regresin
  Background:
    Given I set base URL

    @Test-1 @api
    Scenario: Retrieve and Validate User List
      Given the user retrieves the list of users with the following parameters:
        | page     | 2 |
        | per_page | 4 |
      And the response status code should be 200
      And the response contains data for 4 users
      Then the user validates that the user IDs start from "5"
#
    @Test-2 @api
    Scenario: Retrieve User by ID and Validate Data
      Given the user retrieves the user with it's id "4"
      And the response status code should be 200
      Then the user response contains user with following parameters:
        | id         | 4                  |
        | email      | eve.holt@reqres.in |
        | first_name | Eve                |
        | last_name  | Holt               |

    @Test-3 @api
    Scenario: Login Attempt with Incorrect Credentials
      Given the user log in with following parameters:
        | username | testbeka              |
        | email    | testbeka@testbeka.com |
        | password | test1234              |
      And the response status code should be 400
      Then the response contains the error message "user not found"

    @Test-4 @api
    Scenario: Delete User and Verify Deletion
      Given the user retrieves the user with it's id "8"
      And the user deletes user with id "8"
      Then the response status code should be 204
      #We should check if user with id 8 still exists with same information but as its demo API it not actually deletes the user
      #And the user retrieves the user with it's id "8"

    @Test-5 @api
    Scenario: Update User and Validate Response
      Given the user updates user with id "6"
      And the response status code should be 200
      Then the response contains correct update time










