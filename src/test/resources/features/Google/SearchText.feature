@demo @google @web @demoWeb
Feature: Search for flowers

  Scenario: Search for rose
    When I open url "https://google.com?hl=en"
    And I send text "rose plant" to the tag "textarea" has "class" is "gLFyf"
    And I click on tag "input" has "name" is "btnK"
    Then I see tag "h3" has text is "Rose Plants"

  Scenario: Search for anime
    When I open url "https://google.com?hl=en"
    And I send text "anime movie" to the tag "textarea" has "class" is "gLFyf"
    And I click on tag "input" has "name" is "btnK"
    Then I see tag "div" has text is "What to watch"
