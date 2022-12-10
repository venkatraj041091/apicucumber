@Cityid
Feature: GetCityId Module API Automation

  Scenario: Get User cityname From getcitylist Endpoint
    Given User add header and bearer authorization only for accesing address endpoint
    When User add request body for add new state "<state_value>"
    And User send "POST" request for city endpoint
    Then User verify the status code is 200
    Then User verify the login response body cityname present as "Vriddhachalam" and get the cityId saved

    