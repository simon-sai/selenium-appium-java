@demo @api @demoApi
Feature: Get an User
  As a user of Reqres (https://reqres.in)
  I want to get an user data.
  So that I can see user information

  Background:
    Given I already login with API
    Then I see status code is 200
    And I see Login API has new token

  Scenario: Get user data 2
    When I get user data has id is 2
    Then I see status code is 200
    And I see first name is "Janet"

  Scenario: Get user data 3
    When I get user data has id is 3
    Then I see status code is 200
    And I see first name is "Emma"

  Scenario: Get user data not exist
    When I get user data has id is 99999
    Then I see status code is 404
