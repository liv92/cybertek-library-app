@regression
Feature: Datatables task

Scenario: Table columns names
Given I am on the login page
And I login as a librarian
And I click on "Users" link
Then table should have following column names:
  | Actions   |
  | User ID   |
  | Full Name |
  | Email     |
  | Group     |
  | Status    |