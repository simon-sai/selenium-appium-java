@demo @android @demoAndroid
Feature: Open Mobile App

  Scenario: Open app alrady in device
    When I open android app from env
    And I wait 2 seconds
    And I close android app from app
