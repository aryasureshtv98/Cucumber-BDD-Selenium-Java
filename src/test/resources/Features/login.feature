Feature: Feature to test Login functionality
@login
  Scenario Outline: Check Login is successfull with valid credentials
    Given User is on Login page
    When User enters valid <Username> and valid <Password>
    And Clicks on Login button
    Then User is able to login and navigated to the homepage

    Examples: 
      | Username  | Password    |
      | student   | Password123 |
      | student12 | Password123 |
      | student   | Pass        |
      | student12 | Pass        |


