Feature: Authentication Endpoint
  Background:
    Given User with url endpoint "http://localhost:9000/api"
    Scenario Template: Valid Credentials test
      When User enters Username "<username>", valid Password "<password>" and RememberMe "<rememberMe>"
      Then User checks if they Receive correct Status Code 200
      Examples:
      |username|password|rememberMe|
      |admin   |admin   |true      |
      |admin   |admin   |false     |
      |user    |user    |true      |
      |user    |user    |false     |
    Scenario Template: Bad Request Credentials
      When User enters incorrect Username "<username>" or incorrect Password "<password>" and RememberMe "<rememberMe>"
      Then User will get Status Code as 400
      Examples:
      |username|password|rememberMe|
      |admin   |        |true      |
      |user    |        |true      |
      |        |admin   |true      |
      |        |user    |true      |