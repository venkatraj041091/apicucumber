@login

Feature: Login Module API Automation

  Scenario: Get User LogToken From Login Endpoint
    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User verify the status code is 200
    Then User verify the login response body firstname present as "venkatraj" and get the logtoken saved
