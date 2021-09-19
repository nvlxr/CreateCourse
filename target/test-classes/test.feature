Feature: Enter Coursers
  Scenario: Enter Courses
    Given I open Chrome browser and go to Main page
    Then I enter username and password
    Then I wait to enter captcha
    Then I click Courses menu on Landing page
    Then I click create a new course
    Then I create new course
    Then I go to lesson page - Will be modified
    Then I create lesson