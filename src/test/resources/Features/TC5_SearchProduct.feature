Feature: Searchproduct Module API Automation

  Scenario: Get User Search the product From searchproduct endpoint
   Given User add header and bearer authorization only for accesing address endpoint
    When User add basic authentication for login
    And User send "POST" request for searchproduct endpoint
    Then User verify the status code is 200
    Then User verify the login response body as "OK" message
