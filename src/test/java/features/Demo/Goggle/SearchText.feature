@demo @google @web @demoWeb
Feature: Search for flowers
  As a User,
  I want to find a rose
  so that I can see how it look like.

  Scenario: Search for rose
    When I open url "https://google.com?hl=en"
    And I send text "rose plant" to the tag "textarea" has "class" is "gLFyf"
    And I click on tag "input" has "name" is "btnK"
    Then I see tag "h3" has text is "Rose Plants"
