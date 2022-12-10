@stateid

Feature: GetStateId Module API Automation

  Scenario: Get User getstateid From state Endpoint
    Given User add header
    When User send "GET" request for state endpoint
    Then User verify the status code is 200
    Then User verify the stateid response body present as "Tamil Nadu" and get the statenumber saved
