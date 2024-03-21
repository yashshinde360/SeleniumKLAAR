Feature: To test KLAAR Admin application
	As an user
	I want to navigate to KLAAR Admin
	So that I can verify Add Employee, form filling functionality of KLAAR
		
Scenario: Login to KLAAR admin application
	Given user is on KLAAR admin login screen 
	When user enters username as "Admin"
	And user enters password as "SyN6Ktl@O0"
	And user clicks on Login button
	Then user should land on "Employee Management"
	
Scenario: User fills the required data
	Given user should land on "Employee Management"
	When user clicks on "Employee Management" from left hand side menu
	And user clicks on Add Employee button
	And user starts filling required fields of the form
	And user clicks on "Next" button
	Then user verifies heading as "Personal Details"
	
Scenario: User clicks on Next button and verifies heading as "Employment Details heading"
	Given user verifies heading as "Personal Details"
	When user clicks on "Next" button
	Then user verifies heading as "Employment Details"
	
Scenario: User fills the Employement Deatails form
	Given user verifies heading as "Employment Details"
	When user fills the Employment Details form
	And user clicks on "Next" button
	Then user verifies heading as "Contact Details"
	
Scenario: User clicks on Next button and verifies heading as "Onboarding"
	Given user verifies heading as "Contact Details"
	When user clicks on "Next" button
	Then user verifies heading as "Onboarding"
	
Scenario: User fills the Onboarding form and verifies success message
	Given user verifies heading as "Onboarding"
	When user fills Onboarding form
	And user clicks on "Save" button
	Then user verifies success pop-up message
	
Scenario: User verifies the data on Employee details page 
	Given user should be on Employee details page
	Then user verifies the data coming on Employee details page

	
	
	

	
	