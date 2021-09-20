Feature: Enter Coursers
  Scenario: Enter Courses
    Given I open Chrome browser and go to Main page
    Then I enter username and password
    Then I wait to enter captcha
    Then I click Courses menu on Landing page
    Then I read excel data and create courses and lessons