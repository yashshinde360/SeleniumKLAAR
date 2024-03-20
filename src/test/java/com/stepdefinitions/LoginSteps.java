package com.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.testSteps.LoginTestSteps;

import driverFactory.InitDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	LoginTestSteps loginTestSteps = new LoginTestSteps();
	@Given("user is on KLAAR admin login screen")
	public void user_is_on_klaar_admin_login_screen() {
		loginTestSteps.navigateToKlaarAdmin();
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String username) {
		loginTestSteps.enterUsername(username);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
		loginTestSteps.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginTestSteps.clickOnLoginButton();
	}
	
	@Then("user should land on {string}")
	public void user_should_land_on(String heading) {
		loginTestSteps.verifyHeading(heading);
	}
	
}
