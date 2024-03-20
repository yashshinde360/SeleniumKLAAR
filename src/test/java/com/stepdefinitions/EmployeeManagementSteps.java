package com.stepdefinitions;

import com.testSteps.EmployeeManagementTestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeManagementSteps {
	EmployeeManagementTestSteps employeeManagementTestSteps= new EmployeeManagementTestSteps();
	
	@When("user clicks on {string} from left hand side menu")
	public void user_clicks_on_from_left_hand_side_menu(String menuOption) {
		employeeManagementTestSteps.clickOnLHSMenu(menuOption);
	}

	@When("user clicks on Add Employee button")
	public void usr_clicks_on_button() {
		employeeManagementTestSteps.clickOnAddEmployeeButton();
	}

	@When("user starts filling required fields of the form")
	public void user_starts_filling_required_fields_of_the_form() throws InterruptedException {
		employeeManagementTestSteps.fillRequiredDetails();
	}

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String button) {
		employeeManagementTestSteps.clickOnButton(button);
	}
	

	@Then("user verifies heading as {string}")
	public void user_verifies_heading_as(String heading) {
		employeeManagementTestSteps.verifyHeading(heading);
	}
	
	@Given("user fills the Employment Details form")
	public void user_fills_the_employment_details_form() {
		employeeManagementTestSteps.fillEmployeDetails();
	}
	
	@When("user fills Onboarding form")
	public void user_fills_Onboarding_form() {
		employeeManagementTestSteps.fillOnboardingForm();
	}
	
	@Then("user verifies success pop-up message")
	public void user_verifies_success_pop_up_message() {
		employeeManagementTestSteps.verifySuccessMessage();
	}

	@Given("user should be on Employee details page")
	public void user_should_be_on_employee_details_page() throws InterruptedException {
		employeeManagementTestSteps.verifyEmployeeDetailsPage();
	}

	@Then("user verifies the data coming on Employee details page")
	public void user_verifies_the_data_coming_on_employee_details_page() throws InterruptedException {
		employeeManagementTestSteps.verifyEmployeeData();
	}
}
