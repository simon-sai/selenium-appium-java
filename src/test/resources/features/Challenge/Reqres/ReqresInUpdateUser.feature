@demo @api @demoApi
Feature: Update an User
  As a user of Reqres (https://reqres.in)
  I want to get an user data.
  So that I can update user information

  Background:
    Given I already login with API
    Then I see status code is 200
    And I see Login API has new token

  Scenario: Update date for user 3
    When I get user data has id is 3
    Then I see status code is 200
    And I see first name is "Emma"
    And I change first name of current user to "Simon"

  Scenario: Update date for user not exist
    When I get user data has id is 99999
    Then I see status code is 404
