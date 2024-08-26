@linagora @web @tmail
Feature: Success login to Tmail

  Background:
    Given I am on Tmail Login Page

  Scenario: Login with env username and password
    When I login to Tmail Login Form
    Then I see Compose Button of Tmail Dashboard
