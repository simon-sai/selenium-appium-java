@linagora @android @tmail @wip
Feature: Success login to Tmail Android

  Background:
    Given I has Tmail app already installed

  Scenario: Login with env username and password
    When I open Tmail app
    And I login as first user on tmail app
    When I take a screenshot
    Then I wait 7 seconds
