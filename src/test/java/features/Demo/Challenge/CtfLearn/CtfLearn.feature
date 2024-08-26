@demo @web @demoWeb
Feature: Create challenge
  As a user of CTF learner (https://ctflearn.com)
  I want to create a challenge
  So that I can view my created challenges in My Challenge

  Background:
    Given I already login on CTF Learn
    And I see Dashboard page opened

  Scenario: Create challenge successfully
    When I open Create Challenge page
    Then I see tag "span" has text is "Create A Challenge"
    When I create a random Challenge
    Then I see last challenge name appear
    When I open My Challenge page
    Then I see tag "p" has text is "Click on a challenge to edit or view verification status."
    And I see last challenge name in My Challenge page

  Scenario: Create challenge wrong flag
    When I open Create Challenge page
    And I create a Challenge with wrong flag
    Then I see error message of flag appear
