Feature: Operations Api Tests
  Background:
    Given User logs in to the app through authenticate api and gets a token in response
    Scenario: View All Operations
      When User is at "/api/operations" endpoint with query params as "page" being 0,"size" being 20,"sort" being "date" and "eagerload" being "true"
      Then User response of Status Code 200
#      And User gets response with proper json schema
#      And User gets the body of all fields of each object as:
#      |id|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9"|"10"|
#      |date|"2015-08-05T07:26:26Z"|"2015-08-05T01:55:08Z"|"2015-08-04T22:22:12Z"|"2015-08-04T19:56:27Z"|"2015-08-04T15:21:33Z"|"2015-08-04T17:45:06Z"|"2015-08-04T18:52:27Z"|"2015-08-04T16:22:42Z"|"2015-08-05T10:46:09Z"|"2015-08-04T15:43:55Z"|
#      |description|"near forenenst drive"|"willow opera coordination"|"for modulo"|"dapper"|"enraged parody"|"monster impact pish"|"strict"|"ashamed but"|"truthfully"|"unusual quash"|
#      |amount     |"32304.09"|"27753.54"|||||||||