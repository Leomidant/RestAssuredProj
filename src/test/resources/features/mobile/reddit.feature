Feature: Reddit App

  @Mobile-Test-1 @mobile
  Scenario: User is not able to log in with incorrect credentials
    Given the user is on welcome page
    And the user clicks on use email or username button
    And the user is on login page
    And the user enters username "test" and password "test123"
    And the user clicks on continue button
    #I wanted to check error message as well but reddit app and appium inspector has some issue on login page, It is showing black page and I couldn't locate error element
    Then the user is on login page

  @Mobile-Test-2 @mobile
  Scenario: User is  able to log in with correct credentials
    Given the user is on welcome page
    And the user clicks on use email or username button
    And the user is on login page
    And the user enters username "vaxomalakmadze@gmail.com" and password "test1234"
    And the user clicks on continue button
    And the user sees notification permission pop up
    And the user denies notification permission
    Then the user sees all page buttons

  @Mobile-Test-3 @mobile
  Scenario: User is able to navigate to 4 main pages
    Given the user is on welcome page
    And the user clicks on use email or username button
    And the user is on login page
    And the user enters username "vaxomalakmadze@gmail.com" and password "test1234"
    And the user clicks on continue button
    And the user sees notification permission pop up
    And the user denies notification permission
    And the user sees that home page button is selected
    And the user sees all page buttons
    And the user clicks on community page button
    And the user sees that community page button is selected
    And the user sees community page title
    And the user clicks on chat page button
    And the user sees that chat page button is selected
    And the user sees chat page title
    And the user clicks on inbox page button
    And the user sees that inbox page button is selected
    And the user sees inbox page title
