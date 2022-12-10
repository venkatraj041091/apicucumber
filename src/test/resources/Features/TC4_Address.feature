@Address
Feature: Address Module API Automation
@scanerio4
  Scenario Outline: Verify and User Address to the application through api
    Given User add header and bearer authorization for accesing address endpoint
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>", <state> , <city> , <country> ,"<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for adduseraddress endpoint
    Then User verify the status code is 200
    Then User verify the adduseraddress reponse message matches "Address added successfully"

    Examples: 
      | first_name | last_name  | mobile     | apartment  | state | city | country | zipcode | address       | address_type |
      | venkatraj  | kaliarajan | 9597520501 | vivioapper |    35 | 4456 |     152 |  658002 | 28/67 thangam | hometown     |

  Scenario Outline: Verify and User AddressId to the application through api
    Given User add header and bearer authorization for accesing address endpoint
    When User add request body for add new addressid "<AddressId>","<first_name>","<last_name>","<mobile>", <state> , <city> , <country> ,"<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateuseraddress endpoint
    Then User verify the status code is 200
    Then User verify the userputaddress reponse message matches "Address updated successfully"

    Examples: 
      | first_name | last_name  | mobile     | apartment  | state | city | country | zipcode | address       | address_type |
      | venkatraj  | kaliarajan | 9597520501 | vivioapper |    35 | 4456 |     152 |  658002 | 28/67 thangam | hometown     |

  Scenario: Verify and User getAddress to the application through api
    Given User add header and bearer authorization only accesing address endpoint
    When User send "GET" request for usergetaddress endpoint
    Then User verify the status code is 200
    Then User verify the usergetaddress reponse message matches "OK"

  Scenario Outline: Verify and User DeleteAccount to the application through api
    Given User add header and bearer authorization for accesing address endpoint
    When User add request body for add new address "<AddressId>"
    And User send "DELETE" request for deleteuseraddress endpoint
    Then User verify the status code is 200
    Then User verify the useraddressdelete reponse message matches "Address deleted successfully"

    Examples: 
      | AddressId |
      |     36889 |
