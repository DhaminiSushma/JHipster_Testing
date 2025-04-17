@api
Feature: Bank Account Endpoint

  Background:
    Given User is at the Base URL

  Scenario: Valid Get Bank Account Requests
    When I send a GET request to endpoint "/bank-accounts"
    Then User checks if they Receive Status Code 200
    Then the response content type should be "application/json"

  Scenario Template: Valid Bank Accounts Post
    When User enters valid "<name>" and "<balance>" at endpoint "/bank-accounts"
    Then User checks if the Status Code is 201
    Examples:
      | name    | balance |
      | Zhongli | 1000.00 |
      | Albedo  | 2000.00 |
      | Klee    | 3000.00 |
      | Diluc   | 4000.00 |
      | Fischl  | 5000.00 |

  Scenario: Invalid Bank Accounts Post
    When User enters empty fields at endpoint "/bank-accounts"
    Then User checks if the Status Code is 405