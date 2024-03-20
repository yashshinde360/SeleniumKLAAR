package com.testSteps;



import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;

import driverFactory.InitDriver;
import utils.ConfigReader;
import utils.Helper;

public class LoginTestSteps {
	InitDriver initDriver = new InitDriver();
	Helper helper = new Helper();
	public WebDriver driver = initDriver.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	ConfigReader configReader;
	Properties prop;

	public void navigateToKlaarAdmin() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		String homeUrl = prop.getProperty("url");
		driver.get(homeUrl);
	}

	public void enterUsername(String username) {
		helper.waitForElementToBeVisible(loginPage.getuserNameField());
		loginPage.getuserNameField().sendKeys(username);
	}

	public void enterPassword(String password) {
		helper.waitForElementToBeVisible(loginPage.getPasswordField());
		loginPage.getPasswordField().sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		helper.waitForElementToBeVisible(loginPage.getLoginButton());
		loginPage.getLoginButton().click();;
	}
	
	public void verifyHeading(String heading) {
		helper.waitForElementToBeVisible(loginPage.getHeading());
		Assert.assertTrue(loginPage.getHeading().getText().contains(heading));
	}
}