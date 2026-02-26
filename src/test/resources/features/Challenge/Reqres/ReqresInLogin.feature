@demo @api @demoApi
Feature: User Login
  As a user of Reqres (https://reqres.in)
  I want to login.
  So that I can get a token.

  Scenario: Login successfully
    When I call Login API
    Then I see status code is 200
    And I see Login API has new token

  Scenario: Login without password
    When I call Login API without password
    Then I see status code is 400
    And I see error message is "Missing password"

  Scenario: Login without email
    When I call Login API without email
    Then I see status code is 400
    And I see error message is "Missing email or username"
