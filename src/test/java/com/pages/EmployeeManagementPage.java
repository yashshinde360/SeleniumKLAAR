package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeManagementPage {
	WebDriver driver;
	public EmployeeManagementPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public WebElement getLHSMenu(String menuOption) {
		return driver.findElement(By.xpath("//a[@data-tooltip='"+menuOption+"' and not(contains(@class, 'hidden'))]"));	
	}
	
	public WebElement getAddEmployeeButton() {
		return driver.findElement(By.id("addEmployeeButton"));	
	}
	
	public WebElement getFirstName() {
		return driver.findElement(By.id("first-name-box"));	
	}
	
	public WebElement getMiddleName() {
		return driver.findElement(By.id("middle-name-box"));	
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.id("last-name-box"));	
	}
	
	public WebElement getAutoGenerateToggle() {
		return driver.findElement(By.xpath("//input[@id=\"autoGenerateEmployeeId\"]/parent::div"));
	}
	
	public WebElement getEmployeeIdBox() {
		return driver.findElement(By.id("employeeId"));
	}
	
	public WebElement getJoinedDateBox() {
		return driver.findElement(By.id("joinedDate"));
	}
	
	public WebElement getLocatioDropDown() {
		return driver.findElement(By.id("location"));
	}
	
	public WebElement getCreateLoginDetailsToggle() {
		return driver.findElement(By.xpath("//input[@id=\"hasLoginDetails\"]/parent::div"));
	}
	
	public WebElement getUserNameField() {
		return driver.findElement(By.xpath("//input[@id='username']"));
	}
	
	public WebElement getPasswordField() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getConfirmPasswordField() {
		return driver.findElement(By.id("confirmPassword"));
	}
	
	public WebElement getAdminRoleDropdown() {
		return driver.findElement(By.id("adminRoleId"));
	}
	
	public WebElement getAllRegionToggle() {
		return driver.findElement(By.xpath("//input[@id=\"allRegions\"]/parent::div"));
	}
	
	public WebElement getSelectRegionBox() {
		return driver.findElement(By.cssSelector("[placeholder=\"Select Regions\"]"));
	}
	
	public WebElement getSearchedRegion() {
		return driver.findElement(By.cssSelector("[id=\"dropdown-multyselect\"] li"));
	}
	
	public WebElement getSelectedRegion() {
		return driver.findElement(By.cssSelector(".form-row .oxd-modify-region-country-name div"));
	}
	
	public WebElement getSwitchForSelectedRegion() {
		return driver.findElement(By.xpath("//input[@id=\"selectedLocationsOnly_IN\"]/parent::div"));
	}
	
	public WebElement getLocationBox() {
		return driver.findElement(By.cssSelector("[placeholder=\"Select Locations\"]"));
	}
	
	public WebElement getButton(String button) {
		return driver.findElement(By.xpath("//button[text()='"+button+"']"));
	}
	
	public WebElement getHeading(String heading) {
		return driver.findElement(By.xpath("//h4[text()='"+heading+"']"));
	}
	
	public WebElement getEmployementStatus() {
		return driver.findElement(By.id("employment_status_id"));
	}
	
	public WebElement getCommentBox() {
		return driver.findElement(By.cssSelector("[id=\"comment\"]"));
	}
	
	public WebElement getEventTemplate() {
		return driver.findElement(By.cssSelector("[id=\"eventTemplate_inputfileddiv\"] input"));
	}
	
	public WebElement getEventTemplateOptions(String option) {
		return driver.findElement(By.xpath("//span[text()='"+option+"']"));
	}
	
	public WebElement getSuccessMessage() {
		return driver.findElement(By.cssSelector(".toast.toast-success"));
	}
	
	public WebElement getProfileTab() {
		return driver.findElement(By.cssSelector("[automation-id=\"menu_employee_profile_Profile\"] a"));
	}
	
	public WebElement getFirstNameOnDetails() {
		return driver.findElement(By.id("firstName"));
	}
	
	public WebElement getLastNameOnDetails() {
		return driver.findElement(By.id("lastName"));
	}
	
	public WebElement getTabsOnEmployeeDetails(String tabName) {
		return driver.findElement(By.xpath("//a[contains(@class,'top-level-menu-item') and text()='"+tabName+" ']"));
	}
	
	public WebElement getJoinedDate() {
		return driver.findElement(By.xpath("[id=\"joined_date\"]"));
	}
	
	public WebElement getEmployeeStatus() {
		return driver.findElement(By.xpath("[id=\"joined_date\"]"));
	}
}
