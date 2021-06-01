@wip
Feature: Test to check if background keyword will repeat steps from other feature files and implement them to separate
  step_def classes

  Background:
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed

    Scenario: go to apple homepage
      Given I am on the apple home page "https://www.apple.com/"
      Then I should see "Apple" as my title