@api
Feature: Bank Account Endpoint

  Background:
    Given User is at the base URL

  Scenario: Valid Get Bank Account Requests
    When I send a GET request to endpoint "/bank-accounts"
    Then User checks if they Receive Status Code 200
    Then the response content type should be "application/json"