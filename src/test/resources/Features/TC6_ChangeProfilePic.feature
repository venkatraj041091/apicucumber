Feature: ProfilePicture Module API Automation

  Scenario: Get User LogToken From Login Endpoint
    Given User add header with multipart
    When User add pic in the formdata
    And User send "POST" request for updatepic endpoint
    Then User verify the status code is 200
    Then User verify the login response body message present as "Profile updated Successfully" in Login page 