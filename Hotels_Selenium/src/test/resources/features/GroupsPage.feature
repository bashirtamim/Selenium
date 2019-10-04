@regression
Feature: Groups Page feature 

Background:
Given I am on Groups and Meetings page in hotels.com website
@GrouspsRegression-1
Scenario: Verify pop-up box at the bottom right of the page with secret prices message on the home page

When I enter Sydney NSW 2000, Australia into destination text field on Gourps and Meetings Page
And I enter date 08/01/2017 into Check In text field on Groups Page
Then I verify that 08/02/2017 is selected as default for Check-out date on Groups Page
And I click on close button in the date dropdown menu on Groups Page
And I click on group type dropdown menu and choose business meeting
And I enter 1 into the number rooms per night text input field
And I click on ideal star rating and select 2-4 star

And I enter John Doe into full name text input field 
Then I verify that full name textfield gets separated into first name and last name input field
And I enter johndavis@gmail.com into Email text input field
And I click on continue button in Groups Page
Then I verify that a message is displayed with individual booking link and room number being minimum 9
When I click on link for individual booking
Then I verify that I am on hotels.com home page
And I verify that a pop-up box suggesting secret prices in displayed on page’s bottom right

@GrouspsRegression-2
Scenario: Verifying contact information and number of links in My Account Summary page

When I click on ‘sign in’ link
Then I verify that I am on sign in page
When I enter shakibnihan786@gmail.com into Email textfield
And I enter hotels88311 into password text input field
And I click on Sign in Button
Then I verify that the page contains “Book Online or call 866-476-8771’
And I verify that the page contains six dropdown at the bottom of the page and get their titles
And I get the titles all the individual links that this page contains
And I verify that Top Destination dropdown contains 24 links
And I verify that Top Countries dropdown contains 10 links
And I verify that Customer Service dropdown contains 5 links
And I verify that Other Expedia Inc. dropdown contains 3 links
And I verify that For Suppliers dropdown contains 6 links
And I verify that User Terms and Privacy Policy dropdown contains 4 links
When I click on Sign out button
Then I verify that I am on log out page

@GrouspsRegression-3
Scenario: Verifying dropdown suggestions, months displayed in check-in/out box, range and duplicate values nightly budget range and error messages displayed in form request box
 
When I scroll down to the bottom of the page
Then I verify that the form request box is on the right side of the page
When I scroll to the top of the page
And I enter S into destination text field on Gourps and Meetings Page
Then I verify that 5 dropdown suggestions are displayed
And I clear the destination textfield
When I click in check in box 
Then I verify that current month and following month is displayed
And I click on close button in the date dropdown menu on Groups Page
When I click on continue button in Groups Page
Then I verify that three specific warning messages are displayed 

Scenario: Verifying dropdown suggestions, months displayed in 
 
When I scroll down to the bottom of the page
Then I verify that the form request box is on the right side of the page
When I scroll to the top of the page
And I enter S into destination text field on Gourps and Meetings Page
Then I verify that 5 dropdown suggestions are displayed
And I clear the destination textfield
When I click in check in box 
Then I verify that current month and following month is displayed
And I click on close button in the date dropdown menu on Groups Page
When I click on continue button in Groups Page
Then I verify that three specific warning messages are displayed 