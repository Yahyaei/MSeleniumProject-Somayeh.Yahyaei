Feature: Test case for log-in function

  Scenario:Create a successful user
    Given I enter my email "PannaAnna@mail.com"
    Given I add my name "somaynaaaaapannaaaaaaaaa"
    Given I add my password "Anna95!1"
    When I click the sign up button
    Then I get a verification message "Check your email"

  Scenario:Create a long username
    Given I enter my email "alex@email.com"
    Given I add my name "Alexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
    Given I add my password "Whatsup11*"
    When I click the sign up button
    Then Alex get a verification message


  Scenario:Create a user that already exist
    Given I enter my email "somayeh@email.com"
    Given I add my name "Somayeh"
    Given I add my password "hello**AA1"
    When I click the sign up button
    Then Somayeh get a verification message


  Scenario:Create a user with no email
    Given I enter my email ""
    Given I add my name "BeritHenriksson"
    Given I add my password "Somi77**-*"
    When I click the sign up button
    Then Berit get a verification message