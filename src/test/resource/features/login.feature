@login
  Feature: login
   Test successfully and unsuccessfully login and logout

   @smokeTest
   Scenario: User should be able to login using valid credentials
    Given I navigate to login page
    When  I login as "attivanm@hotmail.com" with password "12dejunio"
    Then I should login successfully

