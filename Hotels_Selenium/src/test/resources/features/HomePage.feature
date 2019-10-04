@regression
Feature: Home Page feature 

Background: 
Given I am on hotels.com home page.
@HomePageRe-1
Scenario: Verify users will get noticed when search for more than 29 nights

When I enter 'Singapore, Singapore' into destination text field on home screen
And I enter date 03/01/18 into Check In text field.
And I enter date  03/31/18 into Check out text field.
And I select 1 room, 1 adult from rooms drop down	
And I click on search button
Then I verify that error message is displayed on search screen.

@HomePageRegression-2
Scenario: Verify users will not be able to search for same date check in and check out

When I enter Empire State Building into destination text field on home screen
And I enter date 08/02/17 into Check In text field.
And I enter date 08/02/17 into Check out text field.
Then I verify the Check In date 08/01/17 is displayed on Check In text field