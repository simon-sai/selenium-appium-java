@demo @android @demoAndroid
Feature: Using flutter calculator

  Background:
    Given Calculator app already installed

  Scenario: Open calculator app
    When I open calculator app
    And I wait 2 seconds
    And I close calculator app
