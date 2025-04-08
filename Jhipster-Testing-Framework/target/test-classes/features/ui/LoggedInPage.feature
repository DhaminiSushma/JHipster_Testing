Feature: Jhipster Home App actions after Logging in
  Background:
    Given User is on HomePage and presses sign in
    And User enters valid username , valid password and rememberMe:
    |username   |admin   |
    |password   |admin   |
    |rememberMe |true    |
    And User is now Logged in to the page with Title "Welcome, Java Hipster!"
    Scenario:
      When User navigates to Bank Account Page
      Then User gets Page Title as "JhipsterSampleApplication"