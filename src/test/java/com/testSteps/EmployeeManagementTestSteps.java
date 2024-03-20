package com.testSteps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.text.RandomStringGenerator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.pages.EmployeeManagementPage;

import driverFactory.InitDriver;
import utils.Helper;

public class EmployeeManagementTestSteps {
	InitDriver initDriver = new InitDriver();
	Helper helper = new Helper();
	public WebDriver driver = initDriver.getDriver();
	EmployeeManagementPage employeeManagementPage = new EmployeeManagementPage(driver);
	RandomStringGenerator stringName = RandomStringGenerator.builder().withinRange('A', 'z').build();
	Random random = new Random();

	String firstName;
	String lastName;
	String fiveDaysAfter;

	public void clickOnLHSMenu(String menuOption) {
		helper.waitForElementToBeClickable(employeeManagementPage.getLHSMenu(menuOption));
		employeeManagementPage.getLHSMenu(menuOption).click();
	}

	public void clickOnAddEmployeeButton() {
		helper.waitForElementToBeClickable(employeeManagementPage.getAddEmployeeButton());
		employeeManagementPage.getAddEmployeeButton().click();
	}

	public void fillRequiredDetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		helper.waitForElementToBeVisible(employeeManagementPage.getFirstName());
		String firstName = stringName.generate(8);
		employeeManagementPage.getFirstName().sendKeys(firstName);
		String middleName = stringName.generate(8);
		employeeManagementPage.getMiddleName().sendKeys(middleName);
		lastName = stringName.generate(8);
		employeeManagementPage.getLastName().sendKeys(lastName);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		employeeManagementPage.getAutoGenerateToggle().click();
		String randomId = String.valueOf(random.nextInt(100));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		employeeManagementPage.getEmployeeIdBox().sendKeys(randomId);
		Thread.sleep(5000);
		String existingDate = employeeManagementPage.getJoinedDateBox().getAttribute("value");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(existingDate, formatter);
		fiveDaysAfter = String.valueOf(date.plusDays(5));
		employeeManagementPage.getJoinedDateBox().clear();
		employeeManagementPage.getJoinedDateBox().sendKeys(fiveDaysAfter);

		Select location = new Select(employeeManagementPage.getLocatioDropDown());
		location.selectByVisibleText("India Office");

		employeeManagementPage.getCreateLoginDetailsToggle().click();

		employeeManagementPage.getUserNameField().sendKeys(stringName.generate(6));

		employeeManagementPage.getPasswordField().sendKeys("SyN6Ktl@O0");

		employeeManagementPage.getConfirmPasswordField().sendKeys("SyN6Ktl@O0");

		Select adminRole = new Select(employeeManagementPage.getAdminRoleDropdown());
		adminRole.selectByVisibleText("Regional HR Admin");

		employeeManagementPage.getAllRegionToggle().click();
		employeeManagementPage.getSelectRegionBox().clear();
		employeeManagementPage.getSelectRegionBox().sendKeys("India");
		employeeManagementPage.getConfirmPasswordField().click();
		employeeManagementPage.getSelectRegionBox().click();
		employeeManagementPage.getSearchedRegion().click();
		Assert.assertTrue(employeeManagementPage.getSelectedRegion().getText().contains("India"));

		employeeManagementPage.getSwitchForSelectedRegion().click();

		employeeManagementPage.getLocationBox().sendKeys("India Office");
		employeeManagementPage.getConfirmPasswordField().click();
		employeeManagementPage.getLocationBox().click();
		employeeManagementPage.getSearchedRegion().click();
		Thread.sleep(1000);
	}

	public void clickOnButton(String button) {
		helper.waitForElementToBeClickable(employeeManagementPage.getButton(button));
		employeeManagementPage.getButton(button).click();
	}

	public void verifyHeading(String heading) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(heading + " heading is wrong", employeeManagementPage.getHeading(heading).isDisplayed());

	}

	public void fillEmployeDetails() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select employementStatus = new Select(employeeManagementPage.getEmployementStatus());
		employementStatus.selectByVisibleText("Full-Time Permanent");
		employeeManagementPage.getCommentBox().sendKeys(stringName.generate(20));
	}

	public void fillOnboardingForm() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		employeeManagementPage.getEventTemplate().click();
		employeeManagementPage.getEventTemplateOptions("Onboarding - India").click();
	}

	public void verifySuccessMessage() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(employeeManagementPage.getSuccessMessage().getText().contains("Successfully Saved"));

	}

	public void verifyEmployeeDetailsPage() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("employee"));
	}

	public void verifyEmployeeData() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		employeeManagementPage.getTabsOnEmployeeDetails("Personal Details").click();
		Assert.assertNotNull(employeeManagementPage.getFirstNameOnDetails().getText());
		Assert.assertNotNull(employeeManagementPage.getLastNameOnDetails().getText());
		employeeManagementPage.getTabsOnEmployeeDetails("Job").click();
		Assert.assertNotNull(employeeManagementPage.getLastNameOnDetails().getText());
		Assert.assertTrue(employeeManagementPage.getEmployementStatus().getText().contains("Full-Time Permanent"));
	}
}
