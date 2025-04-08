Feature: Operations Api Tests
  Background:
    Given User logs in to the app through authenticate api and gets a token in response
    Scenario: View All Operations
      When User is at "/api/operations" endpoint with query params as "page" being 0,"size" being 20,"sort" being "date" and "eagerload" being "true"
      Then User response of Status Code 200