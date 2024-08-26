@linagora @web @tmail
Feature: Success send new with Compose Button

  Background:
    Given I already login with a Twake Account
    And I see Compose Button of Tmail Dashboard

  Scenario: Send a mail to my email
    When I click on Compose Button
    And I see New Message popup
    And I enter email of second user into receiver input
    When I wait 5 seconds
