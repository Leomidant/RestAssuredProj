Feature: Authorize Endpoint
  Background:
    Given I set base URL

  @Test-1
  Scenario: User is able to authorize with correct credentials
    Given User sends request with correct credentials
    And The user gets status code 10 in message body
    And The user gets message "success" in message body
    Then Token value in response body is not empty
  @Test-2
  Scenario: User is able to get information with valid session ID
    Given User sends get info request with authorization token
    And The user gets status code 10 in message body
    Then The user gets message "SUCCESS" in message body

  @Test-3
  Scenario: User is not able to get information with invalid session ID
    Given User sends get info request with incorrect authorization token
    And The user does not see status code 10 in message body
    Then The user does not see gets message "SUCCESS" in message body


