package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;	
	}
	
	public WebElement getuserNameField() {
		return driver.findElement(By.id("txtUsername"));
	}
	
	public WebElement getPasswordField() {
		return driver.findElement(By.id("txtPassword"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//button[text()=\"Login\"]"));
	}
	
	public WebElement getHeading() {
		return driver.findElement(By.cssSelector(".topbar-title"));
	}
}
