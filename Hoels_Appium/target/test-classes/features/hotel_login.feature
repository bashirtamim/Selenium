@mobile-regression @hotel
Feature: Verify hotel conditions

  Background:
    Given I click on ok button on splash screen
    And I click on menu button on splash screen

  @mobile-regression @hotel-1
  Scenario: Verify invalid login for hotel app
    Given I click on sign in button on splash screen
    When I enter "test@email.com" into username text field on sign in screen
    And I enter test1234 into password text field on sign in screen
    And I click on sign in button on sign in screen
    Then I verify invalid sign in error message

  @mobile-regression @hotel-2
  Scenario: Verify invalid find a booking for hotel app
    Given I click on your reservation button on splash screen
    And I enter mohamamd into lastname field on Find a Booking screen
    And I click On submit button on find a booking screen
    Then I verify invalid reservation name error message