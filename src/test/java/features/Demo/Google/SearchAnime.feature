@demo @google @web @demoWeb
Feature: Use google to search anime picture

  Scenario: Search for hinata
    When I open url "https://google.com?hl=en"
    And I send text "hinata" to the tag "textarea" has "class" is "gLFyf"
    And I click on tag "input" has "name" is "btnK"
    Then I see tag "div" has text is "Hinata Hyuga"

  Scenario: Search for mikasa
    When I open google homepage
    And I search with keyword "mikasa"
    Then I see result relate to "Mikasa Ackerman"
