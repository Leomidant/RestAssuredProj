Feature: Authorize Endpoint
  Background:
    Given I set base URL

  Scenario: User is able to authorize with correct credentials
    Given User sends request with correct credentials
    And The user gets status code 10 in message body
    And The user gets message "success" in message body
    Then Token value in response body is not empty

  Scenario: User is able to get information
    Given User sends get request with authorization token
    And The user gets status code 10 in message body
    Then The user gets message "SUCCESS" in message body