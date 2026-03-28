Feature: Login functionality

  Scenario Outline: Valid login
    Given user is on login page
    When user enters username <username> and password <password>
    And clicks login button
    Then user should be redirected to home page
    Examples:
      | username   | password   |
      |"standard_user"|"secret_sauce"|
  |"locked_out_user"|"secret_sauce"|
#  |"problem_user"   |"secret_sauce"|
#  |"performance_glitch_user"|"secret_sauce"|
#  |"error_user"             |"secret_sauce"|
#  |"visual_user"|"secret_sauce"|
  Scenario Outline: Invalid password
    Given user is on login page
    When user enters username "username" and password "password"
    And clicks login button
    Then error message should be displayed
    Examples:
      | username   | password   |
      |"standard_user"|"wrong_pass"|

  Scenario Outline: Invalid username
    Given user is on login page
    When user enters username "username" and password "password"
    And clicks login button
    Then error message should be displayed
    Examples:
      | username   | password   |
      |"wrong_user"|"secret_sauce"|
  Scenario Outline: Empty credentials
    Given user is on login page
    When user enters username "username" and password "password"
    And clicks login button
    Then error message should be displayed
    Examples:
      | username   | password   |
      |""|""|