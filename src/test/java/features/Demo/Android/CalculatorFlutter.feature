@demo @android @calculator @demoAndroid
Feature: Using flutter calculator

  Background:
    Given Calculator app already installed

  Scenario: Plus two digi
    When I open calculator app
    And I wait 2 seconds
    And I close calculator app
